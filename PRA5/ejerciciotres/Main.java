package ejerciciotres;

public class Main {
	public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println("Contenido del Par: " + par);
    }

	public static void main(String[] args) {
	     Par<String, Integer> par1 = new Par<>("Edad", 30);
	        imprimirPar(par1);

	        // Par<Double, Boolean>
	        Par<Double, Boolean> par2 = new Par<>(99.9, true);
	        imprimirPar(par2);

	        // Par<Persona, Integer>
	        Persona persona = new Persona("Carlos");
	        Par<Persona, Integer> par3 = new Par<>(persona, 123456);
	        imprimirPar(par3);
	    }

	}


