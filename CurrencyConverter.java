import java.util.HashMap;

public abstract class CurrencyConverter extends UnitConverter
{
  protected static HashMap<Class, Class> mappingFunction = new HashMap<Class, Class>();

  public CurrencyConverter() {
    mappingFunction.put(DollarToEuroConverter.class, EuroToBritishPoundConverter.class);
    mappingFunction.put(EuroToBritishPoundConverter.class, BritishPoundToSwissFrancConverter.class);
    mappingFunction.put(BritishPoundToSwissFrancConverter.class, null);
  }
};