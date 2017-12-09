public class EuroToBritishPoundConverter extends CurrencyConverter
{
  public EuroToBritishPoundConverter() {
    super();
    base_conversion = null;
  }

  public EuroToBritishPoundConverter(CurrencyConverter converter) {
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

  public EuroToBritishPoundConverter clone() {
    return new EuroToBritishPoundConverter();
  }

  public double simpleConvert(double inEuros) {
    return inEuros * 0.87;
  }

  public double convert(double inEuros){
    if (this.base_conversion == null) {
        return inEuros * 0.87;
    } else {
        return this.base_conversion.convert(inEuros) * 0.87;
    }
  }

  public String toString(){
    return "Euro to British Pound Converter";
  }

  public void convertAndPrint(double value) {
    if (this.base_conversion == null) {
        //System.out.println("BASE CONV OF Euro to Pound: null");
        System.out.println(this.toString() + " converted " + value + " EUR to " + this.simpleConvert(value) + " GPB!");
    } else {
        //System.out.println("BASE CONV OF Euro to Pound: " + this.base_conversion.toString());
        this.base_conversion.convertAndPrint(value);
        value = this.base_conversion.convert(value);
        System.out.println(this.toString() + " converted " + value + " EUR to " + this.simpleConvert(value) + " GPB!");
    }
  }
};
