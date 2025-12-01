package ejerciciotres;

import java.util.List;

public class SinDescuento implements EstrategiaDescuento {

    @Override
    public double calcularTotal(List<ItemCarrito> items) {
        double total = 0.0;
        for (ItemCarrito item : items) {
            total += item.getSubtotal();
        }
        return total;
    }
}

