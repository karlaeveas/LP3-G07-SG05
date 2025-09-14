package ejerciciocuatro;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        RegistroEstudiantes registro = new RegistroEstudiantes();

        try {
            // Agregar estudiantes válidos
            registro.agregarEstudiante("Xiomara Veas");
            registro.agregarEstudiante("Isabel Arias");

            // Buscar estudiante existente
            System.out.println("Encontrado: " + registro.buscarEstudiante("Xiomara Veas"));

            // Intentar agregar estudiante inválido
            registro.agregarEstudiante(""); // debe lanzar IllegalArgumentException

        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }

        try {
            // Buscar estudiante que no existe
            System.out.println("Encontrado: " + registro.buscarEstudiante("Carlos Gómez"));
        } catch (NoSuchElementException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}

