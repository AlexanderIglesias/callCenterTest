package exeption;

public class CallCenterExeptions extends Exception{

	private static final long serialVersionUID = 380428475203908281L;
	
	public CallCenterExeptions(String message, Exception error) {
		super(message, error);
	}

}
