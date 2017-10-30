public class AtmToPascalConverter extends PressureConverter
{
  public AtmToPascalConverter() { }

  public double convert(double inAtms){
    return inAtms*101325.0;
  }

  public String toString(){
    return "Atmosphere to Pascal Converter";
  }

  public void print(){
    System.out.println(toString());
  }
};