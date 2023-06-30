package tp.emprunt;

public class MontantEmprunteException extends RuntimeException {

	public MontantEmprunteException() {
	}

	public MontantEmprunteException(String message) {
		super(message);
	}


	public MontantEmprunteException(String message, Throwable cause) {
		super(message, cause);	
	}
}
