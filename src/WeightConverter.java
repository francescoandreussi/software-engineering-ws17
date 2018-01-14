import java.util.HashMap;

public abstract class WeightConverter extends UnitConverter
{
  protected static HashMap<Class, Class> mappingFunction = new HashMap<Class, Class>();

  public HashMap<Class, Class> getMap() {
    return mappingFunction;
  }

  public WeightConverter() {
    mappingFunction.put(KiloToPoundConverter.class, PoundToOunceConverter.class);
    mappingFunction.put(PoundToOunceConverter.class, OunceToGramConverter.class);
    mappingFunction.put(OunceToGramConverter.class, null);
  }
};