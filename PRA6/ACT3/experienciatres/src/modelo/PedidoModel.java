package modelo;

import java.util.ArrayList;
import java.util.List;

public class PedidoModel {
    private List<Pedido> pedidos;

    public PedidoModel() {
        pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido p) {
        pedidos.add(p);
    }

    public void eliminarPedido(int id) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                p.setEstado("eliminado");
                return;
            }
        }
    }

    public void marcarCompleto(int id) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                p.setEstado("completo");
                return;
            }
        }
    }

    public List<Pedido> obtenerPedidosPorEstado(String estado) {
        List<Pedido> filtrados = new ArrayList<>();
        for (Pedido p : pedidos) {
            if (p.getEstado().equalsIgnoreCase(estado)) {
                filtrados.add(p);
            }
        }
        return filtrados;
    }

    public int contarPendientes() {
        int contador = 0;
        for (Pedido p : pedidos) {
            if (p.getEstado().equalsIgnoreCase("pendiente")) {
                contador++;
            }
        }
        return contador;
    }

    public List<Pedido> obtenerTodos() {
        return pedidos;
    }
}
