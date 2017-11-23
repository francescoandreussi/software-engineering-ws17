public class OunceToGramConverter extends WeightConverter
{
  public OunceToGramConverter() { }

  public OunceToGramConverter clone() {
    return new OunceToGramConverter();
  }

  public double convert(double inOunces){
    return inOunces*28.349;
  }

  public String toString(){
    return "Ounce to Gram Converter";
  }

  public void convertAndPrint(double value){
    System.out.println(this.toString() + " has converted " + value + " oz to " + this.convert(value) + " g!");
  }
};