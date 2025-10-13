import java.io.*;
import java.util.*;

public class Gestor {
    private String archivo;
    private Map<String, Personaje> personajes;

    public Gestor(String archivo) {
        this.archivo = archivo;
        this.personajes = new HashMap<>();
        cargarArchivo();
    }

    private void cargarArchivo() {
        File file = new File(archivo);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 5) {
                    String nombre = datos[0];
                    int vida = Integer.parseInt(datos[1]);
                    int ataque = Integer.parseInt(datos[2]);
                    int defensa = Integer.parseInt(datos[3]);
                    int alcance = Integer.parseInt(datos[4]);
                    personajes.put(nombre, new Personaje(nombre, vida, ataque, defensa, alcance));
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    private void guardarArchivo() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Personaje p : personajes.values()) {
                bw.write(p.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }

    public void agregarPersonaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        if (personajes.containsKey(nombre)) {
            System.out.println("El personaje '" + nombre + "' ya existe.");
            return;
        }
        personajes.put(nombre, new Personaje(nombre, vida, ataque, defensa, alcance));
        guardarArchivo();
        System.out.println("Personaje '" + nombre + "' agregado correctamente.");
    }

    public void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }
        System.out.printf("%-12s %-6s %-7s %-8s %-8s%n", "Nombre", "Vida", "Ataque", "Defensa", "Alcance");
        System.out.println("----------------------------------------------------");
        for (Personaje p : personajes.values()) {
            System.out.printf("%-12s %-6d %-7d %-8d %-8d%n",
                    p.getNombre(), p.getVida(), p.getAtaque(), p.getDefensa(), p.getAlcance());
        }
    }

    public void eliminarPersonaje(String nombre) {
        if (personajes.remove(nombre) != null) {
            guardarArchivo();
            System.out.println(" Personaje '" + nombre + "' eliminado.");
        } else {
            System.out.println(" El personaje '" + nombre + "' no existe.");
        }
    }

    public void modificarPersonaje(String nombre, Integer vida, Integer ataque, Integer defensa, Integer alcance) {
        Personaje p = personajes.get(nombre);
        if (p == null) {
            System.out.println(" El personaje '" + nombre + "' no existe.");
            return;
        }
        if (vida != null && vida > 0) p.setVida(vida);
        if (ataque != null && ataque > 0) p.setAtaque(ataque);
        if (defensa != null && defensa > 0) p.setDefensa(defensa);
        if (alcance != null && alcance > 0) p.setAlcance(alcance);
        guardarArchivo();
        System.out.println(" Personaje '" + nombre + "' modificado.");
    }
}
