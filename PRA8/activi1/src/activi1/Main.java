package activi1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ProductoCRUD crud = new ProductoCRUD();
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Insertar");
            System.out.println("2. Mostrar");
            System.out.println("3. Actualizar");
            System.out.println("4. Eliminar");
            System.out.println("0. Salir");
            System.out.print("Opcion: ");
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String n = sc.nextLine();
                    System.out.print("Precio: ");
                    double p = sc.nextDouble(); sc.nextLine();
                    crud.insertar(n,p);
                    confirmar(sc,crud);
                }
                case 2 -> crud.mostrar();
                case 3 -> {
                    System.out.print("ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre nuevo: ");
                    String n = sc.nextLine();
                    System.out.print("Precio nuevo: ");
                    double p = sc.nextDouble(); sc.nextLine();
                    crud.actualizar(id,n,p);
                    confirmar(sc,crud);
                }
                case 4 -> {
                    System.out.print("ID a eliminar: ");
                    int id = sc.nextInt(); sc.nextLine();
                    crud.eliminar(id);
                    confirmar(sc,crud);
                }
                case 0 -> System.out.println("Adiós!");
                default -> System.out.println("Opción inválida");
            }
        } while (op != 0);
        sc.close();
    }

    private static void confirmar(Scanner sc, ProductoCRUD crud) {
        System.out.print("Clave para confirmar (1234): ");
        if (crud.confirmar(sc.nextLine()))
            System.out.println("✔ Confirmado");
        else
            System.out.println("✖ Cancelado");
    }
}
