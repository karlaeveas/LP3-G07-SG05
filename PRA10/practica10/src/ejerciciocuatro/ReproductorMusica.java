package ejerciciocuatro;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class ReproductorMusica extends JFrame {

    private Clip clip;
    private long pausaPosicion = 0; // Guarda la posición donde se pausó

    public ReproductorMusica() {
        setTitle("Reproductor de Música");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new java.awt.FlowLayout());

        // Botones
        JButton btnPlay = new JButton("Reproducir");
        JButton btnPause = new JButton("Pausar");
        JButton btnResume = new JButton("Reanudar");

        // Eventos
        btnPlay.addActionListener(e -> reproducir());
        btnPause.addActionListener(e -> pausar());
        btnResume.addActionListener(e -> reanudar());

        add(btnPlay);
        add(btnPause);
        add(btnResume);

        setVisible(true);
    }

    // Reproducir desde cero
    private void reproducir() {
        try {
            File archivo = new File("C:\\Users\\HP\\Desktop\\Programas Java\\practica10\\sounds\\musica.wav");

            System.out.println("Intentando reproducir: " + archivo.getAbsolutePath());
            System.out.println("¿Existe el archivo? " + archivo.exists());

            AudioInputStream audio = AudioSystem.getAudioInputStream(archivo);

            clip = AudioSystem.getClip();
            clip.open(audio);

            pausaPosicion = 0;     // Reiniciar la posición
            clip.setMicrosecondPosition(0);
            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar audio.");
        }
    }

    // Pausar guardando posición
    private void pausar() {
        if (clip != null && clip.isRunning()) {
            pausaPosicion = clip.getMicrosecondPosition(); // Guardamos la posición actual
            clip.stop();
            System.out.println("Pausado en: " + pausaPosicion + " microsegundos");
        }
    }

    // Reanudar desde donde se pausó
    private void reanudar() {
        if (clip != null && !clip.isRunning()) {
            clip.setMicrosecondPosition(pausaPosicion);
            clip.start();
            System.out.println("Reanudado en: " + pausaPosicion + " microsegundos");
        }
    }

    public static void main(String[] args) {
        new ReproductorMusica();
    }
}
