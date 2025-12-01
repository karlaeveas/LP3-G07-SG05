package ejerciciotres;

import java.util.List;

public class DescuentoPorcentualAcumulado implements EstrategiaDescuento {

    @Override
    public double calcularTotal(List<ItemCarrito> items) {
        double total = 0.0;
        int cantidadTotal = 0;
        double precioMinimo = Double.MAX_VALUE;

        for (ItemCarrito item : items) {
            total += item.getSubtotal();
            cantidadTotal += item.getCantidad();

            if (item.getLibro().getPrecio() < precioMinimo) {
                precioMinimo = item.getLibro().getPrecio();
            }
        }

        if (cantidadTotal >= 3 && precioMinimo != Double.MAX_VALUE) {
            double descuento = precioMinimo * 0.50; // 50% al libro más barato
            total -= descuento;
        }

        return total;
    }
}

