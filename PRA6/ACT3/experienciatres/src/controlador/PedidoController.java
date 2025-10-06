package controlador;

import modelo.*;
import vista.*;
import java.util.List;

public class PedidoController {
    private PedidoModel modelo;
    private PedidoView vista;

    public PedidoController(PedidoModel modelo, PedidoView vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void crearPedido(int id, String descripcion) {
        Pedido p = new Pedido(id, descripcion);
        modelo.agregarPedido(p);
        vista.mostrarMensaje("Pedido creado: " + descripcion);
    }

    public void eliminarPedido(int id) {
        modelo.eliminarPedido(id);
        vista.mostrarMensaje("Pedido #" + id + " eliminado del sistema.");
    }

    public void marcarCompleto(int id) {
        modelo.marcarCompleto(id);
        vista.mostrarMensaje("Pedido #" + id + " marcado como completo.");
    }

    public void mostrarPedidosPorEstado(String estado) {
        List<Pedido> lista = modelo.obtenerPedidosPorEstado(estado);
        vista.mostrarMensaje("Pedidos en estado: " + estado);
        vista.mostrarPedidos(lista);
    }

    public void mostrarContadorPendientes() {
        int cantidad = modelo.contarPendientes();
        vista.mostrarContadorPendientes(cantidad);
    }

    public void mostrarHistorial() {
        vista.mostrarMensaje("Historial de pedidos (completos o eliminados):");
        List<Pedido> historial = new java.util.ArrayList<>();
        for (Pedido p : modelo.obtenerTodos()) {
            if (!p.getEstado().equalsIgnoreCase("pendiente")) {
                historial.add(p);
            }
        }
        vista.mostrarPedidos(historial);
    }
}
