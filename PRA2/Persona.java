package universidad;

public abstract class Persona {
    // Atributos de instancia
    protected String nombre;
    protected String dni;

    // Atributo de clase (común a todas las personas)
    protected static int totalPersonas = 0;

    // Constructor
    public Persona(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        totalPersonas++;
    }

    // Métodos abstractos (herencia y polimorfismo)
    public abstract void mostrarInfo();

    // Métodos de instancia
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    // Método de clase
    public static int getTotalPersonas() {
        return totalPersonas;
    }
}
