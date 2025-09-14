package ejerciciotres;

public class Main {
    public static void main(String[] args) {
        try {
            Numero n1 = new Numero(25.5);
            System.out.println("Número inicial: " + n1.getValor());

            n1.setValor(10); // válido
            System.out.println("Nuevo valor: " + n1.getValor());

            n1.setValor(-5); // inválido → lanza excepción
            System.out.println("Este mensaje no se ejecuta si hay error.");

        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}
