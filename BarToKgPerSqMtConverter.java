public class BarToKgPerSqMtConverter extends PressureConverter
{
  public BarToKgPerSqMtConverter() { }

  public double convert(double inBars){
    return inBars*10197.162;
  }

  public String toString(){
    return "Bar to Kilogram per Squared Meter Converter";
  }

  public void print(){
    System.out.println(toString());
  }
};