package gui.espinoramos;

import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class MarcoComboBox_EspinoRamos extends JFrame {
	private static final long serialVersionUID = 1L;
    private JComboBox<String> cuadro;
    private JLabel etiqueta;
    private String nombres[] = { "insecto1.gif", "insecto2.gif", "insecto3.gif", "insecto4.gif" };
    private Icon iconos[] = {
        new ImageIcon(getClass().getResource("insecto1.gif")),
        new ImageIcon(getClass().getResource("insecto2.gif")),
        new ImageIcon(getClass().getResource("insecto3.gif")),
        new ImageIcon(getClass().getResource("insecto4.gif"))
    };

    public MarcoComboBox_EspinoRamos() {

        super("JComboBox - Espino/Ramos");
        setLayout(new FlowLayout());

        cuadro = new JComboBox<>(nombres);
        cuadro.setMaximumRowCount(3);
        add(cuadro);

        etiqueta = new JLabel(iconos[0]);
        add(etiqueta);

        cuadro.addItemListener(
            new ItemListener() {
                @Override
                public void itemStateChanged(ItemEvent evento) {
                    if (evento.getStateChange() == ItemEvent.SELECTED) {
                        etiqueta.setIcon(iconos[cuadro.getSelectedIndex()]);
                    }
                }
            }
        );
    }
}
