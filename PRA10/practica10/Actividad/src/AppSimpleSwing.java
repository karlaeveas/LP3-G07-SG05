/*
 * Ejemplo SIMPLE en Java Swing que incluye:
 *   ✔ Binding manual de datos
 *   ✔ Gráfico sencillo sin librerías externas (pintado a mano en JPanel)
 *   ✔ Reproducción de audio con javax.sound.sampled
 *
 *  NOTA: Se eliminó el uso de JavaFX y JFreeChart para hacerlo lo más simple posible.
 *
 *  Estructura:
 *     - Modelo simple (Producto)
 *     - Panel de formulario con binding manual
 *     - Panel gráfico que dibuja barras según el valor/cantidad
 *     - Botones para reproducir sonido WAV
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.sound.sampled.*;
import java.io.File;

public class AppSimpleSwing extends JFrame {

    // Modelo simple
    public static class Producto {
        String nombre = "Producto A";
        double valor = 50;
        int cantidad = 10;
    }

    private Producto model = new Producto();

    // Componentes UI
    private JTextField tfNombre = new JTextField(12);
    private JSpinner spValor = new JSpinner(new SpinnerNumberModel(50.0, 0, 9999, 1));
    private JSpinner spCantidad = new JSpinner(new SpinnerNumberModel(10, 0, 9999, 1));
    private JButton btnCargar = new JButton("Cargar del modelo");
    private JButton btnGuardar = new JButton("Guardar al modelo");

    // Gráfico simple
    private GraficoPanel grafico = new GraficoPanel();

    // Audio
    private JButton btnPlay = new JButton("Reproducir audio");
    private JButton btnStop = new JButton("Detener audio");
    private Clip clip;

    public AppSimpleSwing() {
        super("Ejemplo SIMPLE: Binding + Gráfico + Audio (Swing)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10,10));

        // Panel superior: formulario
        JPanel form = new JPanel();
        form.setBorder(BorderFactory.createTitledBorder("Binding Manual"));
        form.add(new JLabel("Nombre:")); form.add(tfNombre);
        form.add(new JLabel("Valor:")); form.add(spValor);
        form.add(new JLabel("Cantidad:")); form.add(spCantidad);
        form.add(btnCargar);
        form.add(btnGuardar);

        btnCargar.addActionListener(e-> cargarModelo());
        btnGuardar.addActionListener(e-> guardarModelo());

        add(form, BorderLayout.NORTH);

        // Panel centro: gráfico
        grafico.setPreferredSize(new Dimension(400,300));
        grafico.setBorder(BorderFactory.createTitledBorder("Gráfico simple"));
        add(grafico, BorderLayout.CENTER);

        // Panel inferior: audio
        JPanel audioPanel = new JPanel();
        audioPanel.setBorder(BorderFactory.createTitledBorder("Audio"));
        audioPanel.add(btnPlay);
        audioPanel.add(btnStop);

        btnPlay.addActionListener(e-> reproducir());
        btnStop.addActionListener(e-> detener());

        add(audioPanel, BorderLayout.SOUTH);

        cargarModelo(); // carga inicial

        pack();
        setLocationRelativeTo(null);
    }

    // --- Binding manual ---
    private void cargarModelo() {
        tfNombre.setText(model.nombre);
        spValor.setValue(model.valor);
        spCantidad.setValue(model.cantidad);
        grafico.repaint();
    }

    private void guardarModelo() {
        model.nombre = tfNombre.getText();
        model.valor = ((Number)spValor.getValue()).doubleValue();
        model.cantidad = (Integer)spCantidad.getValue();
        grafico.repaint();
        JOptionPane.showMessageDialog(this, "Modelo actualizado");
    }

    // --- Panel gráfico simple (dibuja 2 barras) ---
    private class GraficoPanel extends JPanel {
   
		private static final long serialVersionUID = 1L;

		@Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            int w = getWidth();
            int h = getHeight();

            // Escala simple
            double max = Math.max(model.valor, model.cantidad);
            double factor = (h - 50) / max;

            // Barra valor
            int bar1 = (int)(model.valor * factor);
            int bar2 = (int)(model.cantidad * factor);

            g2.setColor(Color.BLUE);
            g2.fillRect(80, h - bar1 - 30, 60, bar1);
            g2.drawString("Valor", 90, h - 10);

            g2.setColor(Color.RED);
            g2.fillRect(200, h - bar2 - 30, 60, bar2);
            g2.drawString("Cantidad", 200, h - 10);
        }
    }

    // --- Audio ---
    private void reproducir() {
        try {
            if (clip == null) {
                File f = new File("media/sonido2.wav");
                AudioInputStream ais = AudioSystem.getAudioInputStream(f);
                clip = AudioSystem.getClip();
                clip.open(ais);
            }
            clip.setFramePosition(0);
            clip.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "No se pudo reproducir audio: " + e.getMessage());
        }
    }

    private void detener() {
        if (clip != null) clip.stop();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppSimpleSwing().setVisible(true));
    }
}
