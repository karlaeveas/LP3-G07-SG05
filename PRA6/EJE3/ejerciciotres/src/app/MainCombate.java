package app;

import modelo.*;
import vista.*;
import controlador.*;

public class MainCombate {
    public static void main(String[] args) {
        Jugador heroe = new Jugador("Héroe Agua", 100, 1, "Agua");
        Villano villano = new Villano("Villano Fuego", 100, 1, "Fuego");

        // Inventarios iguales
        Item espada = new Item("Espada", 1, "Arma", "Causa daño cuerpo a cuerpo");
        Item disparador = new Item("Disparador", 1, "Arma", "Ataque a distancia");
        Item bomba = new Item("Bomba", 1, "Arma", "Explosión masiva");

        heroe.agregarItem(espada);
        heroe.agregarItem(disparador);
        heroe.agregarItem(bomba);

        villano.agregarItem(new Item("Espada", 1, "Arma", "Causa daño cuerpo a cuerpo"));
        villano.agregarItem(new Item("Disparador", 1, "Arma", "Ataque a distancia"));
        villano.agregarItem(new Item("Bomba", 1, "Arma", "Explosión masiva"));

        CombateView vista = new CombateView();
        CombateController combate = new CombateController(heroe, villano, vista);

        combate.iniciarCombate();
    }
}
