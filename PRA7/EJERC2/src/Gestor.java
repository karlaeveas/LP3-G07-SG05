import java.io.*;
import java.util.*;

public class Gestor {
    private String archivo;
    private Map<String, Personaje> personajes;

    public Gestor(String archivo) {
        this.archivo = archivo;
        this.personajes = new HashMap<>();
        cargarArchivo();
        cargarPersonajesAleatorios(); // Se agregan personajes iniciales
    }

    // ------------------- CARGA Y GUARDADO -------------------

    private void cargarArchivo() {
        File file = new File(archivo);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 5) {
                    String nombre = datos[0];
                    int vida = Integer.parseInt(datos[1]);
                    int ataque = Integer.parseInt(datos[2]);
                    int defensa = Integer.parseInt(datos[3]);
                    int alcance = Integer.parseInt(datos[4]);
                    int nivel = (datos.length == 6) ? Integer.parseInt(datos[5]) : 1;
                    Personaje p = new Personaje(nombre, vida, ataque, defensa, alcance);
                    for (int i = 1; i < nivel; i++) p.subirNivel();
                    personajes.put(nombre, p);
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

    // ------------------- CRUD -------------------

    public void agregarPersonaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        if (personajes.containsKey(nombre)) {
            System.out.println(" El personaje '" + nombre + "' ya existe.");
            return;
        }
        personajes.put(nombre, new Personaje(nombre, vida, ataque, defensa, alcance));
        guardarArchivo();
        System.out.println(" Personaje '" + nombre + "' agregado correctamente.");
    }

    public void mostrarPersonajes() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
            return;
        }
        System.out.printf("%-12s %-6s %-7s %-8s %-8s %-6s%n", "Nombre", "Vida", "Ataque", "Defensa", "Alcance", "Nivel");
        System.out.println("--------------------------------------------------------------");
        for (Personaje p : personajes.values()) {
            System.out.printf("%-12s %-6d %-7d %-8d %-8d %-6d%n",
                    p.getNombre(), p.getVida(), p.getAtaque(), p.getDefensa(), p.getAlcance(), p.getNivel());
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

    // Actualizar un atributo individual
    public void actualizarAtributo(String nombre, String atributo, int nuevoValor) {
        Personaje p = personajes.get(nombre);
        if (p == null) {
            System.out.println(" El personaje '" + nombre + "' no existe.");
            return;
        }
        switch (atributo.toLowerCase()) {
            case "vida" -> p.setVida(nuevoValor);
            case "ataque" -> p.setAtaque(nuevoValor);
            case "defensa" -> p.setDefensa(nuevoValor);
            case "alcance" -> p.setAlcance(nuevoValor);
            default -> System.out.println("Atributo no válido.");
        }
        guardarArchivo();
        System.out.println(" Atributo '" + atributo + "' actualizado para " + nombre + ".");
    }

    // ------------------- NUEVAS FUNCIONALIDADES -------------------

    // Filtrar personajes por atributo
    public void filtrarPor(String atributo) {
        List<Personaje> lista = new ArrayList<>(personajes.values());
        lista.sort((p1, p2) -> {
            return switch (atributo.toLowerCase()) {
                case "vida" -> Integer.compare(p2.getVida(), p1.getVida());
                case "ataque" -> Integer.compare(p2.getAtaque(), p1.getAtaque());
                case "defensa" -> Integer.compare(p2.getDefensa(), p1.getDefensa());
                case "alcance" -> Integer.compare(p2.getAlcance(), p1.getAlcance());
                default -> 0;
            };
        });
        System.out.println(" Personajes ordenados por " + atributo + ":");
        for (Personaje p : lista) {
            System.out.println(" - " + p.getNombre());
        }
    }

    // Cargar personajes predefinidos o aleatorios al iniciar
    private void cargarPersonajesAleatorios() {
        if (!personajes.isEmpty()) return;
        agregarPersonaje("Caballero", 4, 2, 4, 2);
        agregarPersonaje("Guerrero", 2, 4, 2, 4);
        agregarPersonaje("Arquero", 2, 4, 1, 8);
    }

    // Mostrar estadísticas generales
    public void mostrarEstadisticas() {
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes para calcular estadísticas.");
            return;
        }
        double vidaProm = personajes.values().stream().mapToInt(Personaje::getVida).average().orElse(0);
        double ataqueProm = personajes.values().stream().mapToInt(Personaje::getAtaque).average().orElse(0);
        double defensaProm = personajes.values().stream().mapToInt(Personaje::getDefensa).average().orElse(0);
        double alcanceProm = personajes.values().stream().mapToInt(Personaje::getAlcance).average().orElse(0);

        System.out.println(" ESTADÍSTICAS GENERALES:");
        System.out.println("Total de personajes: " + personajes.size());
        System.out.printf("Promedio Vida: %.2f, Ataque: %.2f, Defensa: %.2f, Alcance: %.2f%n",
                vidaProm, ataqueProm, defensaProm, alcanceProm);
    }

    // Importar desde otro archivo
    public void importarDesdeArchivo(String nombreArchivo) {
        File file = new File(nombreArchivo);
        if (!file.exists()) {
            System.out.println(" El archivo no existe.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length >= 5) {
                    String nombre = datos[0];
                    int vida = Integer.parseInt(datos[1]);
                    int ataque = Integer.parseInt(datos[2]);
                    int defensa = Integer.parseInt(datos[3]);
                    int alcance = Integer.parseInt(datos[4]);
                    agregarPersonaje(nombre, vida, ataque, defensa, alcance);
                }
            }
            System.out.println(" Importación completada.");
        } catch (IOException e) {
            System.out.println("Error al importar: " + e.getMessage());
        }
    }

    // Subir de nivel
    public void subirNivel(String nombre) {
        Personaje p = personajes.get(nombre);
        if (p != null) {
            p.subirNivel();
            guardarArchivo();
            System.out.println("⬆️ " + nombre + " ha subido al nivel " + p.getNivel());
        } else {
            System.out.println(" El personaje no existe.");
        }
    }
}
