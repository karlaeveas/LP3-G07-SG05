package ejerciciouno;

public class ExcepcionNumero extends Exception {
	private static final long serialVersionUID = 1L;

    public ExcepcionNumero(char c) {
        super("Se ingresó un número: " + c);
    }
}
