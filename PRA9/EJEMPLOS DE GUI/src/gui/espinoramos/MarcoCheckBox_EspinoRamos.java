package gui.espinoramos;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class MarcoCheckBox_EspinoRamos extends JFrame {
	
	private static final long serialVersionUID = 1L;
    private JTextField campoTexto;
    private JCheckBox negrita;
    private JCheckBox cursiva;

    public MarcoCheckBox_EspinoRamos() {

        super("JCheckBox - Espino/Ramos");
        setLayout(new FlowLayout());

        campoTexto = new JTextField(" Observe cómo cambia el estilo de letra", 20);
        campoTexto.setFont(new Font("Serif", Font.PLAIN, 14));
        add(campoTexto);

        negrita = new JCheckBox("Negrita");
        cursiva = new JCheckBox("Cursiva");
        add(negrita);
        add(cursiva);

        ManejadorCheckBox manejador = new ManejadorCheckBox();
        negrita.addItemListener(manejador);
        cursiva.addItemListener(manejador);
    }

    private class ManejadorCheckBox implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent evento) {

            Font tipo;

            if (negrita.isSelected() && cursiva.isSelected())
                tipo = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
            else if (negrita.isSelected())
                tipo = new Font("Serif", Font.BOLD, 14);
            else if (cursiva.isSelected())
                tipo = new Font("Serif", Font.ITALIC, 14);
            else
                tipo = new Font("Serif", Font.PLAIN, 14);

            campoTexto.setFont(tipo);
        }
    }
}
