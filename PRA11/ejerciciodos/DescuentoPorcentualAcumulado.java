package ejerciciodos;

import java.util.List;

public class DescuentoPorcentualAcumulado implements EstrategiaDescuento {

    @Override
    public double calcularTotal(List<Producto> productos) {
        double total = 0.0;
        int cantidadTotal = 0;
        double precioMinimo = Double.MAX_VALUE;

        for (Producto p : productos) {
            total += p.getSubtotal();
            cantidadTotal += p.getCantidad();

            if (p.getPrecio() < precioMinimo) {
                precioMinimo = p.getPrecio();
            }
        }

        if (cantidadTotal >= 3 && precioMinimo != Double.MAX_VALUE) {
            double descuento = precioMinimo * 0.50; // 50% al más barato
            total -= descuento;
        }

        return total;
    }
}
