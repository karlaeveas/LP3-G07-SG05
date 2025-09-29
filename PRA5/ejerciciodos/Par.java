package ejerciciodos;

public class Par<F, S> {
    private F primero;
    private S segundo;

    public Par(F primero, S segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public F getPrimero() { return primero; }
    public S getSegundo() { return segundo; }
    public void setPrimero(F primero) { this.primero = primero; }
    public void setSegundo(S segundo) { this.segundo = segundo; }

    // Representación en texto
    @Override
    public String toString() {
        return "(Primero: " + primero + ", Segundo: " + segundo + ")";
    }

    // Método esIgual
    public boolean esIgual(Par<F, S> otroPar) {
        return this.primero.equals(otroPar.getPrimero()) &&
               this.segundo.equals(otroPar.getSegundo());
    }
}
