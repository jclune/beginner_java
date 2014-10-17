
public class HogeException extends Exception{
	public HogeException(String message){
		super(message);
	}
	public HogeException(String message, Throwable throwable){
		super(message,throwable);
	}
}
