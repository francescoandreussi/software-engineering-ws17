public class DollarToEuroConverter extends CurrencyConverter
{
  public final double originalConversionFactor = 0.85; // Needs to check whether conversionFactor is inverted or not
  private double conversionFactor = 0.85;

  public DollarToEuroConverter() {
    super();
    this.base_conversion = null;
  }

  public DollarToEuroConverter(UnitConverter converter) throws BadChainingException {
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

  public UnitConverter getBaseConverter() {
    return base_conversion;
  }

  public DollarToEuroConverter clone() {
    return new DollarToEuroConverter();
  }

  public double simpleConvert(double inDollars) throws ValueOutOfRangeException {
      return (double)((int)Math.round((inDollars * this.conversionFactor*100)))/100;
  }

  public double convert(double inDollars) throws ValueOutOfRangeException {
    if (this.base_conversion == null) {
        return (double)((int)Math.round((inDollars * this.conversionFactor*100)))/100;
      } else {
        return (double)((int)Math.round((this.base_conversion.convert(inDollars)*this.conversionFactor*100)))/100;
      }
  }

  public String toString(){
    return "Dollar to Euro Converter";
  }

  public void convertAndPrint(double value, boolean isInverted) throws ValueOutOfRangeException {
    if (Math.abs(value) >= 0.01 ){
      if (this.base_conversion == null) {
        System.out.println(this.toString() + " converted " + value + " USD to " + this.simpleConvert(value) + " EUR!");
      } else {
        if (isInverted) {
          System.out.println(this.toString() + " converted " + value + " USD to " + this.simpleConvert(value) + " EUR!");
          value = this.simpleConvert(value);
          this.base_conversion.convertAndPrint(value, isInverted);
        } else {
          this.base_conversion.convertAndPrint(value, isInverted);
          value = this.base_conversion.convert(value);
          System.out.println(this.toString() + " converted " + value + " USD to " + this.simpleConvert(value) + " EUR!");
        }
      }
    } else {
      throw new ValueOutOfRangeException("The input value of "+this.getClass().toString()
        + " cannot be between 0.01 and -0.01");
    }
  } 
};
