public class BritishPoundToSwissFrancConverter extends CurrencyConverter
{
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

  public void setConversionFactor(double newFactor){
    this.conversionFactor = newFactor;
  }

  public double getConversionFactor() {
    return this.conversionFactor;
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
    return inGPBs * this.conversionFactor;
  }
  
  public double convert(double inGPBs){
    if (this.base_conversion == null) {
      return inGPBs * this.conversionFactor;
    } else {
      return this.base_conversion.convert(inGPBs) * this.conversionFactor;
    }
  }

  public String toString(){
    return "British Pound to Swiss Franc Converter";
  }

  public void convertAndPrint(double value) {
    if (this.base_conversion == null) {
      //System.out.println("BASE CONV OF Pound to Franc: null");
      System.out.println(this.toString() + " converted " + value + " GPB to " + this.simpleConvert(value) + " CHF!");
    } else {
      //System.out.println("BASE CONV OF Pound to Franc: " + this.base_conversion.toString());
      this.base_conversion.convertAndPrint(value);
      value = this.base_conversion.convert(value);
      System.out.println(this.toString() + " converted " + value + " GPB to " + this.simpleConvert(value) + " CHF!");
    }
  }
};
