package controlador;

import java.io.*;
import java.util.*;
import modelo.Empleado;

public class EmpleadoController {
    private static final String ARCHIVO = "empleados.txt";

    public List<Empleado> leerEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        File file = new File(ARCHIVO);
        if (!file.exists()) return empleados;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";");
                int num = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                double sueldo = Double.parseDouble(partes[2]);
                empleados.add(new Empleado(num, nombre, sueldo));
            }
        } catch (IOException e) {
            System.out.println("Error al leer archivo: " + e.getMessage());
        }
        return empleados;
    }

    private void guardarEmpleados(List<Empleado> empleados) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO))) {
            for (Empleado e : empleados) {
                pw.println(e.getNumero() + ";" + e.getNombre() + ";" + e.getSueldo());
            }
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    public void agregarEmpleado(Empleado nuevo) {
        List<Empleado> empleados = leerEmpleados();
        boolean existe = empleados.stream().anyMatch(e -> e.getNumero() == nuevo.getNumero());
        if (existe) {
            System.out.println("Ya existe un empleado con ese número.");
        } else {
            empleados.add(nuevo);
            guardarEmpleados(empleados);
            System.out.println("Empleado agregado correctamente.");
        }
    }

    public Empleado buscarEmpleado(int numero) {
        return leerEmpleados().stream()
                .filter(e -> e.getNumero() == numero)
                .findFirst()
                .orElse(null);
    }

    public void eliminarEmpleado(int numero) {
        List<Empleado> empleados = leerEmpleados();
        boolean eliminado = empleados.removeIf(e -> e.getNumero() == numero);
        if (eliminado) {
            guardarEmpleados(empleados);
            System.out.println("Empleado eliminado correctamente.");
        } else {
            System.out.println("No se encontró ese empleado.");
        }
    }

    public void listarEmpleados() {
        List<Empleado> empleados = leerEmpleados();
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
        } else {
            System.out.println("Lista de empleados:");
            empleados.forEach(System.out::println);
        }
    }
}

