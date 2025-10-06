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
                case 1: // Agregar
                    String nombre = vista.leerTexto("Ingrese el nombre del cliente: ");
                    String plato = vista.leerTexto("Ingrese el nombre del plato: ");
                    String tipo = vista.leerTexto("Ingrese el tipo de plato (Entrada, Segundo, Postre, Bebida...): ");
                    double precio = vista.leerDouble("Ingrese el precio: ");
                    modelo.agregarPedido(nombre, plato, tipo, precio);
                    vista.mostrarMensaje("✅ Pedido agregado correctamente.\n");
                    break;

                case 2: // Mostrar
                    vista.mostrarPedidos(modelo.obtenerPedidos());
                    break;

                case 3: // Eliminar
                    int idEliminar = vista.leerEntero("Ingrese el ID del pedido a eliminar: ");
                    if (modelo.eliminarPedido(idEliminar))
                        vista.mostrarMensaje("🗑️ Pedido eliminado correctamente.");
                    else
                        vista.mostrarMensaje("⚠️ Pedido no encontrado.");
                    break;

                case 4: // Actualizar
                    int idActualizar = vista.leerEntero("Ingrese el ID del pedido a actualizar: ");
                    String nuevoPlato = vista.leerTexto("Ingrese el nuevo nombre del plato: ");
                    if (modelo.actualizarPedido(idActualizar, nuevoPlato))
                        vista.mostrarMensaje("✏️ Pedido actualizado correctamente.");
                    else
                        vista.mostrarMensaje("⚠️ Pedido no encontrado.");
                    break;

                case 5: // Buscar
                    String criterio = vista.leerTexto("Ingrese el nombre o tipo a buscar: ");
                    vista.mostrarPedidos(modelo.buscarPedido(criterio));
                    break;

                case 6: // Contar
                    vista.mostrarMensaje("📊 Total de pedidos: " + modelo.contarTotalPedidos());
                    String tipoContar = vista.leerTexto("Ingrese el tipo para contar (Entrada, Segundo, etc.): ");
                    vista.mostrarMensaje("📦 Pedidos del tipo '" + tipoContar + "': " + modelo.contarPorTipo(tipoContar));
                    break;

                case 7: // Salir
                    vista.mostrarMensaje("👋 Saliendo del sistema...");
                    salir = true;
                    break;

                default:
                    vista.mostrarMensaje("⚠️ Opción no válida. Intente nuevamente.");
            }
        }
    }
}
