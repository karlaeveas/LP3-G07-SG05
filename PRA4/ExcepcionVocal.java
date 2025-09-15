package ejerciciouno;

public class ExcepcionVocal extends Exception {
	private static final long serialVersionUID = 1L;

    public ExcepcionVocal(char c) {
        super(" Se ingresó una vocal: " + c);
    }
}