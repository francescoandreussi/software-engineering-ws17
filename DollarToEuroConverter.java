public class DollarToEuroConverter extends CurrencyConverter
{
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

  public double simpleConvert(double inDollars) {
    return inDollars * this.conversionFactor;
  }

  public double convert(double inDollars){
    if (this.base_conversion == null) {
      return inDollars * this.conversionFactor;
    } else {
      return this.base_conversion.convert(inDollars) * this.conversionFactor;
    }
  }

  public String toString(){
    return "Dollar to Euro Converter";
  }

  public void convertAndPrint(double value) {
    if (this.base_conversion == null) {
      //System.out.println("BASE CONV OF Dollar to Euro: null");
      System.out.println(this.toString() + " converted " + value + " USD to " + this.simpleConvert(value) + " EUR!");
    } else {
      //System.out.println("BASE CONV OF Dollar to Euro: " + this.base_conversion.toString());
      this.base_conversion.convertAndPrint(value);
      value = this.base_conversion.convert(value);
      System.out.println(this.toString() + " converted " + value + " USD to " + this.simpleConvert(value) + " EUR!");
    }
  }
};
