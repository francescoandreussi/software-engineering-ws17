import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.LinkedList;

class Main {
    // NOT CORRECT! Will be modified during Part 2
    private static UnitConverter chain(String[] converter) throws BadConversionStringException, BadChainingException{
        int l = converter.length;
        //System.out.println("CHAINING..." + l);
        //System.out.println(Arrays.toString(converter));
        if(l == 1){
            return ConverterFactory.create(converter[0]);
        } else if(l == 2){
            UnitConverter firstConverter = ConverterFactory.create(converter[0]);
            //System.out.println("first Conv " + firstConverter.toString());
            UnitConverter secondConverter = ConverterFactory.create(converter[1]);
            //System.out.println("second Conv " + secondConverter.toString());
            firstConverter.link(secondConverter);
            return firstConverter;
        } else {
            UnitConverter nextConverters = chain(Arrays.copyOfRange(converter, 1, l));
            //System.out.println("Next converter outermost type: " + nextConverters.toString());
            UnitConverter firstConverter = ConverterFactory.create(converter[0]);
            //System.out.println("First converter type: " + firstConverter.toString());
            firstConverter.link(nextConverters);
            return firstConverter;
        }
    }

    public static void main(String[] args)  // NOT CORRECT! Will be adapted for Part 2
    {
        try{
            // Creating a "global" HashMap. It will be used to check the correctness of the conversion sequence
            LinkedList<Command> conversionList = new LinkedList<Command>();
            LinkedList<String> inputList = new LinkedList<String>();
            boolean isInverted = false;
            // Scanning cycle
            Scanner scan = new Scanner(System.in);
            while (scan.hasNext()) {
                String s = scan.next();
                inputList.add(s);
            }
            scan.close();
            // Parsing the last element (that should be a double)
            // Double.parseDouble function was copied from
            // https://stackoverflow.com/questions/5769669/convert-string-to-double-in-java.
            // It converts a string into a double, if the string is invalid it thorws a NumberFormatException
            double value = Double.parseDouble(inputList.removeLast());
            
            // EXERCISE 5 - PART 2
            // Detecting if the conversion sequence is inverted
            if (inputList.getFirst().equals("Inversion")) {
                isInverted = true;
                inputList.removeFirst();
                LinkedList<String> supportList = new LinkedList<String>();
                for (String input : inputList) { // Creating a reversed list
                    supportList.addFirst(input);                    
                }
                inputList.clear();
                inputList = supportList; // Replacing the previous list with the reversed one
            }
            // Setting up the sequence of conversion
            if (isInverted) {
                for (String input : inputList) {
                    UnitConverter converter = ConverterFactory.create(input);
                    Command nextConverter;
                    if (input.equals(inputList.getFirst())) { // The first element needs the typed value
                        Inversion invertedConversion = new Inversion(converter);
                        nextConverter = new Command(invertedConversion, value);
                    } else { // The others need the processed (from the previous converters) value 
                        HashMap<Class, Class> converterMapping = converter.getMap();
                        // Getting the last converter in conversionList in this moment (it is the previous one wrt the current instanced converter)
                        // But the type returned by getConverter is Inversion, so it is essential to get the base_conversion of the Inversion
                        UnitConverter previousConverter = conversionList.getLast().getConverter();
                        double previousValue = conversionList.getLast().getValue();
                        try{
                            if (converterMapping.get(converter.getClass()).equals(previousConverter.getBaseConverter().getClass())) {
                                Inversion invertedConversion = new Inversion(converter);
                                //invertedConversion.simpleConvert(0); // Hack to balance side effects of inverted conversions (we know that's ugly)
                                nextConverter = new Command(invertedConversion, previousConverter.simpleConvert(previousValue));
                            } else {
                                throw new BadChainingException(converter.getClass().toString() + " must be chained to "
                                    + converterMapping.get(converter.getClass()).toString() + " and not to "
                                    + previousConverter.getClass().toString());
                            }
                        } catch (NullPointerException e){
                            throw new BadChainingException("\"Inversion\" can be ONLY the first typed element!");
                        }
                    }
                    conversionList.add(nextConverter);
                }
            } else {
                for (String input : inputList) {
                    UnitConverter converter = ConverterFactory.create(input);
                    Command nextConverter;
                    if (input.equals(inputList.getFirst())) { // The first element needs the typed value
                        nextConverter = new Command(converter, value);
                    } else { // The others need the processed (from the previous converters) value
                        // Getting the last converter in conversionList in this moment (it is the previous one wrt the current instanced converter)
                        UnitConverter previousConverter = conversionList.getLast().getConverter();
                        HashMap<Class, Class> prevConverterMapping = previousConverter.getMap();
                        double previousValue = conversionList.getLast().getValue();
                        if (prevConverterMapping.get(previousConverter.getClass()).equals(converter.getClass())) {
                            nextConverter = new Command(converter, previousConverter.simpleConvert(previousValue));
                        } else {
                            throw new BadChainingException(previousConverter.getClass().toString() + " must be chained to "
                                    + prevConverterMapping.get(previousConverter.getClass()).toString() + " and not to "
                                    + converter.getClass().toString());
                        }
                    }
                    conversionList.add(nextConverter);
                }
            }
            for (Command conversion : conversionList) {
                conversion.execute();
            }

        }
        catch(BadConversionStringException e){
            System.out.println(e.getMessage());
            System.out.println("The available conversions are:");
                System.out.println("\t- DollarToEuro,");
                System.out.println("\t- BritishPoundToSwissFranc,");
                System.out.println("\t- EuroToBritishPound,");
                System.out.println("\t- AtmosphereToPascal,");
                System.out.println("\t- PascalToBar,");
                System.out.println("\t- BarToKilogramPerSquaredMeter,");
                System.out.println("\t- KilogramToPound,");
                System.out.println("\t- PoundToOunce,");
                System.out.println("\t- OunceToGram,");
                System.out.println("\t- Inversion");
        }
        catch(NumberFormatException e){
            System.out.println("Invalid last argument: " + e.getMessage() + "!");
            System.out.println("Please, write a valid real number");
        }
        catch(BadChainingException e){
            System.out.println("Incorrect chaining: " + e.getMessage());
        }
    }
}