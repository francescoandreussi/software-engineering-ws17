public class AtmToPascalConverter extends PressureConverter
{
  public AtmToPascalConverter() { }

  public AtmToPascalConverter clone(){
    return new AtmToPascalConverter();
  }

  public double convert(double inAtms){
    return inAtms*101325.0;
  }

  public String toString(){
    return "Atmosphere to Pascal Converter";
  }

  public void convertAndPrint(double value){
    System.out.println(this.toString() + " has converted " + value + " Atm to " + this.convert(value) + " Pa!");
  }
};