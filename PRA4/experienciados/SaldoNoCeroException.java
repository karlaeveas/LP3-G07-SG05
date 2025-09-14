package experienciados;

public class SaldoNoCeroException extends Exception {
    public SaldoNoCeroException(String mensaje) {
        super(mensaje);
    }
}