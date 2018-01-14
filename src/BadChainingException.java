///The structure of this Exception class is inspired to the examples in the book
///"JAVA: an Introduction to Problem Solving and Programming" (Italian translation), 6th Edition, by Walter Savitch
public class BadChainingException extends Exception{
	public BadChainingException(){
		super("The converter chaining is invalid");
	}

	public BadChainingException(String message){
		super(message);
	}
}