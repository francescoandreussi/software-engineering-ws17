public class BarToKgPerSqMtConverter extends PressureConverter
{
  private double conversionFactor = 10197.162;

  public BarToKgPerSqMtConverter() {
    super();
    this.base_conversion = null;
  }

  public BarToKgPerSqMtConverter(UnitConverter converter) throws BadChainingException {
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

  public void setConversionFactor(double newFactor) {
    this.conversionFactor = newFactor;
  }

  public double getConversionFactor() {
    return this.conversionFactor;
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

  public BarToKgPerSqMtConverter clone(){
    return new BarToKgPerSqMtConverter();
  }

  public double simpleConvert(double inBars) {
    return inBars * this.conversionFactor;
  }

  public double convert(double inBars){
    if (this.base_conversion == null) {
      return inBars * this.conversionFactor;
    } else {
      return this.base_conversion.convert(inBars) * this.conversionFactor;
    }
  }

  public String toString(){
    return "Bar to Kilogram per Squared Meter Converter";
  }

  public void convertAndPrint(double value) {
    if (this.base_conversion == null) {
      System.out.println(this.toString() + " converted " + value + " b to " + this.simpleConvert(value) + " kg/Sq.m!");
    } else {
      this.base_conversion.convertAndPrint(value);
      value = this.base_conversion.convert(value);
      System.out.println(this.toString() + " converted " + value + " b to " + this.simpleConvert(value) + " kg/Sq.m!");
    }
  }
};