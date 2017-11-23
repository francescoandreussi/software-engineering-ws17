public class BritishPoundToSwissFrancConverter extends CurrencyConverter
{
  public BritishPoundToSwissFrancConverter() { }

  public BritishPoundToSwissFrancConverter clone() {
    return new BritishPoundToSwissFrancConverter();
  }

  public double convert(double inGPBs){
    return inGPBs*1.297;
  }

  public String toString(){
    return "British Pound to Swiss Franc Converter";
  }

  public void convertAndPrint(double value){
    System.out.println(this.toString() + " has converted " + value + " GPB to " + this.convert(value) + " CHF!");
  }
};
