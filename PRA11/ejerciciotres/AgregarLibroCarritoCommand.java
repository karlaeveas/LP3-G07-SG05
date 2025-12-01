package ejerciciotres;

import java.util.Scanner;

public class AgregarLibroCarritoCommand implements Command {

    private Libreria libreria;
    private Scanner scanner;

    public AgregarLibroCarritoCommand(Libreria libreria, Scanner scanner) {
        this.libreria = libreria;
        this.scanner = scanner;
    }

    @Override
    public void ejecutar() {
        libreria.mostrarCatalogo();
        System.out.print("\nIngrese el ID del libro a agregar: ");
        int id = scanner.nextInt();
        System.out.print("Ingrese la cantidad: ");
        int cantidad = scanner.nextInt();

        Libro libro = libreria.buscarLibroPorId(id);
        libreria.agregarLibroAlCarrito(libro, cantidad);
    }
}
