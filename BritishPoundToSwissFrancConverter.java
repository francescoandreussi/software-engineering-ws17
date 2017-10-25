public class BritishPoundToSwissFrancConverter extends CurrencyConverter
{
  public BritishPoundToSwissFrancConverter() { }

  public double convert(double inGPBs) {
    return inGPBs*1.297;
  }

  public String toString(){
    return "British Pound to Swiss Franc Converter";
  }

  public void print(){
    System.out.println(toString());
  }
};
