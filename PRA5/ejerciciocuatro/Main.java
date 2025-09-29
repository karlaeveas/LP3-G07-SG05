package ejerciciocuatro;

public class Main {
    // Método genérico estático para imprimir un Par
    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println(par);
    }

    public static void main(String[] args) {
        // Probando Par y esIgual
        Par<String, Integer> par1 = new Par<>("Hola", 100);
        Par<String, Integer> par2 = new Par<>("Hola", 100);
        Par<String, Integer> par3 = new Par<>("Adiós", 200);

        System.out.println("par1: " + par1);
        System.out.println("par2: " + par2);
        System.out.println("par3: " + par3);

        System.out.println("par1 es igual a par2? " + par1.esIgual(par2)); // true
        System.out.println("par1 es igual a par3? " + par1.esIgual(par3)); // false

        // Llamadas a imprimirPar con diferentes tipos
        imprimirPar(new Par<>("Texto", 123));
        imprimirPar(new Par<>(3.14, true));
        imprimirPar(new Par<>(new Persona("Ana"), 25));
    }
}
