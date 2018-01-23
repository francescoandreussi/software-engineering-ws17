import java.util.HashMap;

public abstract class CurrencyConverter extends UnitConverter
{
  protected static HashMap<Class, Class> mappingFunction = new HashMap<Class, Class>();

  public HashMap<Class,Class> getMap(){
    return mappingFunction;
  }

  public CurrencyConverter() {
    mappingFunction.put(DollarToEuroConverter.class, EuroToBritishPoundConverter.class);
    mappingFunction.put(EuroToBritishPoundConverter.class, BritishPoundToSwissFrancConverter.class);
    mappingFunction.put(BritishPoundToSwissFrancConverter.class, null);
  }
  
  //  This methods do not accept value between 0,01 and - 0,01
  public abstract double simpleConvert(double inValue) throws ValueOutOfRangeException;
  public abstract double convert(double inValue) throws ValueOutOfRangeException;
  public abstract void convertAndPrint(double value, boolean isInverted) throws ValueOutOfRangeException;
};