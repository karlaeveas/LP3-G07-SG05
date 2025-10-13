package ejercicio4;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class ContadorPalabras {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        int resultado = fileChooser.showOpenDialog(null);

        if (resultado != JFileChooser.APPROVE_OPTION) {
            System.out.println("No se seleccionó ningún archivo.");
            return;
        }

        File archivo = fileChooser.getSelectedFile();

        int totalLineas = 0;
        int totalPalabras = 0;
        int totalCaracteres = 0;
        Map<String, Integer> frecuencia = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                totalLineas++;
                totalCaracteres += linea.length();

                String[] palabras = linea.split("\\s+");
                for (String palabra : palabras) {
                    palabra = palabra.toLowerCase().replaceAll("[^a-z0-9áéíóúüñ]", "");
                    if (!palabra.isEmpty()) {
                        totalPalabras++;
                        frecuencia.put(palabra, frecuencia.getOrDefault(palabra, 0) + 1);
                    }
                }
            }

            double promedio = (totalLineas > 0) ? (double) totalPalabras / totalLineas : 0;

            System.out.println("\n Archivo: " + archivo.getName());
            System.out.println("Líneas totales: " + totalLineas);
            System.out.println("Palabras totales: " + totalPalabras);
            System.out.println("Caracteres totales: " + totalCaracteres);
            System.out.printf("Promedio de palabras por línea: %.2f%n", promedio);

            System.out.println("\n Palabras más frecuentes:");
            frecuencia.entrySet().stream()
                    .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                    .limit(5)
                    .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
