package ejerciciodos;

public class DivisionPorCeroException extends Exception {
	private static final long serialVersionUID = 1L;
    public DivisionPorCeroException(String mensaje) {
        super(mensaje);
    }
}
