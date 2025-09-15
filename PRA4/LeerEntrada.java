package ejerciciouno;

import java.util.Scanner;

public class LeerEntrada {
    private char caracter;
    private Scanner sc;

    public LeerEntrada() {
        sc = new Scanner(System.in);
    }

    public char getChar() {
        System.out.print("Ingrese un carácter: ");
        String entrada = sc.nextLine();
        if (entrada.isEmpty()) {
            caracter = '\n';
        } else {
            caracter = entrada.charAt(0);
        }
        return caracter;
    }

    public char getCaracterAlmacenado() {
        return caracter;
    }
}