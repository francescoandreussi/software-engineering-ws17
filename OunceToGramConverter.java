public class OunceToGramConverter extends WeightConverter
{
  public OunceToGramConverter() {
    super();
    base_conversion = null;
  }

  public OunceToGramConverter(WeightConverter converter) {
    super();
    base_conversion = converter;
  }

  public void link(UnitConverter converter) {
    Class convClass = converter.getClass();
    if(mappingFunction.get(this.getClass()).equals(convClass)){
      base_conversion = converter;
    }
  }

  public OunceToGramConverter clone() {
    return new OunceToGramConverter();
  }

  public double simpleConvert(double inOunces) {
    return inOunces * 28.349;
  }

  public double convert(double inOunces){
    if (this.base_conversion == null) {
      return inOunces*28.349;
    } else {
      return this.base_conversion.convert(inOunces) * 28.349;
    }
  }

  public String toString(){
    return "Ounce to Gram Converter";
  }

  public void convertAndPrint(double value) {
    if (this.base_conversion == null) {
      System.out.println(this.toString() + " converted " + value + " oz to " + this.convert(value) + " g!");
    } else {
      this.base_conversion.convertAndPrint(value);
      value = this.base_conversion.convert(value);
      System.out.println("Then, " + this.toString() + " converted " + value + " oz to " + this.convert(value) + " g!");
    }
  }
};