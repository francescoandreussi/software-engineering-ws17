///The structure of this Exception class is inspired to the examples in the book
///"JAVA: an Introduction to Problem Solving and Programming" (Italian translation), 6th Edition, by Walter Savitch
public class ValueOutOfRangeException extends RuntimeException{
	public ValueOutOfRangeException(){
		super("The conversion value is invalid");
	}

	public ValueOutOfRangeException(String message){
		super(message);
	}
}