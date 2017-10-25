class Main {
    public static void main(String[] args)
    {
        try{
            if(args.length != 2){
                throw new NumberOfArgsException("Main requires 2 arguments!");
            }

            String conversion = args[0];
            String value = args[1];

            //Double.parseDouble function was copied from
            //https://stackoverflow.com/questions/5769669/convert-string-to-double-in-java.
            //It converts a string into a double, if the string is invalid it thorws a NumberFormatException
            double realValue = Double.parseDouble(value); 
            
            UnitConverter myConverter;  //initialise the object that will call the converter
            
            //Calling the right conversion with its value with respect to the input
            switch (conversion) {
            case "DollarToEuro":
                myConverter = new DollarToEuroConverter();
                double euros = myConverter.convert(realValue);
                System.out.println(myConverter.toString() + " has converted " + value + " USD to " + euros + " EUR!");
                break;
            case "BritishPoundToSwissFranc":
                myConverter = new BritishPoundToSwissFrancConverter();
                double francs = myConverter.convert(realValue);
                System.out.println(myConverter.toString() + " has converted " + value + " GPB to " + francs + " CHF!");
            break;
            case "AtmosphereToPascal":
                myConverter = new AtmToPascalConverter();
                double pascals = myConverter.convert(realValue);
                System.out.println(myConverter.toString() + " has converted " + value + " Atm to " + pascals + " Pa!");
                break;
            case "BarToKilogramPerSquaredMeter":
                myConverter = new BarToKgPerSqMtConverter();
                double kgPerSqM = myConverter.convert(realValue);
                System.out.println(myConverter.toString() + " has converted " + value + " b to " + kgPerSqM + " kg/Sq.m!");
            break;
            case "KilogramToPound":
                myConverter = new KiloToPoundConverter();
                double pounds = myConverter.convert(realValue);
                System.out.println(myConverter.toString() + " has converted " + value + " kg to " + pounds + " lb!");
            break;
            case "OunceToGram":
                myConverter = new OunceToGramConverter();
                double grams = myConverter.convert(realValue);
                System.out.println(myConverter.toString() + " has converted " + value + " oz to " + grams + " g!");
                break;
            default:
                //if the string in the input is different to those written in the case branches of the switch throw exception
                throw new BadConversionStringException("The first argument is not a valid conversion string!");
            }
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