public class DollarToEuroConverter extends CurrencyConverter
{
  public DollarToEuroConverter() { }

  public DollarToEuroConverter clone() {
    return new DollarToEuroConverter();
  }

  public double convert(double inDollars){
    return inDollars*0.85;
  }

  public String toString(){
    return "Dollar to Euro Converter";
  }

  public void convertAndPrint(double value){
    System.out.println(this.toString() + " has converted " + value + " USD to " + this.convert(value) + " EUR!");
  }
};
