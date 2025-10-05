package app;

import modelo.*;
import vista.*;
import controlador.*;

public class Main {
    public static void main(String[] args) {
        InventarioModel modelo = new InventarioModel();
        InventarioView vista = new InventarioView();
        InventarioController controlador = new InventarioController(modelo, vista);

        // Agregamos algunos items
        controlador.agregarItem("Espada", 1, "Arma", "Una espada forjada en hierro resistente.");
        controlador.agregarItem("Poción de Vida", 3, "Poción", "Recupera 20 puntos de vida.");
        controlador.agregarItem("Disparador", 2, "Arma", "Ataca al enemigo.");
        controlador.agregarItem("Escudo", 2, "Arma", "Aumenta la defensa del jugador.");

        // Mostramos el inventario completo
        controlador.verInventario();

        // Buscamos un ítem
        controlador.buscarItem("Poción de Vida");

        // Mostramos los detalles de un ítem específico
        controlador.mostrarDetalles("Espada");

        // Eliminamos un ítem
        controlador.eliminarItem("Escudo");

        // Verificamos inventario final
        controlador.verInventario();
    }
}

