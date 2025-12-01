package ejerciciodos;

import java.util.List;

public class CalculadoraDePrecios {

    private EstrategiaDescuento estrategia;

    public void setEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularTotal(List<Producto> productos) {
        if (estrategia == null) {
            throw new IllegalStateException("No se ha configurado una estrategia de descuento.");
        }
        return estrategia.calcularTotal(productos);
    }

    public double calcularSubtotal(List<Producto> productos) {
        double subtotal = 0.0;
        for (Producto p : productos) {
            subtotal += p.getSubtotal();
        }
        return subtotal;
    }
}
