import java.util.HashMap;

public abstract class PressureConverter extends UnitConverter
{
  protected static HashMap<Class, Class> mappingFunction = new HashMap<Class, Class>();

  public PressureConverter() {
    mappingFunction.put(AtmToPascalConverter.class, null);
    //mappingFunction.put(EuroToBritishPoundConverter.class, BarToKgPerSqMeter.class);
    mappingFunction.put(BarToKgPerSqMtConverter.class, null);
  }
};