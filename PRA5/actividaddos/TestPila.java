package actividaddos;

public class TestPila {
    public static void main(String[] args) {
        Pila<String> pila = new Pila<>(5);
        pila.push("A");
        pila.push("B");
        pila.push("C");

        System.out.println(pila.contains("B")); // true
        System.out.println(pila.contains("Z")); // false
    }
}

