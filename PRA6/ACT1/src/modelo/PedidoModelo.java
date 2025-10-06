package modelo;

import java.util.ArrayList;
import java.util.List;

public class PedidoModelo {
    private List<Pedido> pedidos;
    private int contadorId = 1;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    public void agregarPedido(String nombreCliente, String plato, double precio) {
        Pedido nuevo = new Pedido(contadorId++, nombreCliente, plato, precio);
        pedidos.add(nuevo);
    }

    public List<Pedido> obtenerPedidos() {
        return pedidos;
    }
}
