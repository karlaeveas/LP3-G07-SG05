package vista;

import java.util.List;
import java.util.Scanner;
import modelo.Pedido;

public class PedidoVista {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n=== SISTEMA DE PEDIDOS ===");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Ver Lista de Pedidos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Actualizar Pedido");
        System.out.println("5. Buscar Pedido");
        System.out.println("6. Contar Pedidos");
        System.out.println("7. Salir");
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

    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados o no se encontraron coincidencias.");
        } else {
            System.out.println("\n--- Lista de Pedidos ---");
            for (Pedido p : pedidos) {
                System.out.println(p);
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
