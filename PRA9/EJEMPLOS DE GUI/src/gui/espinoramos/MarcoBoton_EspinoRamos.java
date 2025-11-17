package gui.espinoramos;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MarcoBoton_EspinoRamos extends JFrame {

	private static final long serialVersionUID = 1L;
	private final JButton botonJButtonSimple;
    private final JButton botonJButtonElegante;

    public MarcoBoton_EspinoRamos() {
        super("Botones - Espino/Ramos");
        setLayout(new FlowLayout());

        botonJButtonSimple = new JButton("Botón simple");
        add(botonJButtonSimple);

        Icon insecto1 = new ImageIcon(getClass().getResource("insecto1.gif"));
        Icon insecto2 = new ImageIcon(getClass().getResource("insecto2.gif"));

        botonJButtonElegante = new JButton("Botón elegante", insecto1);
        botonJButtonElegante.setRolloverIcon(insecto2);
        add(botonJButtonElegante);

        ManejadorBoton manejador = new ManejadorBoton();
        botonJButtonSimple.addActionListener(manejador);
        botonJButtonElegante.addActionListener(manejador);
    }

    private class ManejadorBoton implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evento) {
            JOptionPane.showMessageDialog(
                MarcoBoton_EspinoRamos.this,
                String.format("Usted presionó: %s", evento.getActionCommand())
            );
        }
    }
}
