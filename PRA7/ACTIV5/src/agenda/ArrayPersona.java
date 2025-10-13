package agenda;

public class ArrayPersona {
    private Persona[] arreglo;
    private final int max = 120;
    private int tamano = 0;

    public ArrayPersona() {
        this.arreglo = new Persona[this.max];
    }

    public void imprimirArray(String nombre) {
        boolean encontrado = false;
        for (int i = 0; i < this.tamano; i++) {
            if (this.arreglo[i].getNombre().equalsIgnoreCase(nombre)) {
                System.out.println(this.arreglo[i]);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró el contacto: " + nombre);
        }
    }

    public void addArray(Persona persona) {
        if (this.tamano < this.max) {
            this.arreglo[this.tamano++] = persona;
        } else {
            System.out.println("El arreglo está lleno.");
        }
    }
}
