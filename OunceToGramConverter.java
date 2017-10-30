public class OunceToGramConverter extends WeightConverter
{
  public OunceToGramConverter() { }

  public double convert(double inOunces){
    return inOunces*28.349;
  }

  public String toString(){
    return "Ounce to Gram Converter";
  }

  public void print(){
    System.out.println(toString());
  }
};