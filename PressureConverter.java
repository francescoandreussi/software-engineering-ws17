import java.util.HashMap;

public abstract class PressureConverter extends UnitConverter
{
  protected static HashMap<Class, Class> mappingFunction = new HashMap<Class, Class>();

  public PressureConverter() {
    mappingFunction.put(AtmToPascalConverter.class, PascalToBarConverter.class);
    mappingFunction.put(PascalToBarConverter.class, BarToKgPerSqMtConverter.class);
    mappingFunction.put(BarToKgPerSqMtConverter.class, null);
  }
};