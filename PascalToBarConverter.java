public class PascalToBarConverter extends PressureConverter
{
  private double conversionFactor = 0.00001;

  public PascalToBarConverter() {
    super();
    this.base_conversion = null;
  }

  public PascalToBarConverter(PressureConverter converter){
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

  public PascalToBarConverter clone(){
    return new PascalToBarConverter();
  }

  public double simpleConvert(double inPascals) {
    return inPascals * this.conversionFactor;
  }

  public double convert(double inPascals){
    if (this.base_conversion == null) {
        return inPascals * this.conversionFactor;
    } else {
        return this.base_conversion.convert(inPascals) * this.conversionFactor;
    }
  }

  public String toString(){
    return "Pascal to Bar Converter";
  }

  public void convertAndPrint(double value){
    if (this.base_conversion == null) {
      System.out.println(this.toString() + " converted " + value + " Atm to " + this.simpleConvert(value) + " Pa!");
    } else {
      this.base_conversion.convertAndPrint(value);
      value = this.base_conversion.convert(value);
      System.out.println(this.toString() + " converted " + value + " Atm to " + this.simpleConvert(value) + " Pa!");
    }
  }
};