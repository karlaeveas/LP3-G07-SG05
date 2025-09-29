package ejerciciocuatro;

public class PruebaContenedor {
    public static void main(String[] args) {
        Contenedor<String, Integer> contenedor = new Contenedor<>();

        contenedor.agregarPar("Uno", 1);
        contenedor.agregarPar("Dos", 2);
        contenedor.agregarPar("Tres", 3);

        System.out.println("Todos los pares:");
        contenedor.mostrarPares();

        System.out.println("Par en índice 1: " + contenedor.obtenerPar(1));

        System.out.println("Lista completa de pares: " + contenedor.obtenerTodosLosPares());
    }
}

