package agenda;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Agenda {
    private ArrayPersona lista;
    private FileInputStream agendaFile;
    private final int longitudLinea = 64;

    public Agenda() {
        this.lista = cargaContactos();
    }

    // Método para cargar una persona desde el archivo
    private Persona cargaAgenda() throws IOException {
        String nombre = leerEntrada(agendaFile);
        if (nombre == null || nombre.isEmpty()) return null;
        String telefono = leerEntrada(agendaFile);
        String direccion = leerEntrada(agendaFile);
        return new Persona(nombre, telefono, direccion);
    }

    // Método para cargar todos los contactos
    private ArrayPersona cargaContactos() {
        ArrayPersona directorio = new ArrayPersona();
        Persona nuevaPersona;
        try {
            agendaFile = new FileInputStream("src/agenda/agenda.txt");
            while ((nuevaPersona = cargaAgenda()) != null) {
                directorio.addArray(nuevaPersona);
            }
            agendaFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("No hay archivo de agenda.txt");
        } catch (Exception e) {
            System.out.println("Error en la carga de los contactos");
        }
        return directorio;
    }

    // Método para leer una línea de texto desde un InputStream
    private String leerEntrada(InputStream entrada) throws IOException {
        byte[] chars = new byte[longitudLinea];
        int contador = 0;
        int c;
        while (contador < longitudLinea && (c = entrada.read()) != -1 && c != '\n') {
            chars[contador++] = (byte) c;
        }
        if (contador == 0 && contador == -1) return null;
        return new String(chars, 0, contador).trim();
    }

    // Bucle de búsqueda
    public void bucle() {
        try {
            String nombre;
            System.out.println("Introduzca un nombre o <Enter> para salir:");
            nombre = leerEntrada(System.in);

            while (!nombre.equals("")) {
                lista.imprimirArray(nombre);
                System.out.println("Introduzca un nombre o <Enter> para salir:");
                nombre = leerEntrada(System.in);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

