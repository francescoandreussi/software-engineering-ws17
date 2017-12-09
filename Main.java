import java.util.Arrays;

class Main {
    // NOT CORRECT! Will be modified during Part 2
    private static UnitConverter chain(String[] converter) throws BadConversionStringException{
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
            if(args.length < 2){
                //if the command line call does not have two args throws an Exception to avoid an out-of-bounds-reading
                throw new NumberOfArgsException("Main requires at least 2 arguments!");
            }

            String value = args[args.length - 1];
            String converter[] = Arrays.copyOf(args, args.length - 1);
            //System.out.println(Arrays.toString(converter));

            //Double.parseDouble function was copied from
            //https://stackoverflow.com/questions/5769669/convert-string-to-double-in-java.
            //It converts a string into a double, if the string is invalid it thorws a NumberFormatException
            double realValue = Double.parseDouble(value); 

            //String outputString = "Passing " + realValue + " through";
            /*for (int i = 0; i < args.length - 2; i++) {
                String conversion = args[i];
                UnitConverter externalConverter = ConverterFactory.create(conversion);
                UnitConverter innerConverter = ConverterFactory.create(conversion);
                outputString += " " + converter.toString() + " and";
                converter.convertAndPrint(realValue);
                realValue = converter.convert(realValue);
            }*/
            UnitConverter completeConversion = chain(converter);
            //System.out.println("FIRST CALLED CONV: " + completeConversion.getClass().toString());
            completeConversion.convertAndPrint(realValue);
            //outputString += " now the final value is " + realValue;
            //System.out.println(outputString);
        }
        catch(NumberOfArgsException e){
            System.out.println(e.getMessage());
            System.out.println("Use of Main function: java Main <type-of-conversion> <real-number>");
        }
        catch(BadConversionStringException e){
            System.out.println(e.getMessage());
            System.out.println("The available conversions are:");
                System.out.println("\t- DollarToEuro,");
                System.out.println("\t- BritishPoundToSwissFranc,");
                System.out.println("\t- EuroToBritishPound,");
                System.out.println("\t- AtmosphereToPascal,");
                System.out.println("\t- BarToKilogramPerSquaredMeter,");
                System.out.println("\t- KilogramToPound,");
                System.out.println("\t- OunceToGram");
        }
        catch(NumberFormatException e){
            System.out.println("Unvalid second argument: " + e.getMessage() + "!");
            System.out.println("Please, write a valid real number");
        }
    }
}