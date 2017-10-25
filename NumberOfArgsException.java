///The structure of this Exception class is inspired to the examples in the book
///"JAVA: an Introduction to Problem Solving and Programming" (Italian translation), 6th Edition, by Walter Savitch
public class NumberOfArgsException extends Exception{
	public NumberOfArgsException(){
		super("Wrong number of arguments!");
	}

	public NumberOfArgsException(String message){
		super(message);
	}
}