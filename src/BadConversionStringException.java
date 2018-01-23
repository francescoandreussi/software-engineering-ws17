///The structure of this Exception class is inspired to the examples in the book
///"JAVA: an Introduction to Problem Solving and Programming" (Italian translation), 6th Edition, by Walter Savitch
public class BadConversionStringException extends RuntimeException{
	public BadConversionStringException(){
		super("The conversion string is invalid");
	}

	public BadConversionStringException(String message){
		super(message);
	}
}