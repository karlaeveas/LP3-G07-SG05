package ejerciciotres;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class ReproductorSonidos extends JFrame {

    public ReproductorSonidos() {
        setTitle("Reproductor de Sonidos");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new java.awt.FlowLayout());

        // BOTONES
        JButton btnGuitarra = new JButton("Guitarra");
        JButton btnTambor = new JButton("Tambor");
        JButton btnTimbo = new JButton("Timbo");

        // ACCIONES (RUTAS ABSOLUTAS - CAMBIA LOS NOMBRES SEGÚN TUS ARCHIVOS)
        btnGuitarra.addActionListener(e -> reproducirSonido("C:\\Users\\HP\\Desktop\\Programas Java\\practica10\\sounds\\guitarra.wav"));
        btnTambor.addActionListener(e -> reproducirSonido("C:\\Users\\HP\\Desktop\\Programas Java\\practica10\\sounds\\tambor.wav"));
        btnTimbo.addActionListener(e -> reproducirSonido("C:\\Users\\HP\\Desktop\\Programas Java\\practica10\\sounds\\timbo.wav"));

        // AGREGAR BOTONES A LA VENTANA
        add(btnGuitarra);
        add(btnTambor);
        add(btnTimbo);

        setVisible(true);
    }

    // MÉTODO PARA REPRODUCIR SONIDO (CON DEBUG)
    public void reproducirSonido(String ruta) {
        try {
            File archivo = new File(ruta);

            System.out.println("Intentando cargar: " + archivo.getAbsolutePath());
            System.out.println("¿Existe el archivo? " + archivo.exists());

            AudioInputStream audio = AudioSystem.getAudioInputStream(archivo);
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();

        } catch (UnsupportedAudioFileException e) {
            System.out.println("FORMATO NO SOPORTADO (Debe ser WAV PCM)");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("No se pudo leer el archivo");
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            System.out.println("El dispositivo de sonido no está disponible");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error desconocido");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ReproductorSonidos();
    }
}

