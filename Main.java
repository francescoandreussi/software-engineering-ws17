class Main {
    public static void main(String[] args)
    {
        try{
            if(args.length != 2){
                //if the command line call does not have two args throws an Exception to avoid an out-of-bounds-reading
                throw new NumberOfArgsException("Main requires 2 arguments!");
            }

            String conversion = args[0];
            String value = args[1];

            //Double.parseDouble function was copied from
            //https://stackoverflow.com/questions/5769669/convert-string-to-double-in-java.
            //It converts a string into a double, if the string is invalid it thorws a NumberFormatException
            double realValue = Double.parseDouble(value); 
            
            UnitConverter converter = ConverterFactory.create(conversion);
            converter.convertAndPrint(realValue);
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