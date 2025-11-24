package Manejosdesonido;
import javax.sound.sampled.*;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        try {
            
            File audioFile = new File("C:\\Users\\Wander\\Music\\sonido2.wav");
      
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);          
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream); 
            clip.start();

            Thread.sleep(clip.getMicrosecondLength() / 1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
