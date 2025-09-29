package ejerciciouno;

public class Main {

	public static void main(String[] args) {
	       Par<String, Integer> par1 = new Par<>("Edad", 25);
	        System.out.println(par1); // (Primero: Edad, Segundo: 25)

	        // Cambiar valores
	        par1.setSegundo(30);
	        System.out.println("Despues de cambiar segundo: " + par1);

	        // Par de objetos del mismo tipo
	        Par<Double, Double> coordenadas = new Par<>(12.5, 34.7);
	        System.out.println("Coordenadas: " + coordenadas);

	        // Par con nulls
	        Par<Object, Object> parNulo = new Par<>(null, null);
	        System.out.println("Par con nulls: " + parNulo);
	    }

}


