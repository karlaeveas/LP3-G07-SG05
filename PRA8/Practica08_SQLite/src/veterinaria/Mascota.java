package veterinaria;

public class Mascota {
    private int id;
    private String nombre;
    private String especie;
    private int edad;

    public Mascota(int id, String nombre, String especie, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.edad = edad;
    }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getEspecie() { return especie; }
    public int getEdad() { return edad; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEspecie(String especie) { this.especie = especie; }
    public void setEdad(int edad) { this.edad = edad; }

    @Override
    public String toString() {
        return id + " | " + nombre + " | " + especie + " | " + edad + " años";
    }
}

