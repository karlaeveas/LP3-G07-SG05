package ejerciciouno;

public class ExcepcionSalida extends Exception {
    private static final long serialVersionUID = 1L;

    public ExcepcionSalida() {
        super("Se ingresó el carácter de salida. Programa finalizado.");
    }
}