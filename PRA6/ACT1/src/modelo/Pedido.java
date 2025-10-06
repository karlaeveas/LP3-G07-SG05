package modelo;

public class Pedido {
    private int id;
    private String nombreCliente;
    private String plato;
    private double precio;

    public Pedido(int id, String nombreCliente, String plato, double precio) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.plato = plato;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getPlato() {
        return plato;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Pedido #" + id + " | Cliente: " + nombreCliente + " | Plato: " + plato + " | Precio: S/." + precio;
    }
}
