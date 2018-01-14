public class EuroToBritishPoundConverter extends CurrencyConverter
{
  public final double originalConversionFactor = 0.87; // Needs to check whether conversionFactor is inverted or not
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

  public UnitConverter getBaseConverter() {
    return base_conversion;
  }

  public void setConversionFactor(double newFactor) {
    this.conversionFactor = newFactor;
  }

  public double getConversionFactor() {
    return this.conversionFactor;
  }
  
  public double getOriginalConversionFactor() {
    return this.originalConversionFactor;
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
    return "Euro to British-Pound Converter";
  }

  public void convertAndPrint(double value, boolean isInverted) {
    if (this.base_conversion == null) {
        //System.out.println("BASE CONV OF Euro to Pound: null");
        System.out.println(this.toString() + " converted " + value + " EUR to " + this.simpleConvert(value) + " GPB!");
    } else {
      if (isInverted) {
        System.out.println(this.toString() + " converted " + value + " EUR to " + this.simpleConvert(value) + " GPB!");
        value = this.simpleConvert(value);
        this.base_conversion.convertAndPrint(value, isInverted);
      } else {
        this.base_conversion.convertAndPrint(value, isInverted);
        value = this.base_conversion.convert(value);
        System.out.println(this.toString() + " converted " + value + " EUR to " + this.simpleConvert(value) + " GPB!");
      }
    }
  }
};
