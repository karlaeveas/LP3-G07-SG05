package actividaduno;

public class InvalidSubscriptException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidSubscriptException(String mensaje) {
        super(mensaje);
    }
}