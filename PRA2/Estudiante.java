package universidad;

public class Estudiante extends Persona {
    private String codigo;
    private static int totalEstudiantes = 0;

    public Estudiante(String nombre, String dni, String codigo) {
        super(nombre, dni);
        this.codigo = codigo;
        totalEstudiantes++;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Estudiante: " + nombre + " | Código: " + codigo);
    }

    // Métodos de instancia
    public String getCodigo() { return codigo; }

    // Método de clase
    public static int getTotalEstudiantes() {
        return totalEstudiantes;
    }
}
