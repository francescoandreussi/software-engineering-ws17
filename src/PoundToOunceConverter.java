public class PoundToOunceConverter extends WeightConverter
{
  public final double originalConversionFactor = 16.0; // Needs to check whether conversionFactor is inverted or not
  private double conversionFactor = 16.0;

  public PoundToOunceConverter() {
    super();
    this.base_conversion = null;
  }

  public PoundToOunceConverter(UnitConverter converter) throws BadChainingException {
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

  public PoundToOunceConverter clone() {
    return new PoundToOunceConverter();
  }

  public double simpleConvert(double inPounds) {
    return inPounds * this.conversionFactor;
  }

  public double convert(double inPounds){
    if (this.base_conversion == null) {
        return inPounds * this.conversionFactor;
    } else {
        return this.base_conversion.convert(inPounds) * this.conversionFactor;
    }
  }

  public String toString(){
    return "Pound to Ounce Converter";
  }

  public void convertAndPrint(double value, boolean isInverted) {
    if (this.base_conversion == null) {
      System.out.println(this.toString() + " converted " + value + " lb to " + this.simpleConvert(value) + " oz!");
    } else {
      if (isInverted) {
        System.out.println(this.toString() + " converted " + value + " lb to " + this.simpleConvert(value) + " oz!");
        value = this.simpleConvert(value);
        this.base_conversion.convertAndPrint(value, isInverted);
      } else {
        this.base_conversion.convertAndPrint(value, isInverted);
        value = this.base_conversion.convert(value);
        System.out.println(this.toString() + " converted " + value + " lb to " + this.simpleConvert(value) + " oz!");
      }
    }
  }
};