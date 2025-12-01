package ejerciciodos;

import java.util.List;

public class DescuentoFijo implements EstrategiaDescuento {

    @Override
    public double calcularTotal(List<Producto> productos) {
        double total = 0.0;
        for (Producto p : productos) {
            total += p.getSubtotal();
        }
        // 10% de descuento sobre el total
        double descuento = total * 0.10;
        return total - descuento;
    }
}
