package main;

import modelo.TiendaModelo;
import vista.TiendaVista;
import controlador.TiendaControlador;

public class Main {
    public static void main(String[] args) {
        TiendaModelo modelo = new TiendaModelo();
        TiendaVista vista = new TiendaVista();
        TiendaControlador controlador = new TiendaControlador(modelo, vista);
        controlador.iniciar();
    }
}
