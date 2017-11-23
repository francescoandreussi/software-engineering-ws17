public class BarToKgPerSqMtConverter extends PressureConverter
{
  public BarToKgPerSqMtConverter() { }

  public BarToKgPerSqMtConverter clone(){
    return new BarToKgPerSqMtConverter();
  }

  public double convert(double inBars){
    return inBars*10197.162;
  }

  public String toString(){
    return "Bar to Kilogram per Squared Meter Converter";
  }

  public void convertAndPrint(double value){
    System.out.println(this.toString() + " has converted " + value + " b to " + this.convert(value) + " kg/Sq.m!");
  }
};