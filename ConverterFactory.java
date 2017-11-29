import java.util.HashMap;

/**
 * ConverterFactory
 */
public class ConverterFactory {
    private static ConverterFactory s_instance = null;
    private static int numberOfInstances = 0;

    protected ConverterFactory(){}

    // Singelton pattern! It is possible to create only one instance of ConverterFactory because the constructor is protected and
    // it is possible to create an instance only with this static method that checks if a instance is already been instanced
    public static ConverterFactory instance() {
        if (s_instance == null){
            s_instance = new ConverterFactory();
            numberOfInstances++;
        }
        return s_instance;
    }
    
    // initializing prototypes list
    private static final UnitConverter s_prototypes[] = {  new DollarToEuroConverter(), new BritishPoundToSwissFrancConverter(),
                                            new AtmToPascalConverter(), new BarToKgPerSqMtConverter(),
                                            new KiloToPoundConverter(), new OunceToGramConverter() };

    private static UnitConverter makeConverter(int choice) {
        return s_prototypes[choice].clone();
    }

    public static UnitConverter create(String conversion) throws BadConversionStringException{
        try{
            // use of HashMap inspired by the example at this link https://beginnersbook.com/2013/12/hashmap-in-java-with-example/
            // initializing the hash map
            HashMap<String, Integer> mappingFunction = new HashMap<String, Integer>();
            // filling the hash map
            mappingFunction.put("DollarToEuro", 0);
            mappingFunction.put("BritishPoundToSwissFranc", 1);
            mappingFunction.put("AtmosphereToPascal", 2);
            mappingFunction.put("BarToKilogramPerSquaredMeter", 3);
            mappingFunction.put("KilogramToPound", 4);
            mappingFunction.put("OunceToGram", 5);
            // instancing the correct UnitConverter w.r.t. the input string. An exception is thrown if the string is not present in the HashMap
            // (it will be handled in the main)
            Integer choice = mappingFunction.get(conversion);
            UnitConverter converter = makeConverter(choice);
            return converter;
        }
        catch(NullPointerException e){
            throw new BadConversionStringException("The first argument is not a valid conversion string!");
        }
    }

    public int getNumberOfInstances() {
        return numberOfInstances;
    }
    
    public String toString(){
        return ("Instance of ConverterFactory. Number of Instances: " + numberOfInstances);
    }
}