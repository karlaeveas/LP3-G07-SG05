package modelo;

import java.util.List;

public class Compra {
    private List<Producto> productos;
    private double total;

    public Compra(List<Producto> productos, double total) {
        this.productos = productos;
        this.total = total;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Compra de " + productos.size() + " productos. Total: S/." + total;
    }
}
