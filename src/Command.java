public class Command {

    public UnitConverter converter;
    public double value;

    public Command(UnitConverter c) {
        this.converter = c;
        this.value = 0;
    }
    
    public Command(UnitConverter c, double v){
        this.converter = c;
        this.value = v;
    }

    public UnitConverter getConverter(){
        return converter;
    }

    public double getValue() {
        return value;
    }
    
    public void setValue(double v) {
        this.value = v;
    }

    public void execute(boolean isInverted){
        this.converter.convertAndPrint(this.value, isInverted);
    }
}