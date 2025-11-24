package Manejosdesonido;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javax.swing.*;
import java.io.File;

public class VideoExample {

    public static void main(String[] args) {

        new JFXPanel();

        JFrame frame = new JFrame("Reproducción de Video");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JFXPanel jfxPanel = new JFXPanel();
        frame.add(jfxPanel);

        frame.setVisible(true);

        Platform.runLater(() -> {
           
            String videoPath = new File("video2.mp4").toURI().toString();

            Media media = new Media(videoPath);
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            MediaView mediaView = new MediaView(mediaPlayer);

            javafx.scene.Group root = new javafx.scene.Group(mediaView);
            Scene scene = new Scene(root);

            jfxPanel.setScene(scene);

            mediaPlayer.play();
        });
    }
}
