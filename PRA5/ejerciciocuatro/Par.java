package ejerciciocuatro;

//Clase Par genérica
public class Par<F, S> {
 private F primero;
 private S segundo;

 // Constructor
 public Par(F primero, S segundo) {
     this.primero = primero;
     this.segundo = segundo;
 }

 // Getters y setters
 public F getPrimero() {
     return primero;
 }

 public void setPrimero(F primero) {
     this.primero = primero;
 }

 public S getSegundo() {
     return segundo;
 }

 public void setSegundo(S segundo) {
     this.segundo = segundo;
 }

 // Representación en String
 @Override
 public String toString() {
     return "(Primero: " + primero + ", Segundo: " + segundo + ")";
 }

 // Método para comparar pares
 public boolean esIgual(Par<F, S> otro) {
     if (otro == null) return false;
     return this.primero.equals(otro.getPrimero()) &&
            this.segundo.equals(otro.getSegundo());
 }
}

