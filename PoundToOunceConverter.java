public class PoundToOunceConverter extends WeightConverter
{
  public PoundToOunceConverter() {
    super();
    base_conversion = null;
  }

  public PoundToOunceConverter(WeightConverter converter) {
    super();
    base_conversion = converter;
  }

  public void link(UnitConverter converter) {
    Class convClass = converter.getClass();
    if(mappingFunction.get(this.getClass()).equals(convClass)){
      base_conversion = converter;
    }
  }

  public PoundToOunceConverter clone() {
    return new PoundToOunceConverter();
  }

  public double simpleConvert(double inPounds) {
    return inPounds * 16;
  }

  public double convert(double inPounds){
    if (this.base_conversion == null) {
        return inPounds*16;
    } else {
        return this.base_conversion.convert(inPounds) * 16;
    }
  }

  public String toString(){
    return "Pound to Ounce Converter";
  }

  public void convertAndPrint(double value) {
    if (this.base_conversion == null) {
      System.out.println(this.toString() + " converted " + value + " lb to " + this.convert(value) + " oz!");
    } else {
      this.base_conversion.convertAndPrint(value);
      value = this.base_conversion.convert(value);
      System.out.println("Then, " + this.toString() + " converted " + value + " lb to " + this.convert(value) + " oz!");
    }
  }
};