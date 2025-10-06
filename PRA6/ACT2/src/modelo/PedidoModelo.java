package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoModelo {
    private List<Pedido> pedidos;
    private int contadorId = 1;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    // Agregar pedido
    public void agregarPedido(String nombreCliente, String plato, String tipo, double precio) {
        Pedido nuevo = new Pedido(contadorId++, nombreCliente, plato, tipo, precio);
        pedidos.add(nuevo);
    }

    // Obtener lista de pedidos
    public List<Pedido> obtenerPedidos() {
        return pedidos;
    }

    // Eliminar pedido por ID
    public boolean eliminarPedido(int id) {
        return pedidos.removeIf(p -> p.getId() == id);
    }

    // Actualizar nombre del plato
    public boolean actualizarPedido(int id, String nuevoPlato) {
        for (Pedido p : pedidos) {
            if (p.getId() == id) {
                p.setPlato(nuevoPlato);
                return true;
            }
        }
        return false;
    }

    // Buscar por nombre o tipo
    public List<Pedido> buscarPedido(String criterio) {
        return pedidos.stream()
                .filter(p -> p.getPlato().equalsIgnoreCase(criterio)
                          || p.getTipo().equalsIgnoreCase(criterio))
                .collect(Collectors.toList());
    }

    // Contar total de pedidos
    public int contarTotalPedidos() {
        return pedidos.size();
    }

    // Contar por tipo
    public long contarPorTipo(String tipo) {
        return pedidos.stream().filter(p -> p.getTipo().equalsIgnoreCase(tipo)).count();
    }
}
