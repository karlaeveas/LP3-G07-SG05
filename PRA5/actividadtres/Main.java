package actividadtres;

public class Main {

	public static void main(String[] args) {
		// Integer vs Integer
        Integer num1 = 100;
        Integer num2 = 100;
        System.out.println("Integer == Integer: " + IgualGenerico.esIgualA(num1, num2)); // true

        // Integer vs diferente Integer
        Integer num3 = 200;
        System.out.println("Integer == diferente Integer: " + IgualGenerico.esIgualA(num1, num3)); // false

        // String vs String
        String texto1 = "Hola";
        String texto2 = "Hola";
        System.out.println("String == String: " + IgualGenerico.esIgualA(texto1, texto2)); // true

        // String vs diferente String
        String texto3 = "Mundo";
        System.out.println("String == diferente String: " + IgualGenerico.esIgualA(texto1, texto3)); // false

        // Object vs Object
        Object obj1 = new Object();
        Object obj2 = new Object();
        System.out.println("Object == Object: " + IgualGenerico.esIgualA(obj1, obj2)); // false (referencias distintas)

        // null vs null
        System.out.println("null == null: " + IgualGenerico.esIgualA(null, null)); // true

        // null vs String
        System.out.println("null == String: " + IgualGenerico.esIgualA(null, texto1)); // false

        // int vs int → Se autoboxean a Integer
        int x = 10;
        int y = 10;
        System.out.println("int == int: " + IgualGenerico.esIgualA(x, y)); // true

        // double vs double
        double d1 = 5.5;
        double d2 = 5.5;
        System.out.println("double == double: " + IgualGenerico.esIgualA(d1, d2)); // true
    }

}


