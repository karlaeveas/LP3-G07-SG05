package gui.espinoramos;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class MarcoRadioButton_EspinoRamos extends JFrame {
	private static final long serialVersionUID = 1L;
    private JTextField campoTexto;
    private JRadioButton simple, negrita, cursiva, negritaCursiva;
    private Font fSimple, fNegrita, fCursiva, fNegritaCursiva;

    public MarcoRadioButton_EspinoRamos() {

        super("RadioButton - Espino/Ramos");
        setLayout(new FlowLayout());

        campoTexto = new JTextField(" Observe el cambio de estilo", 25);
        add(campoTexto);

        simple = new JRadioButton("Simple", true);
        negrita = new JRadioButton("Negrita", false);
        cursiva = new JRadioButton("Cursiva", false);
        negritaCursiva = new JRadioButton("Negrita/Cursiva", false);

        add(simple);
        add(negrita);
        add(cursiva);
        add(negritaCursiva);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(simple);
        grupo.add(negrita);
        grupo.add(cursiva);
        grupo.add(negritaCursiva);

        fSimple = new Font("Serif", Font.PLAIN, 14);
        fNegrita = new Font("Serif", Font.BOLD, 14);
        fCursiva = new Font("Serif", Font.ITALIC, 14);
        fNegritaCursiva = new Font("Serif", Font.BOLD + Font.ITALIC, 14);

        simple.addItemListener(new Manejador(fSimple));
        negrita.addItemListener(new Manejador(fNegrita));
        cursiva.addItemListener(new Manejador(fCursiva));
        negritaCursiva.addItemListener(new Manejador(fNegritaCursiva));

        campoTexto.setFont(fSimple);
    }

    private class Manejador implements ItemListener {
        private Font tipo;

        public Manejador(Font f) { this.tipo = f; }

        @Override
        public void itemStateChanged(ItemEvent e) {
            campoTexto.setFont(tipo);
        }
    }
}
