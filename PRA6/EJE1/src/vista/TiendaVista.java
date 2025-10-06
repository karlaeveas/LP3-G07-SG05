package vista;

import java.util.List;
import java.util.Scanner;
import modelo.Producto;
import modelo.Compra;

public class TiendaVista {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n=== SISTEMA DE CARRITO DE COMPRAS ===");
        System.out.println("1. Agregar Producto al Catálogo");
        System.out.println("2. Listar Productos");
        System.out.println("3. Agregar Producto al Carrito");
        System.out.println("4. Ver Carrito");
        System.out.println("5. Eliminar Producto del Carrito");
        System.out.println("6. Aplicar Descuento");
        System.out.println("7. Calcular Envío");
        System.out.println("8. Realizar Compra");
        System.out.println("9. Ver Historial de Compras");
        System.out.println("10. Salir");
        System.out.print("Seleccione una opción: ");
        return sc.nextInt();
    }

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        sc.nextLine(); // limpiar buffer
        return sc.nextLine();
    }

    public double leerDouble(String mensaje) {
        System.out.print(mensaje);
        return sc.nextDouble();
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return sc.nextInt();
    }

    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) System.out.println("No hay productos disponibles.");
        else productos.forEach(System.out::println);
    }

    public void mostrarCompras(List<Compra> compras) {
        if (compras.isEmpty()) System.out.println("No hay compras registradas.");
        else compras.forEach(System.out::println);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
