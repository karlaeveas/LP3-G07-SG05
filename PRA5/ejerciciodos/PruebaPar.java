package ejerciciodos;

public class PruebaPar {
    public static void main(String[] args) {
        Par<String, Integer> par1 = new Par<>("Hola", 10);
        Par<String, Integer> par2 = new Par<>("Hola", 10);
        Par<String, Integer> par3 = new Par<>("Adiós", 20);

        System.out.println(par1 + " es igual a " + par2 + "? " + par1.esIgual(par2)); // true
        System.out.println(par1 + " es igual a " + par3 + "? " + par1.esIgual(par3)); // false
    }
}
