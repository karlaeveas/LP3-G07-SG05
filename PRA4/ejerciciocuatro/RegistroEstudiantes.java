package ejerciciocuatro;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class RegistroEstudiantes {
    private ArrayList<String> estudiantes;

    // Constructor
    public RegistroEstudiantes() {
        estudiantes = new ArrayList<>();
    }

    // Método para agregar estudiante con validación
    public void agregarEstudiante(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
        estudiantes.add(nombre);
    }

    // Método para buscar estudiante con validación
    public String buscarEstudiante(String nombre) {
        for (String est : estudiantes) {
            if (est.equalsIgnoreCase(nombre)) {
                return est;
            }
        }
        throw new NoSuchElementException("Estudiante no encontrado: " + nombre);
    }
}