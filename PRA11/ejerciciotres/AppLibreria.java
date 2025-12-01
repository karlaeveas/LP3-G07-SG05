package ejerciciotres;

import java.util.Scanner;

public class AppLibreria {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Libreria libreria = new Libreria();

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENÚ LIBRERÍA ===");
            System.out.println("1. Mostrar catálogo de libros");
            System.out.println("2. Agregar libro al carrito");
            System.out.println("3. Cambiar estrategia de descuento");
            System.out.println("4. Ver carrito y registrar venta");
            System.out.println("5. Enviar promoción a clientes suscritos");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            Command comando = null;

            switch (opcion) {
                case 1:
                    comando = new MostrarCatalogoCommand(libreria);
                    break;
                case 2:
                    comando = new AgregarLibroCarritoCommand(libreria, scanner);
                    break;
                case 3:
                    comando = new CambiarEstrategiaCommand(libreria, scanner);
                    break;
                case 4:
                    // antes de registrar, mostrar carrito
                    libreria.mostrarCarrito();
                    comando = new RegistrarVentaCommand(libreria);
                    break;
                case 5:
                    comando = new EnviarPromocionCommand(libreria, scanner);
                    break;
                case 6:
                    salir = true;
                    continue;
                default:
                    System.out.println("Opción no válida.");
                    continue;
            }

            if (comando != null) {
                comando.ejecutar();
            }
        }

        System.out.println("Saliendo de la aplicación de la librería...");
        scanner.close();
    }
}
