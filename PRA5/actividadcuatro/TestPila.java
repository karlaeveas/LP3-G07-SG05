package actividadcuatro;

public class TestPila {
    public static void main(String[] args) {
        Pila<Integer> pila1 = new Pila<>(5);
        Pila<Integer> pila2 = new Pila<>(5);

        pila1.push(10);
        pila1.push(20);
        pila1.push(30);

        pila2.push(10);
        pila2.push(20);
        pila2.push(30);

        System.out.println(pila1.esIgual(pila2)); // true

        pila2.pop();      // saco el último
        pila2.push(40);   // meto otro distinto
        System.out.println(pila1.esIgual(pila2)); // false
    }
}

