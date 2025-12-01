package ejerciciotres;

import java.util.List;

public class DescuentoFijo implements EstrategiaDescuento {

    @Override
    public double calcularTotal(List<ItemCarrito> items) {
        double total = 0.0;
        for (ItemCarrito item : items) {
            total += item.getSubtotal();
        }
        double descuento = total * 0.10; // 10%
        return total - descuento;
    }
}
