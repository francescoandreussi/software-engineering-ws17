public class BadConversionStringException extends Exception{
	public BadConversionStringException(){
		super("The conversion string is invalid");
	}

	public BadConversionStringException(String message){
		super(message);
	}
}