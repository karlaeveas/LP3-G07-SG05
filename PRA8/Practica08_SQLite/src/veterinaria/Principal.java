package veterinaria;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        MascotaCRUD crud = new MascotaCRUD();
        GestorMascotas gestor = new GestorMascotas();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ VETERINARIA ===");
            System.out.println("1. Registrar mascota");
            System.out.println("2. Mostrar mascotas");
            System.out.println("3. Actualizar mascota");
            System.out.println("4. Eliminar mascota");
            System.out.println("5. Consultar desde Gestor");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> crud.insertar();
                case 2 -> crud.mostrar();
                case 3 -> crud.actualizar();
                case 4 -> crud.eliminar();
                case 5 -> {
                    gestor.cargarDesdeBD();
                    System.out.print("¿Solo mayores de 5 años? (true/false): ");
                    boolean mayores = sc.nextBoolean();
                    System.out.print("¿Orden ascendente? (true/false): ");
                    boolean asc = sc.nextBoolean();
                    System.out.print("¿Límite (0 = todos): ");
                    int limite = sc.nextInt();
                    gestor.consultar(mayores, asc, limite);
                }
                case 0 -> System.out.println("¡Hasta luego!");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}


