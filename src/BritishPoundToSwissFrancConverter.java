public class BritishPoundToSwissFrancConverter extends CurrencyConverter
{
  private final double originalConversionFactor = 1.297; // Needs to check whether conversionFactor is inverted or not
  private double conversionFactor = 1.297;

  public BritishPoundToSwissFrancConverter() {
    super();
    this.base_conversion = null;
  }

  public BritishPoundToSwissFrancConverter(UnitConverter converter) throws BadChainingException{
    super();
    Class convClass = converter.getClass();
    try{
      if((mappingFunction.get(convClass)).equals(this.getClass())){
        this.base_conversion = converter;
      }
    }
    catch (NullPointerException e) {
      throw new BadChainingException(this.getClass().toString() + " must be chained to "
          + mappingFunction.get(this.getClass()).toString() + " and not to " + convClass.toString());
    }
  }

  public UnitConverter getBaseConverter() {
    return base_conversion;
  }

  public void setConversionFactor(double newFactor){
    this.conversionFactor = newFactor;
  }

  public double getConversionFactor() {
    return this.conversionFactor;
  }

  public double getOriginalConversionFactor() {
    return this.originalConversionFactor;
  }

  public void link(UnitConverter converter) throws BadChainingException{
    Class convClass = converter.getClass();
    try{
      //System.out.println("Real base_conversion class: " + convClass.toString());
      //System.out.println("Expected base_conversion class: " + mappingFunction.get(this.getClass()).toString());
      if(mappingFunction.get(this.getClass()).equals(convClass)){
        //System.out.println("LINKING...");
        this.base_conversion = converter;
      }
    }
    catch (NullPointerException e) {
      throw new BadChainingException(this.getClass().toString() + " must be chained to " +
        mappingFunction.get(this.getClass()).toString() + " and not to " + convClass.toString());
    }
  }

  public BritishPoundToSwissFrancConverter clone() {
    return new BritishPoundToSwissFrancConverter();
  }

  public double simpleConvert(double inGPBs){
    return (double)((int)Math.round((inGPBs * this.conversionFactor*100)))/100;
  }
  
  public double convert(double inGPBs){
    if (this.base_conversion == null) {
      return (double)((int)Math.round((inGPBs * this.conversionFactor*100)))/100;
    } else {
      return (double)((int)Math.round((this.base_conversion.convert(inGPBs) * this.conversionFactor*100)))/100;
    }
  }

  public String toString(){
    return "British-Pound to Swiss-Franc Converter";
  }

  public void convertAndPrint(double value, boolean isInverted) {
    if (Math.abs(value) >= 0.01 ){
      if (this.base_conversion == null) {
        System.out.println(this.toString() + " converted " + value + " GPB to " + this.simpleConvert(value) + " CHF!");
      } else {
        if (isInverted) {
          System.out.println(this.toString() + " converted " + value + " GPB to " + this.simpleConvert(value) + " CHF!");
          value = this.simpleConvert(value);
          this.base_conversion.convertAndPrint(value, isInverted);
        } else {
          this.base_conversion.convertAndPrint(value, isInverted);
          value = this.base_conversion.convert(value);
          System.out.println(this.toString() + " converted " + value + " GPB to " + this.simpleConvert(value) + " CHF!");
        }
      }
    } else {
      throw new ValueOutOfRangeException("The input value of "+this.getClass().toString()
        + " cannot be between 0.01 and -0.01");
    }
  }
};
