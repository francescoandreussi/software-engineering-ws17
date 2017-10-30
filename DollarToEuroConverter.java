public class DollarToEuroConverter extends CurrencyConverter
{
  public DollarToEuroConverter() { }

  public double convert(double inDollars){
    return inDollars*0.85;
  }

  public String toString(){
    return "Dollar to Euro Converter";
  }

  public void print(){
    System.out.println(toString());
  }
};
