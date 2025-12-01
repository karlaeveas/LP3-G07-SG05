package ejerciciotres;

public class ItemCarrito {

    private Libro libro;
    private int cantidad;

    public ItemCarrito(Libro libro, int cantidad) {
        this.libro = libro;
        this.cantidad = cantidad;
    }

    public Libro getLibro() {
        return libro;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void agregarCantidad(int extra) {
        this.cantidad += extra;
    }

    public double getSubtotal() {
        return libro.getPrecio() * cantidad;
    }

    @Override
    public String toString() {
        return libro.getTitulo() + " x " + cantidad + " = S/ " + getSubtotal();
    }
}

