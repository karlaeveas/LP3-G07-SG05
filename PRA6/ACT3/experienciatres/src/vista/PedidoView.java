package vista;

import modelo.Pedido;
import java.util.List;

public class PedidoView {

    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos para mostrar.");
        } else {
            for (Pedido p : pedidos) {
                System.out.println(p);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarContadorPendientes(int cantidad) {
        System.out.println("Pedidos pendientes: " + cantidad);
    }
}
