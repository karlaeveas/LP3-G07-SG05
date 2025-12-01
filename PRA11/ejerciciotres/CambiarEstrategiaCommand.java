package ejerciciotres;

import java.util.Scanner;

public class CambiarEstrategiaCommand implements Command {

    private Libreria libreria;
    private Scanner scanner;

    public CambiarEstrategiaCommand(Libreria libreria, Scanner scanner) {
        this.libreria = libreria;
        this.scanner = scanner;
    }

    @Override
    public void ejecutar() {
        System.out.println("\n=== ESTRATEGIAS DE DESCUENTO ===");
        System.out.println("1. Sin descuento");
        System.out.println("2. Descuento fijo (10%)");
        System.out.println("3. Descuento porcentual (2 unidades iguales 30%)");
        System.out.println("4. Descuento porcentual acumulado (>=3 unidades, 50% al libro más barato)");
        System.out.print("Seleccione opción: ");
        int op = scanner.nextInt();

        switch (op) {
            case 1:
                libreria.setEstrategia(new SinDescuento());
                System.out.println("Estrategia seleccionada: Sin descuento.");
                break;
            case 2:
                libreria.setEstrategia(new DescuentoFijo());
                System.out.println("Estrategia seleccionada: Descuento fijo 10%.");
                break;
            case 3:
                libreria.setEstrategia(new DescuentoPorcentual());
                System.out.println("Estrategia seleccionada: Descuento porcentual (2 iguales 30%).");
                break;
            case 4:
                libreria.setEstrategia(new DescuentoPorcentualAcumulado());
                System.out.println("Estrategia seleccionada: Descuento porcentual acumulado.");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}

