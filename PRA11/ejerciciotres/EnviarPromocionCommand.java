package ejerciciotres;

import java.util.Scanner;

public class EnviarPromocionCommand implements Command {

    private Libreria libreria;
    private Scanner scanner;

    public EnviarPromocionCommand(Libreria libreria, Scanner scanner) {
        this.libreria = libreria;
        this.scanner = scanner;
    }

    @Override
    public void ejecutar() {
        scanner.nextLine(); // limpiar buffer
        System.out.print("Ingrese el mensaje de la promoción: ");
        String mensaje = scanner.nextLine();
        libreria.enviarPromocion(mensaje);
    }
}

