package universidad;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    // Constante
    public static final int MAX_ESTUDIANTES = 30;

    private String nombre;
    private Profesor profesor;           // Asociación (cada curso tiene un profesor)
    private List<Estudiante> estudiantes; // Composición (la lista pertenece al curso)

    public Curso(String nombre, Profesor profesor) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
    }

    // Método para agregar estudiante (agregación)
    public void inscribirEstudiante(Estudiante e) {
        if (estudiantes.size() < MAX_ESTUDIANTES) {
            estudiantes.add(e);
            System.out.println(e.getNombre() + " se inscribió en " + nombre);
        } else {
            System.out.println("Curso lleno, no se puede inscribir a " + e.getNombre());
        }
    }

    public void mostrarCurso() {
        System.out.println("Curso: " + nombre + " | Profesor: " + profesor.getNombre());
        System.out.println("Estudiantes inscritos:");
        for (Estudiante e : estudiantes) {
            System.out.println("- " + e.getNombre());
        }
    }
}
