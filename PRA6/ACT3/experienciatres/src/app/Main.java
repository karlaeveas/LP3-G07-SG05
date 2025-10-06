package app;

import modelo.*;
import vista.*;
import controlador.*;

public class Main {
    public static void main(String[] args) {
        PedidoModel modelo = new PedidoModel();
        PedidoView vista = new PedidoView();
        PedidoController controlador = new PedidoController(modelo, vista);

        controlador.crearPedido(1, "Hamburguesa doble con queso");
        controlador.crearPedido(2, "Café americano");
        controlador.crearPedido(3, "Empanada de pollo");

        controlador.mostrarContadorPendientes();

        controlador.marcarCompleto(2);
        controlador.eliminarPedido(3);

        controlador.mostrarPedidosPorEstado("pendiente");
        controlador.mostrarPedidosPorEstado("completo");
        controlador.mostrarHistorial();
    }
}
