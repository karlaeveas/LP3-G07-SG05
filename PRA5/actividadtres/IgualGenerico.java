package actividadtres;

public class IgualGenerico {
	   public static <T> boolean esIgualA(T a, T b) {
	        if (a == null && b == null) {
	            return true;
	        }
	        if (a == null || b == null) {
	            return false;
	        }
	        return a.equals(b);
	    }

}
