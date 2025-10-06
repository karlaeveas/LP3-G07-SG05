package modelo;

import java.util.ArrayList;
import java.util.List;

public class TiendaModelo {
    private List<Producto> catalogo;
    private Carrito carrito;
    private List<Compra> historial;
    private int contadorId = 1;

    public TiendaModelo() {
        catalogo = new ArrayList<>();
        carrito = new Carrito();
        historial = new ArrayList<>();
    }

    // Catálogo
    public void agregarProductoCatalogo(String nombre, double precio) {
        catalogo.add(new Producto(contadorId++, nombre, precio));
    }

    public List<Producto> getCatalogo() {
        return catalogo;
    }

    public Producto buscarProductoPorId(int id) {
        for (Producto p : catalogo)
            if (p.getId() == id)
                return p;
        return null;
    }

    // Carrito
    public void agregarAlCarrito(Producto p) {
        carrito.agregarProducto(p);
    }

    public boolean eliminarDelCarrito(int id) {
        return carrito.eliminarProducto(id);
    }

    public List<Producto> verCarrito() {
        return carrito.getProductos();
    }

    public double calcularTotalCarrito() {
        return carrito.calcularTotal();
    }

    public void aplicarDescuento(double porcentaje) {
        double factor = (100 - porcentaje) / 100;
        List<Producto> nuevos = new ArrayList<>();
        for (Producto p : carrito.getProductos()) {
            nuevos.add(new Producto(p.getId(), p.getNombre(), p.getPrecio() * factor));
        }
        carrito.vaciar();
        nuevos.forEach(carrito::agregarProducto);
    }

    public double calcularEnvio() {
        double total = carrito.calcularTotal();
        if (total > 150) return 0;
        else return 15;
    }

    // Compra
    public void realizarCompra() {
        double total = carrito.calcularTotal() + calcularEnvio();
        historial.add(new Compra(new ArrayList<>(carrito.getProductos()), total));
        carrito.vaciar();
    }

    public List<Compra> getHistorial() {
        return historial;
    }
}
