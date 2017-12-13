public class AtmToPascalConverter extends PressureConverter
{
  private double conversionFactor = 101325.0;

  public AtmToPascalConverter() {
    super();
    this.base_conversion = null;
  }

  public AtmToPascalConverter(UnitConverter converter) throws BadChainingException {
    super();
    Class convClass = converter.getClass();
    try {
      if ((mappingFunction.get(convClass)).equals(this.getClass())) {
        this.base_conversion = converter;
      }
    } catch (NullPointerException e) {
      throw new BadChainingException(this.getClass().toString() + " must be chained to "
          + mappingFunction.get(this.getClass()).toString() + " and not to " + convClass.toString());
    }
  }

  public UnitConverter getBaseConverter() {
    return base_conversion;
  }

  public void setConversionFactor(double newFactor) {
    this.conversionFactor = newFactor;
  }

  public double getConversionFactor() {
    return this.conversionFactor;
  }

  public void link(UnitConverter converter) throws BadChainingException {
    Class convClass = converter.getClass();
    try {
      if (mappingFunction.get(this.getClass()).equals(convClass)) {
        this.base_conversion = converter;
      }
    } catch (NullPointerException e) {
      throw new BadChainingException(this.getClass().toString() + " must be chained to "
          + mappingFunction.get(this.getClass()).toString() + " and not to " + convClass.toString());
    }
  }

  public AtmToPascalConverter clone(){
    return new AtmToPascalConverter();
  }

  public double simpleConvert(double inAtms) {
    return inAtms * this.conversionFactor;
  }

  public double convert(double inAtms){
    if (this.base_conversion == null) {
      return inAtms * this.conversionFactor;
    } else {
      return this.base_conversion.convert(inAtms) * this.conversionFactor;
    }
  }

  public String toString(){
    return "Atmosphere to Pascal Converter";
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