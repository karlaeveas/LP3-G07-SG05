package modelo;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String nombre;
    private int salud;
    private int nivel;
    private String elemento;
    private List<Item> inventario;
    private Item objetoActual; // el objeto que se está usando

    public Jugador(String nombre, int salud, int nivel, String elemento) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.elemento = elemento;
        this.inventario = new ArrayList<>();
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }
    public String getElemento() { return elemento; }

    public void agregarItem(Item item) { inventario.add(item); }

    public void recibirDanio(int d) {
        salud -= d;
        if (salud < 0) salud = 0;
    }

    public Item usarObjeto(String nombreObjeto) {
        for (Item it : inventario) {
            if (it.getNombre().equalsIgnoreCase(nombreObjeto) && it.getCantidad() > 0) {
                objetoActual = it;
                it.usarItem(); // lo marca como usado (si fuera consumible)
                return it;
            }
        }
        return null;
    }

    public int atacar(Villano enemigo) {
        if (objetoActual == null) return 0;

        int danio = 0;
        switch (objetoActual.getNombre().toLowerCase()) {
            case "espada": danio = 15; break;
            case "disparador": danio = 20; break;
            case "bomba": danio = 40; break;
        }

        enemigo.recibirDanio(danio);
        return danio;
    }
}
