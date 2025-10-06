package controlador;

import modelo.*;
import vista.TiendaVista;

public class TiendaControlador {
    private TiendaModelo modelo;
    private TiendaVista vista;

    public TiendaControlador(TiendaModelo modelo, TiendaVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        boolean salir = false;

        while (!salir) {
            int opcion = vista.mostrarMenu();

            switch (opcion) {
                case 1: // Agregar producto al catálogo
                    String nombre = vista.leerTexto("Ingrese nombre del producto: ");
                    double precio = vista.leerDouble("Ingrese precio: ");
                    modelo.agregarProductoCatalogo(nombre, precio);
                    vista.mostrarMensaje("Producto agregado al catálogo.");
                    break;

                case 2: // Listar productos
                    vista.mostrarProductos(modelo.getCatalogo());
                    break;

                case 3: // Agregar al carrito
                    int idAgregar = vista.leerEntero("Ingrese ID del producto a agregar: ");
                    Producto p = modelo.buscarProductoPorId(idAgregar);
                    if (p != null) {
                        modelo.agregarAlCarrito(p);
                        vista.mostrarMensaje(" Producto agregado al carrito.");
                    } else {
                        vista.mostrarMensaje(" Producto no encontrado.");
                    }
                    break;

                case 4: // Ver carrito
                    vista.mostrarProductos(modelo.verCarrito());
                    vista.mostrarMensaje("Total actual: S/." + modelo.calcularTotalCarrito());
                    break;

                case 5: // Eliminar del carrito
                    int idEliminar = vista.leerEntero("Ingrese ID del producto a eliminar: ");
                    if (modelo.eliminarDelCarrito(idEliminar))
                        vista.mostrarMensaje(" Producto eliminado del carrito.");
                    else
                        vista.mostrarMensaje("Producto no encontrado en el carrito.");
                    break;

                case 6: // Aplicar descuento
                    double descuento = vista.leerDouble("Ingrese porcentaje de descuento (%): ");
                    modelo.aplicarDescuento(descuento);
                    vista.mostrarMensaje(" Descuento aplicado correctamente.");
                    break;

                case 7: // Calcular envío
                    double envio = modelo.calcularEnvio();
                    if (envio == 0)
                        vista.mostrarMensaje(" Envío gratuito por compras mayores a S/.150.");
                    else
                        vista.mostrarMensaje(" Costo de envío: S/." + envio);
                    break;

                case 8: // Realizar compra
                    modelo.realizarCompra();
                    vista.mostrarMensaje(" Compra realizada con éxito. ¡Gracias por su compra!");
                    break;

                case 9: // Historial
                    vista.mostrarCompras(modelo.getHistorial());
                    break;

                case 10: // Salir
                    vista.mostrarMensaje(" Saliendo del sistema...");
                    salir = true;
                    break;

                default:
                    vista.mostrarMensaje(" Opción no válida.");
            }
        }
    }
}
