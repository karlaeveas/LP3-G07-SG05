package ejerciciotres;

import java.util.List;

public class DescuentoPorcentual implements EstrategiaDescuento {

    @Override
    public double calcularTotal(List<ItemCarrito> items) {
        double total = 0.0;

        for (ItemCarrito item : items) {
            double subtotal = item.getSubtotal();

            if (item.getCantidad() >= 2) {
                int unidadesConDescuento = Math.min(2, item.getCantidad());
                double descuentoPorUnidad = item.getLibro().getPrecio() * 0.30; // 30%
                double descuento = unidadesConDescuento * descuentoPorUnidad;
                total += (subtotal - descuento);
            } else {
                total += subtotal;
            }
        }

        return total;
    }
}
