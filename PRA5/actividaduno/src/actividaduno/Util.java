package actividaduno;

public class Util {

    public static <T> void imprimirArreglo(T[] arreglo) {
        for (T elemento : arreglo) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }


    public static <T> int imprimirArreglo(T[] arreglo, int subindiceInferior, int subindiceSuperior) {
        if (subindiceInferior < 0 || subindiceSuperior > arreglo.length ||
            subindiceSuperior <= subindiceInferior) {
            throw new InvalidSubscriptException("Índices inválidos: [" + subindiceInferior + ", " + subindiceSuperior + ")");
        }

        for (int i = subindiceInferior; i < subindiceSuperior; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();

        return subindiceSuperior - subindiceInferior;
    }

}
