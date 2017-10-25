public class KiloToPoundConverter extends WeightConverter
{
  public KiloToPoundConverter() { }

  public double convert(double inKilos) {
    return inKilos*2.205;
  }

  public String toString(){
    return "Kilogram to Pound Converter";
  }

  public void print(){
    System.out.println(toString());
  }
};