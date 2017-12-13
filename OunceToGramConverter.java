public class OunceToGramConverter extends WeightConverter
{
  public final double originalConversionFactor = 28.349; // Needs to check whether conversionFactor is inverted or not
  private double conversionFactor = 28.349;

  public OunceToGramConverter() {
    super();
    this.base_conversion = null;
  }

  public OunceToGramConverter(UnitConverter converter) throws BadChainingException {
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

  public OunceToGramConverter clone() {
    return new OunceToGramConverter();
  }

  public double simpleConvert(double inOunces) {
    return inOunces * this.conversionFactor;
  }

  public double convert(double inOunces){
    //System.out.println("Ounce to Gram convert");
    if (this.base_conversion == null) {
      return inOunces * this.conversionFactor;
    } else {
      return this.base_conversion.convert(inOunces) * this.conversionFactor;
    }
  }

  public String toString(){
    return "Ounce to Gram Converter";
  }

  public void convertAndPrint(double value) {
    if (this.base_conversion == null) {
      //System.out.println("caso base convertAndPrint OunceToGram");
      System.out.println(this.toString() + " converted " + value + " oz to " + this.simpleConvert(value) + " g!");
    } else {
      this.base_conversion.convertAndPrint(value);
      value = this.base_conversion.convert(value);
      System.out.println(this.toString() + " converted " + value + " oz to " + this.simpleConvert(value) + " g!");
    }
  }
};