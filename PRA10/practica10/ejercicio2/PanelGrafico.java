package ejercicio2;

import javax.swing.*;
import java.awt.*;

public class PanelGrafico extends JPanel {

	private static final long serialVersionUID = 1L;
	private double[] temperaturas;

    public PanelGrafico() {
        temperaturas = new double[]{0, 0, 0, 0, 0, 0, 0};
        setBackground(Color.WHITE);
    }

    public void setTemperaturas(double[] temps) {
        this.temperaturas = temps;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (temperaturas == null) return;

        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2)); // grosor de línea

        int ancho = getWidth();
        int alto = getHeight();

        int margen = 50;
        int espacioX = (ancho - 2 * margen) / 6;

        // Encontrar máximos para escalar
        double maxTemp = temperaturas[0];
        for (double t : temperaturas) {
            if (t > maxTemp) maxTemp = t;
        }
        if (maxTemp == 0) maxTemp = 1;

        // Dibujar puntos y líneas
        int[] x = new int[7];
        int[] y = new int[7];

        for (int i = 0; i < 7; i++) {
            x[i] = margen + i * espacioX;
            y[i] = alto - margen - (int) ((temperaturas[i] / maxTemp) * (alto - 2 * margen));
        }

        // Dibujar líneas
        g2.setColor(Color.BLUE);
        for (int i = 0; i < 6; i++) {
            g2.drawLine(x[i], y[i], x[i + 1], y[i + 1]);
        }

        // Dibujar puntos
        g2.setColor(Color.RED);
        for (int i = 0; i < 7; i++) {
            g2.fillOval(x[i] - 5, y[i] - 5, 10, 10);
        }

        // Etiquetas de los días
        g2.setColor(Color.BLACK);
        String[] dias = {"L", "M", "M", "J", "V", "S", "D"};
        for (int i = 0; i < 7; i++) {
            g2.drawString(dias[i], x[i] - 5, alto - 20);
        }
    }
}
