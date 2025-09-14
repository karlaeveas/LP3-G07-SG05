package ejerciciotres;

public class Numero {
    private double valor;

    // Constructor con validación
    public Numero(double valor) {
        setValor(valor);
    }

    // Método setter con validación
    public void setValor(double valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El valor no puede ser negativo.");
        }
        this.valor = valor;
    }

    // Método getter
    public double getValor() {
        return valor;
    }
}