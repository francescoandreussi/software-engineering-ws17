import java.util.HashMap;

public abstract class PressureConverter extends UnitConverter
{
  protected static HashMap<Class, Class> mappingFunction = new HashMap<Class, Class>();

  public HashMap<Class, Class> getMap() {
    return mappingFunction;
  }

  public PressureConverter() {
    mappingFunction.put(AtmToPascalConverter.class, PascalToBarConverter.class);
    mappingFunction.put(PascalToBarConverter.class, BarToKgPerSqMtConverter.class);
    mappingFunction.put(BarToKgPerSqMtConverter.class, null);
  }

    // This methods make posible delimiting the input values for each class.
    public abstract double simpleConvert(double inValue);
    public abstract double convert(double inValue);
    public abstract void convertAndPrint(double value, boolean isInverted);
};