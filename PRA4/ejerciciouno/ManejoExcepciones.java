package ejerciciouno;

public class ManejoExcepciones {
	 private LeerEntrada lector;

	    public ManejoExcepciones() {
	        lector = new LeerEntrada();
	    }

	    public void procesar() throws ExcepcionVocal, ExcepcionNumero, ExcepcionBlanco, ExcepcionSalida {
	        char c = lector.getChar();

	        if ("aeiouAEIOU".indexOf(c) != -1) {
	            throw new ExcepcionVocal(c);
	        } else if (Character.isDigit(c)) {
	            throw new ExcepcionNumero(c);
	        } else if (Character.isWhitespace(c)) {
	            throw new ExcepcionBlanco();
	        } else if (c == 'x' || c == 'X') {
	            throw new ExcepcionSalida();
	        } else {
	            System.out.println(" Carácter aceptado: " + c);
	        }
	    }

	public static void main(String[] args) {
		  ManejoExcepciones app = new ManejoExcepciones();
	        boolean continuar = true;

	        while (continuar) {
	            try {
	                app.procesar();
	            } catch (ExcepcionVocal e) {
	                System.out.println(e.getMessage());
	            } catch (ExcepcionNumero e) {
	                System.out.println(e.getMessage());
	            } catch (ExcepcionBlanco e) {
	                System.out.println(e.getMessage());
	            } catch (ExcepcionSalida e) {
	                System.out.println(e.getMessage());
	                continuar = false;
	            }
	        }
	    }

	}


