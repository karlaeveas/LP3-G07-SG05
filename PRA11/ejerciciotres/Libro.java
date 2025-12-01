package ejerciciotres;

public class Libro {

    private int id;
    private String titulo;
    private double precio;

    public Libro(int id, String titulo, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + titulo + " - S/ " + precio;
    }
}
