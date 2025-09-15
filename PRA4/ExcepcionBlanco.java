package ejerciciouno;


public class ExcepcionBlanco extends Exception {
    private static final long serialVersionUID = 1L;

    public ExcepcionBlanco() {
        super("Se ingresó un espacio en blanco");
    }
}