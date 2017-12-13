import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

// IMPORTANT: the Inversion decorator must be the outermost element of the chain
// and it can invert the whole chain!
public class Inversion extends UnitConverter {
    private UnitConverter base_conversion = null;
    
    public Inversion() {
        this.base_conversion = null;
    }

    public Inversion(UnitConverter converter) throws BadChainingException {
        if (! converter.toString().equals("Inversion")) { // Checking that converter is NOT an instance of Inversion
            this.base_conversion = converter;
        } else {
            throw new BadChainingException("chaining two Inversion objects is NOT possible!");
        }
    }

    public UnitConverter getBaseConverter() {
        return base_conversion;
    }

    public HashMap<Class, Class> getMap() {
        return null;
    }

    public void setConversionFactor(double newFactor) { }

    public double getConversionFactor() {
        return 0.0;
    }
    
    public double getOriginalConversionFactor() {
        return 0.0;
    }

    public void link(UnitConverter converter) {
        this.base_conversion = converter;
    }

    public UnitConverter clone() {
        return new Inversion();
    }

    public double simpleConvert(double inValue){
        return convert(inValue);
    }
    
    public String toString(){
        return "Inversion";
    }


    private void invertConversion(UnitConverter converter){
        if (converter.base_conversion == null) { // if the converter chain has only one element
                converter.setConversionFactor(1.0 / converter.getConversionFactor());
            } else {
                converter.setConversionFactor(1.0 / converter.getConversionFactor());
                invertConversion(converter.base_conversion);
            }
    }

    public double convert(double inValue){
        this.invertConversion(this.base_conversion);
        return this.base_conversion.convert(inValue);
    }

    public String invertString(String conversionString){
        String line[] = conversionString.split("\n");
        String outString = "";
        for (String l : line) {
            String outLine = "";
            String word[] = l.split(" ");
            outLine = word[2];
            word[2] = word[0];
            String temp = word[6];
            word[6] = word[9].substring(0, word[9].length() - 1);
            word[9] = temp + "!";
            for (int i = 1; i < word.length; i++) {
                outLine += " " + word[i];
            }
            outString += outLine + "\n";
        }
        return outString.trim();
    }

    // IMPORTANT: this Inversion.convertAndPrint should be called only from instances of Command or of Inversion itself!
    public void convertAndPrint(double value){
        if (this.base_conversion.getConversionFactor() == this.base_conversion.getOriginalConversionFactor()) {
            invertConversion(this.base_conversion);
        } else {
        }

        // This function is based on the code found at this link:
        // https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java

        // Create a stream to hold the output
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        // IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);
        // Print some output: goes to your special stream
        base_conversion.convertAndPrint(value);
        // Put things back
        System.out.flush();
        System.setOut(old);

        // Modify the output of this.base_conversion.convertAndPrint(value)
        String invertedString = this.invertString(baos.toString());
        // Print the correct string
        System.out.println(invertedString);
    }
}