package universidad;

public class Profesor extends Persona {
    private String especialidad;
    private static int totalProfesores = 0;

    public Profesor(String nombre, String dni, String especialidad) {
        super(nombre, dni);
        this.especialidad = especialidad;
        totalProfesores++;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Profesor: " + nombre + " | Especialidad: " + especialidad);
    }

    public String getEspecialidad() { return especialidad; }

    public static int getTotalProfesores() {
        return totalProfesores;
    }
}
