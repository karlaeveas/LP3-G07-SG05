package modelo;

public class Pedido {
    private int id;
    private String nombreCliente;
    private String plato;
    private String tipo; // NUEVO
    private double precio;

    public Pedido(int id, String nombreCliente, String plato, String tipo, double precio) {
        this.id = id;
        this.nombreCliente = nombreCliente;
        this.plato = plato;
        this.tipo = tipo;
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

    public void setPlato(String plato) {
        this.plato = plato;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Pedido #" + id + " | Cliente: " + nombreCliente + 
               " | Plato: " + plato + " (" + tipo + ") | Precio: S/." + precio;
    }
}
