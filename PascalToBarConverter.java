public class PascalToBarConverter extends PressureConverter
{
  public PascalToBarConverter() {
    super();
    base_conversion = null;
  }

  public PascalToBarConverter(PressureConverter converter){
    super();
    base_conversion = converter;
  }

  public void link(UnitConverter converter) {
    Class convClass = converter.getClass();
    if(mappingFunction.get(this.getClass()).equals(convClass)){
      base_conversion = converter;
    }
  }

  public PascalToBarConverter clone(){
    return new PascalToBarConverter();
  }

  public double simpleConvert(double inPascals) {
    return inPascals * 0.00001;
  }

  public double convert(double inPascals){
    if (this.base_conversion == null) {
        return inPascals*0.00001;
    } else {
        return this.base_conversion.convert(inPascals) * 0.00001;
    }
  }

  public String toString(){
    return "Pascal to Bar Converter";
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