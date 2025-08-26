package universidad;

public class SistemaGestion {
    public static void main(String[] args) {
        // Crear profesores
        Profesor prof1 = new Profesor("Carlos Pérez", "12345678", "Matemáticas");
        Profesor prof2 = new Profesor("Ana López", "87654321", "Programación");

        // Crear cursos
        Curso curso1 = new Curso("Álgebra Lineal", prof1);
        Curso curso2 = new Curso("Java Avanzado", prof2);

        // Crear estudiantes
        Estudiante est1 = new Estudiante("Luis Torres", "11111111", "E001");
        Estudiante est2 = new Estudiante("María Díaz", "22222222", "E002");

        // Inscribir estudiantes (agregación)
        curso1.inscribirEstudiante(est1);
        curso1.inscribirEstudiante(est2);

        curso2.inscribirEstudiante(est1);

        // Mostrar info
        curso1.mostrarCurso();
        curso2.mostrarCurso();

        // Polimorfismo (método mostrarInfo se comporta distinto según el tipo)
        Persona p1 = est1;
        Persona p2 = prof1;
        p1.mostrarInfo();
        p2.mostrarInfo();

        // Métodos de clase
        System.out.println("Total de personas: " + Persona.getTotalPersonas());
        System.out.println("Total de estudiantes: " + Estudiante.getTotalEstudiantes());
        System.out.println("Total de profesores: " + Profesor.getTotalProfesores());
    }
}
