package modelo;

import java.io.Serializable;

public class Empleado implements Serializable {
    private int numero;
    private String nombre;
    private double sueldo;

    public Empleado(int numero, String nombre, double sueldo) {
        this.numero = numero;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    public int getNumero() { return numero; }
    public String getNombre() { return nombre; }
    public double getSueldo() { return sueldo; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setSueldo(double sueldo) { this.sueldo = sueldo; }

    @Override
    public String toString() {
        return numero + " - " + nombre + " - S/ " + sueldo;
    }
}

