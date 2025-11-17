package gui.espinoramos;

import java.awt.FlowLayout;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class MarcoListaSimple_EspinoRamos extends JFrame {
	private static final long serialVersionUID = 1L;
    private JList<String> listaColores;
    private final String nombresColores[] = { "Negro", "Azul", "Cian", "Gris oscuro", "Gris",
                                              "Verde", "Gris claro", "Magenta", "Naranja", 
                                              "Rosa", "Rojo", "Blanco", "Amarillo" };

    private final java.awt.Color colores[] = { java.awt.Color.BLACK, java.awt.Color.BLUE,
        java.awt.Color.CYAN, java.awt.Color.DARK_GRAY, java.awt.Color.GRAY,
        java.awt.Color.GREEN, java.awt.Color.LIGHT_GRAY, java.awt.Color.MAGENTA,
        java.awt.Color.ORANGE, java.awt.Color.PINK, java.awt.Color.RED,
        java.awt.Color.WHITE, java.awt.Color.YELLOW };

    private JLabel etiqueta;

    public MarcoListaSimple_EspinoRamos() {

        super("JList Simple - Espino/Ramos");
        setLayout(new FlowLayout());

        listaColores = new JList<>(nombresColores);
        listaColores.setVisibleRowCount(5);
        add(new JScrollPane(listaColores));

        etiqueta = new JLabel("Seleccione un color");
        add(etiqueta);

        listaColores.addListSelectionListener(
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent evento) {
                    getContentPane().setBackground(
                        colores[listaColores.getSelectedIndex()]
                    );
                }
            }
        );
    }
}
