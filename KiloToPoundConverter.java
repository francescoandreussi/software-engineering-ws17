public class KiloToPoundConverter extends WeightConverter
{
  public KiloToPoundConverter() { }

  public KiloToPoundConverter clone() {
    return new KiloToPoundConverter();
  }

  public double convert(double inKilos){
    return inKilos*2.205;
  }

  public String toString(){
    return "Kilogram to Pound Converter";
  }

  public void convertAndPrint(double value){
    System.out.println(this.toString() + " has converted " + value + " kg to " + this.convert(value) + " lb!");
  }
};