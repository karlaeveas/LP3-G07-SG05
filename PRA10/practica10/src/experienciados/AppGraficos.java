package experienciados;

import javax.swing.*;
import java.awt.*;

public class AppGraficos extends JPanel {

    // Sobrescribe el método paintComponent para realizar dibujos
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Llama al método paintComponent de la superclase

        // Establece el color de dibujo
        g.setColor(Color.BLUE);

        // Dibuja una línea
        g.drawLine(10, 10, 100, 100);

        // Dibuja un rectángulo
        g.setColor(Color.RED);
        g.drawRect(50, 50, 100, 50);

        // Dibuja un óvalo
        g.setColor(Color.GREEN);
        g.drawOval(150, 50, 100, 50);

        // Dibuja un círculo lleno
        g.setColor(Color.ORANGE);
        g.fillOval(200, 150, 50, 50);

        // Dibuja un texto
        g.setColor(Color.BLACK);
        g.drawString("Ejemplo de Gráficos en Swing", 10, 200);
    }

    // Método principal para ejecutar el ejemplo
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de Gráficos Espino/Ramos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Crea una instancia de nuestro panel personalizado y la agrega al marco
        AppGraficos panel = new AppGraficos();
        frame.add(panel);

        frame.setVisible(true);
    }
}
