package experienciacuatro;

import javax.swing.*;
import java.awt.*;

public class AppGraficoBarras extends JPanel {

    // Datos de ejemplo
    private String[] productos = {"Producto A", "Producto B", "Producto C", "Producto D"};
    private int[] ventas = {50, 120, 80, 150}; // Ventas en unidades

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Configuración de Graphics2D y antialiasing
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Configuración de las dimensiones y colores del gráfico
        int anchoBarra = 50;
        int espacioBarra = 20;
        int margenIzquierdo = 50;
        int margenInferior = 50;
        int alturaMaxima = 200;

        // Encontrar el valor máximo de ventas para escalar las barras
        int maxVenta = 0;
        for (int venta : ventas) {
            if (venta > maxVenta) {
                maxVenta = venta;
            }
        }

        // Dibujar las barras
        for (int i = 0; i < productos.length; i++) {
            int alturaBarra = (int) ((double) ventas[i] / maxVenta * alturaMaxima);
            int x = margenIzquierdo + i * (anchoBarra + espacioBarra);
            int y = getHeight() - margenInferior - alturaBarra;

            // Dibujar la barra
            g2d.setColor(new Color(100, 150, 200));
            g2d.fillRect(x, y, anchoBarra, alturaBarra);

            // Dibujar la etiqueta de ventas encima de cada barra
            g2d.setColor(Color.BLACK);
            g2d.drawString(String.valueOf(ventas[i]), x + (anchoBarra / 4), y - 5);

            // Dibujar el nombre del producto debajo de cada barra
            g2d.drawString(productos[i], x, getHeight() - margenInferior + 20);
        }

        // Dibujar el eje y y su título
        g2d.drawLine(margenIzquierdo, getHeight() - margenInferior,
                     margenIzquierdo, getHeight() - margenInferior - alturaMaxima);
        g2d.drawString("Ventas", margenIzquierdo - 40, getHeight() - margenInferior - alturaMaxima);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Visualización de Datos - Gráfico de Barras Espino/Ramos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Agregar el panel de gráficos al frame
        AppGraficoBarras grafico = new AppGraficoBarras();
        frame.add(grafico);

        frame.setVisible(true);
    }
}

