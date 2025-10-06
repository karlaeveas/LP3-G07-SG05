package modelo;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos = new ArrayList<>();

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public boolean eliminarProducto(int id) {
        return productos.removeIf(p -> p.getId() == id);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double calcularTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    public void vaciar() {
        productos.clear();
    }
}

