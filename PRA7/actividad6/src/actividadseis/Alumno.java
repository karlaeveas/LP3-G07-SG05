package actividadseis;

import java.io.Serializable;

public class Alumno extends Persona implements Serializable {
    private String codigo;
    private Fecha fechaNacimiento; // relación de composición

    public Alumno(String nombre, int edad, String codigo, Fecha fechaNacimiento) {
        super(nombre, edad);
        this.codigo = codigo;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCodigo() { return codigo; }
    public Fecha getFechaNacimiento() { return fechaNacimiento; }

    @Override
    public String toString() {
        return super.toString() + ", Código: " + codigo + ", Fecha Nac: " + fechaNacimiento;
    }
}