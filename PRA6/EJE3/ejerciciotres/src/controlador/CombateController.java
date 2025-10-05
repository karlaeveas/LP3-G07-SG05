package controlador;

import modelo.*;
import vista.CombateView;

public class CombateController {
    private Jugador heroe;
    private Villano villano;
    private CombateView vista;

    public CombateController(Jugador heroe, Villano villano, CombateView vista) {
        this.heroe = heroe;
        this.villano = villano;
        this.vista = vista;
    }

    public void iniciarCombate() {
        vista.mostrarInicio(heroe, villano);

        String[] armasHeroe = {"Espada", "Disparador", "Bomba"};

        for (int ronda = 1; ronda <= 3; ronda++) {
            vista.mostrarEstado(heroe, villano, ronda);

            // --- Héroe usa un objeto ---
            Item objetoUsado = heroe.usarObjeto(armasHeroe[(ronda - 1) % armasHeroe.length]);
            if (objetoUsado != null) {
                vista.mostrarUsoObjeto(heroe, objetoUsado);
                int danio = heroe.atacar(villano);
                vista.mostrarAtaque(heroe.getNombre(), villano.getNombre(), danio);
            }

            // --- Villano ataca ---
            Item armaVillano = villano.atacar(heroe);
            if (armaVillano != null) {
                vista.mostrarAtaque(villano.getNombre(), heroe.getNombre(),
                    (armaVillano.getNombre().equalsIgnoreCase("espada") ? 15 :
                    armaVillano.getNombre().equalsIgnoreCase("disparador") ? 20 : 40));
            }
        }

        vista.mostrarGanador(heroe, villano);
    }
}
