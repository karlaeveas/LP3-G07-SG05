package gui.espinoramos;


import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class MarcoListaMultiple_EspinoRamos extends JFrame {
	private static final long serialVersionUID = 1L;
    private JList<String> listaColores;
    private JList<String> listaCopiar;
    private JButton botonCopiar;

    // Colores y nombres
    private final String nombres[] = {
        "Negro", "Azul", "Cian", "Gris oscuro", "Gris",
        "Verde", "Gris claro", "Magenta", "Naranja",
        "Rosa", "Rojo", "Blanco", "Amarillo"
    };

    private final Color colores[] = {
        Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
        Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE,
        Color.PINK, Color.RED, Color.WHITE, Color.YELLOW
    };

    public MarcoListaMultiple_EspinoRamos() {

        super("Lista Múltiple - Espino/Ramos");
        setLayout(new FlowLayout());

        // Lista principal
        listaColores = new JList<>(nombres);
        listaColores.setVisibleRowCount(5);
        listaColores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        add(new JScrollPane(listaColores));

        // Cambiar color cuando el usuario selecciona
        listaColores.addListSelectionListener(
            new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    int index = listaColores.getSelectedIndex();
                    if (index >= 0) {
                        getContentPane().setBackground(colores[index]);
                    }
                }
            }
        );

        // Botón de copiar
        botonCopiar = new JButton("Copiar >>>");
        add(botonCopiar);

        // Lista destino
        listaCopiar = new JList<>();
        listaCopiar.setVisibleRowCount(5);
        add(new JScrollPane(listaCopiar));

        // Acción del botón
        botonCopiar.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    listaCopiar.setListData(
                        listaColores.getSelectedValuesList().toArray(new String[0])
                    );
                }
            }
        );
    }
}
