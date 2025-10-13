package visorarchivos;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public class DemoJFileChooser extends JFrame {
	private static final long serialVersionUID = 1L;
	private final JTextArea areaSalida;

    public DemoJFileChooser() throws IOException {
        super("Demo de JFileChooser");

        // Área de texto con barra de desplazamiento
        areaSalida = new JTextArea();
        areaSalida.setEditable(false);
        add(new JScrollPane(areaSalida), BorderLayout.CENTER);

        // Analiza la ruta seleccionada
        analizarRuta();
    }

    public void analizarRuta() throws IOException {
        // Crea un objeto Path con la ruta del archivo o directorio seleccionado
        Path ruta = obtenerRutaArchivoODirectorio();

        if (ruta != null && Files.exists(ruta)) {
            StringBuilder builder = new StringBuilder();

            builder.append(String.format("Nombre: %s%n", ruta.getFileName()));
            builder.append(String.format("Es un directorio?: %s%n", Files.isDirectory(ruta) ? "Sí" : "No"));
            builder.append(String.format("Es un archivo?: %s%n", Files.isRegularFile(ruta) ? "Sí" : "No"));
            builder.append(String.format("Tamaño: %d bytes%n", Files.size(ruta)));
            builder.append(String.format("Última modificación: %s%n", Files.getLastModifiedTime(ruta)));
            builder.append(String.format("Ruta absoluta: %s%n", ruta.toAbsolutePath()));
            builder.append(String.format("Ruta raíz: %s%n", ruta.getRoot()));

            // Si es un directorio, lista su contenido
            if (Files.isDirectory(ruta)) {
                builder.append(String.format("%nContenido del directorio:%n"));
                try (Stream<Path> flujo = Files.list(ruta)) {
                    flujo.forEach(p -> builder.append(String.format("  %s%n", p)));
                }
            }

            // Muestra la información en el área de texto
            areaSalida.setText(builder.toString());
        } else {
            JOptionPane.showMessageDialog(this,
                    ruta != null ? ruta.getFileName() + " no existe." : "No se seleccionó ninguna ruta.",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Path obtenerRutaArchivoODirectorio() {
        JFileChooser selectorArchivos = new JFileChooser();
        selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        int resultado = selectorArchivos.showOpenDialog(this);

        if (resultado == JFileChooser.CANCEL_OPTION) {
            System.exit(0);
        }

        // Devuelve la ruta del archivo o directorio seleccionado
        return selectorArchivos.getSelectedFile().toPath();
    }

    // Clase principal que ejecuta la aplicación
    public static class PruebaFileChooser {
        public static void main(String[] args) throws IOException {
            DemoJFileChooser aplicacion = new DemoJFileChooser();
            aplicacion.setSize(500, 400);
            aplicacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            aplicacion.setVisible(true);
        }
    }
}
