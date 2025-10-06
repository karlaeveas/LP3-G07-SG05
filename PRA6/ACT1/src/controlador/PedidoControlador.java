package controlador;

import modelo.PedidoModelo;
import vista.PedidoVista;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            int opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1:
                    String nombre = vista.leerTexto("Ingrese el nombre del cliente: ");
                    String plato = vista.leerTexto("Ingrese el nombre del plato: ");
                    double precio = vista.leerDouble("Ingrese el precio: ");
                    modelo.agregarPedido(nombre, plato, precio);
                    vista.mostrarMensaje("✅ Pedido agregado correctamente.\n");
                    break;

                case 2:
                    vista.mostrarPedidos(modelo.obtenerPedidos());
                    break;

                case 3:
                    vista.mostrarMensaje("👋 Saliendo del sistema...");
                    salir = true;
                    break;

                default:
                    vista.mostrarMensaje("⚠️ Opción no válida. Intente nuevamente.");
            }
        }
    }
}
