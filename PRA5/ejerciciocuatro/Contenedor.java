package ejerciciocuatro;

import java.util.ArrayList;
import java.util.List;

public class Contenedor<F, S> {
    private List<Par<F, S>> listaPares;

    // Constructor
    public Contenedor() {
        listaPares = new ArrayList<>();
    }

    // Agregar un par
    public void agregarPar(F primero, S segundo) {
        listaPares.add(new Par<>(primero, segundo));
    }

    // Obtener un par por índice
    public Par<F, S> obtenerPar(int indice) {
        if (indice >= 0 && indice < listaPares.size()) {
            return listaPares.get(indice);
        }
        return null; // Si el índice no es válido
    }

    // Obtener todos los pares
    public List<Par<F, S>> obtenerTodosLosPares() {
        return listaPares;
    }

    // Mostrar todos los pares
    public void mostrarPares() {
        for (Par<F, S> par : listaPares) {
            System.out.println(par);
        }
    }
}

