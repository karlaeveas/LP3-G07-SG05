package programasiete;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;

public class TestFilePrueba {
    public static void main(String[] args) {
        FileInputStream file;
        byte[] b = new byte[1024];

        try {
            file = new FileInputStream("src/archivos/TestFile.java");
            file.read(b);

            String s = new String(b);

            ViewFile view = new ViewFile(s);
            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            view.setSize(400, 150);
            view.setVisible(true);

            file.close();
        } catch (FileNotFoundException e) {
            System.out.println("❌ Archivo no encontrado: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("❌ Error de lectura: " + e.getMessage());
        }
    }
}
