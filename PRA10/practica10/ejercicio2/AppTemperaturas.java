package ejercicio2;

import javax.swing.*;
import java.awt.*;

public class AppTemperaturas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField[] campos;
    private String[] dias = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
    private PanelGrafico panelGrafico;

    public AppTemperaturas() {
        super("Gráfico de Temperaturas Semanales");

        setLayout(new BorderLayout());

        // Panel superior con los campos
        JPanel panelEntrada = new JPanel(new GridLayout(7, 2, 5, 5));
        campos = new JTextField[7];

        for (int i = 0; i < 7; i++) {
            panelEntrada.add(new JLabel(dias[i] + ":"));
            campos[i] = new JTextField();
            panelEntrada.add(campos[i]);
        }

        add(panelEntrada, BorderLayout.WEST);

        // Panel gráfico al lado derecho o al fondo
        panelGrafico = new PanelGrafico();
        add(panelGrafico, BorderLayout.CENTER);

        // Botón inferior
        JButton btnMostrar = new JButton("Mostrar Gráfico");
        add(btnMostrar, BorderLayout.SOUTH);

        btnMostrar.addActionListener(e -> actualizarGrafico());

        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void actualizarGrafico() {
        double[] temps = new double[7];

        try {
            for (int i = 0; i < 7; i++) {
                temps[i] = Double.parseDouble(campos[i].getText());
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                    "Error: Todas las temperaturas deben ser números.",
                    "Dato inválido", 
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        panelGrafico.setTemperaturas(temps);
        panelGrafico.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppTemperaturas());
    }
}
