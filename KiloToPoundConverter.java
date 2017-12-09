public class KiloToPoundConverter extends WeightConverter
{
  public KiloToPoundConverter() {
    super();
    base_conversion = null;
  }

  public KiloToPoundConverter(UnitConverter converter) {
    super();
    base_conversion = converter;
  }

  public void link(UnitConverter converter) {
    Class convClass = converter.getClass();
    if(mappingFunction.get(this.getClass()).equals(convClass)){
      base_conversion = converter;
    }
  }

  public KiloToPoundConverter clone() {
    return new KiloToPoundConverter();
  }

  public double simpleConvert(double inKilos) {
    return inKilos * 2.205;
  }

  public double convert(double inKilos){
    if (this.base_conversion == null) {
      return inKilos*2.205;
    } else {
      return this.base_conversion.convert(inKilos) * 2.205;
    }
  }

  public String toString(){
    return "Kilogram to Pound Converter";
  }

  public void convertAndPrint(double value) {
    if (this.base_conversion == null) {
      System.out.println(this.toString() + " converted " + value + " kg to " + this.convert(value) + " lb!");
    } else {
      this.base_conversion.convertAndPrint(value);
      value = this.base_conversion.convert(value);
      System.out.println("Then, " + this.toString() + " converted " + value + " kg to " + this.convert(value) + " lb!");
    }
  }
};