public class AtmToPascalConverter extends PressureConverter
{
  public AtmToPascalConverter() {
    super();
    base_conversion = null;
  }

  public AtmToPascalConverter(PressureConverter converter){
    super();
    base_conversion = converter;
  }

  public void link(UnitConverter converter) {
    Class convClass = converter.getClass();
    if(mappingFunction.get(this.getClass()).equals(convClass)){
      base_conversion = converter;
    }
  }

  public AtmToPascalConverter clone(){
    return new AtmToPascalConverter();
  }

  public double simpleConvert(double inAtms) {
    return inAtms * 101325.0;
  }

  public double convert(double inAtms){
    if (this.base_conversion == null) {
      return inAtms*101325.0;
    } else {
      return this.base_conversion.convert(inAtms) * 101325.0;
    }
  }

  public String toString(){
    return "Atmosphere to Pascal Converter";
  }

  public void convertAndPrint(double value){
    if (this.base_conversion == null) {
      System.out.println(this.toString() + " converted " + value + " Atm to " + this.convert(value) + " Pa!");
    } else {
      this.base_conversion.convertAndPrint(value);
      value = this.base_conversion.convert(value);
      System.out.println("Then, " + this.toString() + " converted " + value + " Atm to " + this.convert(value) + " Pa!");
    }
  }
};