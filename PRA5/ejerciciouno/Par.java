package ejerciciouno;

public class Par<F, S> {
    private F primero;
    private S segundo;

    // Constructor
    public Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    // Metodos getter
    public F getPrimero() {
        return primero;
    }

    public S getSegundo() {
        return segundo;
    }

   
    public void setPrimero(F primero) {
        this.primero = primero;
    }

    public void setSegundo(S segundo) {
        this.segundo = segundo;
    }

    @Override
    public String toString() {
        return "(Primero: " + primero + ", Segundo: " + segundo + ")";
    }
    
}
