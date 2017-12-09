public class DollarToEuroConverter extends CurrencyConverter
{
  public DollarToEuroConverter() {
    super();
    base_conversion = null;
  }

  public DollarToEuroConverter(CurrencyConverter converter) {
    super();
    base_conversion = converter;
  }

  public void link(UnitConverter converter){
    Class convClass = converter.getClass();
    //System.out.println("Real base_conversion class: " + convClass.toString());
    //System.out.println("Expected base_conversion class: " + mappingFunction.get(this.getClass()).toString());
    if(mappingFunction.get(this.getClass()).equals(convClass)){
      //System.out.println("LINKING...");
      base_conversion = converter;
    }
  }

  public DollarToEuroConverter clone() {
    return new DollarToEuroConverter();
  }

  public double simpleConvert(double inDollars) {
    return inDollars * 0.85;
  }

  public double convert(double inDollars){
    if (this.base_conversion == null) {
      return inDollars*0.85;
    } else {
      return this.base_conversion.convert(inDollars) * 0.85;
    }
  }

  public String toString(){
    return "Dollar to Euro Converter";
  }

  public void convertAndPrint(double value) {
    if (this.base_conversion == null) {
      //System.out.println("BASE CONV OF Dollar to Euro: null");
      System.out.println(this.toString() + " converted " + value + " USD to " + this.simpleConvert(value) + " EUR!");
    } else {
      //System.out.println("BASE CONV OF Dollar to Euro: " + this.base_conversion.toString());
      this.base_conversion.convertAndPrint(value);
      value = this.base_conversion.convert(value);
      System.out.println(this.toString() + " converted " + value + " USD to " + this.simpleConvert(value) + " EUR!");
    }
  }
};
