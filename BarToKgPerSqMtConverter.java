public class BarToKgPerSqMtConverter extends PressureConverter
{
  public BarToKgPerSqMtConverter() {
    super();
    base_conversion = null;
  }

  public BarToKgPerSqMtConverter(PressureConverter converter){
    super();
    base_conversion = converter;
  }

  public void link(UnitConverter converter) {
    Class convClass = converter.getClass();
    if(mappingFunction.get(this.getClass()).equals(convClass)){
      base_conversion = converter;
    }
  }

  public BarToKgPerSqMtConverter clone(){
    return new BarToKgPerSqMtConverter();
  }

  public double simpleConvert(double inBars) {
    return inBars * 10197.162;
  }

  public double convert(double inBars){
    if (this.base_conversion == null) {
      return inBars*10197.162;
    } else {
      return this.base_conversion.convert(inBars)*10197.162;
    }
  }

  public String toString(){
    return "Bar to Kilogram per Squared Meter Converter";
  }

  public void convertAndPrint(double value) {
    if (this.base_conversion == null) {
      System.out.println(this.toString() + " converted " + value + " b to " + this.convert(value) + " kg/Sq.m!");
    } else {
      this.base_conversion.convertAndPrint(value);
      value = this.base_conversion.convert(value);
      System.out.println("Then, " + this.toString() + " converted " + value + " b to " + this.convert(value) + " kg/Sq.m!");
    }
  }
};