public class KiloToPoundConverter extends WeightConverter
{
  private double conversionFactor = 2.205;

  public KiloToPoundConverter() {
    super();
    this.base_conversion = null;
  }

  public KiloToPoundConverter(WeightConverter converter) {
    super();
    // Assuming that the converter is correct
    this.base_conversion = converter;
  }

  public void setConversionFactor(double newFactor) {
    this.conversionFactor = newFactor;
  }

  public double getConversionFactor() {
    return this.conversionFactor;
  }

  public void link(UnitConverter converter) {
    Class convClass = converter.getClass();
    if(mappingFunction.get(this.getClass()).equals(convClass)){
      this.base_conversion = converter;
    }
  }

  public KiloToPoundConverter clone() {
    return new KiloToPoundConverter();
  }

  public double simpleConvert(double inKilos) {
    return inKilos * this.conversionFactor;
  }

  public double convert(double inKilos){
    if (this.base_conversion == null) {
      return inKilos * this.conversionFactor;
    } else {
      return this.base_conversion.convert(inKilos) * this.conversionFactor;
    }
  }

  public String toString(){
    return "Kilogram to Pound Converter";
  }

  public void convertAndPrint(double value) {
    if (this.base_conversion == null) {
      System.out.println(this.toString() + " converted " + value + " kg to " + this.simpleConvert(value) + " lb!");
    } else {
      this.base_conversion.convertAndPrint(value);
      value = this.base_conversion.convert(value);
      System.out.println(this.toString() + " converted " + value + " kg to " + this.simpleConvert(value) + " lb!");
    }
  }
};