package ejerciciodos;

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        try {
            System.out.println("Suma: " + calc.sumar(10, 50));
            System.out.println("Resta: " + calc.restar(10, 8));
            System.out.println("Multiplicación: " + calc.multiplicar(10, 5));

            System.out.println("División: " + calc.dividir(10, 0));

        } catch (DivisionPorCeroException e) {
            System.out.println("Excepción capturada: " + e.getMessage());

        } catch (IllegalArgumentException e) {
            System.out.println("Error de argumento inválido: " + e.getMessage());

        } catch (ArithmeticException e) {
            System.out.println("Error aritmético: " + e.getMessage());
        }
    }
}