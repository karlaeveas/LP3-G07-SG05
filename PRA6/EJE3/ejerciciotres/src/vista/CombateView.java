package vista;

import modelo.Jugador;
import modelo.Villano;
import modelo.Item;

public class CombateView {

    public void mostrarInicio(Jugador heroe, Villano villano) {
        System.out.println(heroe.getNombre() + " (" + heroe.getElemento() + ") vs " 
            + villano.getNombre() + " (" + villano.getTipo() + ")");
        System.out.println("Comienza el combate.\n");
    }

    public void mostrarUsoObjeto(Jugador heroe, Item objeto) {
        System.out.println(heroe.getNombre() + " usa " + objeto.getNombre() + ".");
    }

    public void mostrarAtaque(String atacante, String defensor, int danio) {
        System.out.println(atacante + " ataca a " + defensor + " e inflige " + danio + " puntos de daño.");
    }

    public void mostrarEstado(Jugador heroe, Villano villano, int ronda) {
        System.out.println("\n--- RONDA " + ronda + " ---");
        System.out.println(heroe.getNombre() + ": " + heroe.getSalud() + " HP");
        System.out.println(villano.getNombre() + ": " + villano.getSalud() + " HP");
    }

    public void mostrarGanador(Jugador heroe, Villano villano) {
        System.out.println("\nRESULTADO FINAL");
        if (heroe.getSalud() > villano.getSalud())
            System.out.println(heroe.getNombre() + " gana el combate.");
        else if (heroe.getSalud() < villano.getSalud())
            System.out.println(villano.getNombre() + " gana el combate.");
        else
            System.out.println("Empate técnico.");
    }
}

