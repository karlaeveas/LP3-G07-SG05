package programasiete;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class ViewFile extends JFrame {
    private JTextArea areaTexto;

    public ViewFile(String s) {
        super("Mostrando el contenido de un archivo");

        // Crear área de texto y mostrar el contenido del archivo
        areaTexto = new JTextArea(s, 10, 40);
        areaTexto.setEditable(false);

        // Añadir scroll por si el texto es largo
        JScrollPane scroll = new JScrollPane(areaTexto);

        // Agregar el área de texto a la ventana
        add(scroll);
    }
}
