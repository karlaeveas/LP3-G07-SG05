import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class LeerMatrizBinaria {

    public static void main(String[] args) {
        DataInputStream entrada = null;

        try {
            // Abrir el archivo binario
            entrada = new DataInputStream(new FileInputStream("ficheros/matriz.dat"));

            // Leer filas y columnas
            int filas = entrada.readInt();
            int columnas = entrada.readInt();

            double[][] matriz = new double[filas][columnas];

            // Leer los datos de la matriz
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    matriz[i][j] = entrada.readDouble();
                }
            }

            // Mostrar la matriz
            System.out.println("Matriz leída desde el archivo:");
            for (int i = 0; i < filas; i++) {
                for (int j = 0; j < columnas; j++) {
                    System.out.print(matriz[i][j] + "\t");
                }
                System.out.println();
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } finally {
            try {
                if (entrada != null) entrada.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }
    }
}
