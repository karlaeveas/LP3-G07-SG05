package actividaddos;

public class Pila<E> {
    private final int tamanio;
    private int superior;
    private E[] elementos;

    public Pila() {
        this(10);
    }

    public Pila(int s) {
        tamanio = s > 0 ? s : 10;
        superior = -1;
        elementos = (E[]) new Object[tamanio];
    }

    public void push(E valorAMeter) {
        if (superior == tamanio - 1)
            throw new RuntimeException("La Pila está llena, no se puede meter " + valorAMeter);
        elementos[++superior] = valorAMeter;
    }

    public E pop() {
        if (superior == -1)
            throw new RuntimeException("Pila vacía, no se puede sacar");
        return elementos[superior--];
    }

    // Nuevo método contains
    public boolean contains(E elemento) {
        for (int i = superior; i >= 0; i--) {
            if (elementos[i].equals(elemento)) {
                return true;
            }
        }
        return false;
    }
}

