public class PascalToBarConverter extends PressureConverter
{
  public final double originalConversionFactor = 0.00001; // Needs to check whether conversionFactor is inverted or not
  private double conversionFactor = 0.00001;

  public PascalToBarConverter() {
    super();
    this.base_conversion = null;
  }

  public PascalToBarConverter(UnitConverter converter) throws BadChainingException {
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

  public PascalToBarConverter clone(){
    return new PascalToBarConverter();
  }

  public double simpleConvert(double inPascals) {
    return inPascals * this.conversionFactor;
  }

  public double convert(double inPascals){
    if (this.base_conversion == null) {
        return inPascals * this.conversionFactor;
    } else {
        return this.base_conversion.convert(inPascals) * this.conversionFactor;
    }
  }

  public String toString(){
    return "Pascal to Bar Converter";
  }

  public void convertAndPrint(double value){
    if (this.base_conversion == null) {
      System.out.println(this.toString() + " converted " + value + " Pa to " + this.simpleConvert(value) + " b!");
    } else {
      this.base_conversion.convertAndPrint(value);
      value = this.base_conversion.convert(value);
      System.out.println(this.toString() + " converted " + value + " Pa to " + this.simpleConvert(value) + " b!");
    }
  }
};