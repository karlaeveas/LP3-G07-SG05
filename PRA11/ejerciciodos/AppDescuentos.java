package ejerciciodos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppDescuentos {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Producto> productos = new ArrayList<>();

        System.out.println("=== SISTEMA DE DESCUENTOS (STRATEGY) ===");

        System.out.print("¿Cuántos productos desea ingresar? ");
        int n = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer

        for (int i = 1; i <= n; i++) {
            System.out.println("\nProducto " + i + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            System.out.print("Precio unitario: ");
            double precio = scanner.nextDouble();

            System.out.print("Cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            productos.add(new Producto(nombre, precio, cantidad));
        }

        System.out.println("\nProductos ingresados:");
        for (Producto p : productos) {
            System.out.println(" - " + p);
        }

        CalculadoraDePrecios calculadora = new CalculadoraDePrecios();

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENÚ DE ESTRATEGIAS DE DESCUENTO ===");
            System.out.println("1. Sin descuento");
            System.out.println("2. Descuento fijo (10%)");
            System.out.println("3. Descuento porcentual (2 productos iguales 30%)");
            System.out.println("4. Descuento porcentual acumulado (>=3 productos, 50% al más barato)");
            System.out.println("5. Salir");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    calculadora.setEstrategia(new SinDescuento());
                    break;
                case 2:
                    calculadora.setEstrategia(new DescuentoFijo());
                    break;
                case 3:
                    calculadora.setEstrategia(new DescuentoPorcentual());
                    break;
                case 4:
                    calculadora.setEstrategia(new DescuentoPorcentualAcumulado());
                    break;
                case 5:
                    salir = true;
                    continue;
                default:
                    System.out.println("Opción no válida.");
                    continue;
            }

            double subtotal = calculadora.calcularSubtotal(productos);
            double total = calculadora.calcularTotal(productos);

            System.out.println("\nSubtotal sin descuento: " + subtotal);
            System.out.println("Total con estrategia seleccionada: " + total);
        }

        System.out.println("\nSaliendo del sistema...");
        scanner.close();
    }
}

