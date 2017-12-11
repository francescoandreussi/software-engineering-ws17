import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// IMPORTANT: the Inversion decorator must be the outermost element of the chain
// and it can invert the whole chain!
public class Inversion extends UnitConverter {
    private UnitConverter base_conversion = null;
    
    public Inversion() {
        this.base_conversion = null;
    }

    public Inversion(UnitConverter converter) {
        this.base_conversion = converter;
    }

    public void setConversionFactor(double newFactor) { }

    public double getConversionFactor() {
        return 0.0;
    }

    public void link(UnitConverter converter) {
        this.base_conversion = converter;
    }

    public UnitConverter clone() {
        return new Inversion(null);
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
        //String word[] = conversionString.split(" ");
        //String outputString = word[2];
        //word[2] = word[0];
        //for (int i = 1; i < word.length; i++) {
        //    outputString += " " + word[i];
        //}
        return outString.trim();
    }

    public void convertAndPrint(double value){
        //this.invertConversion(this.base_conversion);
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