package actividaduno;

public class Main {

	public static void main(String[] args) {
		 Integer[] numeros = {1, 2, 3, 4, 5, 6};
	        String[] palabras = {"Hola", "Mundo", "Java", "Genéricos"};

	       
	        System.out.println("Impresión completa:");
	        Util.imprimirArreglo(numeros);
	        Util.imprimirArreglo(palabras);

	        // Versión con índices válidos
	        System.out.println("\nImpresión parcial válida:");
	        try {
	            int cantidad = Util.imprimirArreglo(numeros, 2, 5); // imprime 3, 4, 5
	            System.out.println("Elementos impresos: " + cantidad);
	        } catch (InvalidSubscriptException e) {
	            System.out.println("Error: " + e.getMessage());
	        }

	        // Pruebas con índices inválidos
	        System.out.println("\nIntento con índices inválidos:");

	        try {
	            Util.imprimirArreglo(palabras, -1, 3);
	        } catch (InvalidSubscriptException e) {
	            System.out.println("Error: " + e.getMessage());
	        }

	        try {
	            Util.imprimirArreglo(palabras, 2, 2);
	        } catch (InvalidSubscriptException e) {
	            System.out.println("Error: " + e.getMessage());
	        }

	        try {
	            Util.imprimirArreglo(palabras, 3, 5);
	        } catch (InvalidSubscriptException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	}


