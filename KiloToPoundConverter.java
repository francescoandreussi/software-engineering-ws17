public class KiloToPoundConverter extends WeightConverter
{
  public final double originalConversionFactor = 2.205; // Needs to check whether conversionFactor is inverted or not
  private double conversionFactor = 2.205;

  public KiloToPoundConverter() {
    super();
    this.base_conversion = null;
  }

  public KiloToPoundConverter(UnitConverter converter) throws BadChainingException {
    super();
    Class convClass = converter.getClass();
    try {
      if ((mappingFunction.get(convClass)).equals(this.getClass())) {
        this.base_conversion = converter;
      }
    } catch (NullPointerException e) {
      throw new BadChainingException(this.getClass().toString() + " must be chained to "
          + mappingFunction.get(this.getClass()).toString() + " and not to " + convClass.toString());
    }
  }

  public UnitConverter getBaseConverter() {
    return base_conversion;
  }

  public void setConversionFactor(double newFactor) {
    this.conversionFactor = newFactor;
  }

  public double getConversionFactor() {
    return this.conversionFactor;
  }
  
  public double getOriginalConversionFactor() {
    return this.originalConversionFactor;
  }

  public void link(UnitConverter converter) throws BadChainingException {
    Class convClass = converter.getClass();
    try {
      if (mappingFunction.get(this.getClass()).equals(convClass)) {
        this.base_conversion = converter;
      }
    } catch (NullPointerException e) {
      throw new BadChainingException(this.getClass().toString() + " must be chained to "
          + mappingFunction.get(this.getClass()).toString() + " and not to " + convClass.toString());
    }
  }

  public KiloToPoundConverter clone() {
    return new KiloToPoundConverter();
  }

  public double simpleConvert(double inKilos) {
    return inKilos * this.conversionFactor;
  }

  public double convert(double inKilos){
    if (this.base_conversion == null) {
      return inKilos * this.conversionFactor;
    } else {
      return this.base_conversion.convert(inKilos) * this.conversionFactor;
    }
  }

  public String toString(){
    return "Kilogram to Pound Converter";
  }

  public void convertAndPrint(double value) {
    if (this.base_conversion == null) {
      System.out.println(this.toString() + " converted " + value + " kg to " + this.simpleConvert(value) + " lb!");
    } else {
      this.base_conversion.convertAndPrint(value);
      value = this.base_conversion.convert(value);
      System.out.println(this.toString() + " converted " + value + " kg to " + this.simpleConvert(value) + " lb!");
    }
  }
};