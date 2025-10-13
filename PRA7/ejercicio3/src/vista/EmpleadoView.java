package vista;

import java.util.Scanner;
import controlador.EmpleadoController;
import modelo.Empleado;

public class EmpleadoView {
    private Scanner sc = new Scanner(System.in);
    private EmpleadoController controller = new EmpleadoController();

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n=== MENÚ DE EMPLEADOS ===");
            System.out.println("1. Listar todos");
            System.out.println("2. Agregar nuevo");
            System.out.println("3. Buscar por número");
            System.out.println("4. Eliminar por número");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> controller.listarEmpleados();
                case 2 -> agregarEmpleado();
                case 3 -> buscarEmpleado();
                case 4 -> eliminarEmpleado();
                case 5 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida");
            }
        } while (opcion != 5);
    }

    private void agregarEmpleado() {
        System.out.print("Número: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Sueldo: ");
        double sueldo = sc.nextDouble();

        controller.agregarEmpleado(new Empleado(numero, nombre, sueldo));
    }

    private void buscarEmpleado() {
        System.out.print("Número de empleado: ");
        int numero = sc.nextInt();
        Empleado e = controller.buscarEmpleado(numero);
        if (e != null)
            System.out.println("Encontrado: " + e);
        else
            System.out.println("No encontrado.");
    }

    private void eliminarEmpleado() {
        System.out.print("Número a eliminar: ");
        int numero = sc.nextInt();
        controller.eliminarEmpleado(numero);
    }
}

