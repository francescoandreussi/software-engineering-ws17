public class EuroToBritishPoundConverter extends CurrencyConverter
{
  private double conversionFactor = 0.87;

  public EuroToBritishPoundConverter() {
    super();
    this.base_conversion = null;
  }

  public EuroToBritishPoundConverter(UnitConverter converter) throws BadChainingException {
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

  public EuroToBritishPoundConverter clone() {
    return new EuroToBritishPoundConverter();
  }

  public double simpleConvert(double inEuros) {
    return inEuros * this.conversionFactor;
  }

  public double convert(double inEuros){
    if (this.base_conversion == null) {
        return inEuros * this.conversionFactor;
    } else {
        return this.base_conversion.convert(inEuros) * this.conversionFactor;
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
