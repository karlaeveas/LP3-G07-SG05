package ejerciciodos;

import java.util.List;

public class DescuentoPorcentual implements EstrategiaDescuento {

    @Override
    public double calcularTotal(List<Producto> productos) {
        double total = 0.0;

        for (Producto p : productos) {
            double subtotal = p.getSubtotal();

            if (p.getCantidad() >= 2) {
                int unidadesConDescuento = Math.min(2, p.getCantidad());
                double descuentoPorUnidad = p.getPrecio() * 0.30; // 30%
                double descuento = unidadesConDescuento * descuentoPorUnidad;
                total += (subtotal - descuento);
            } else {
                total += subtotal;
            }
        }

        return total;
    }
}
