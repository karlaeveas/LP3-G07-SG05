package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Villano {
    private String nombre;
    private int salud;
    private int nivel;
    private String tipo;
    private List<Item> inventario;
    private Random random;

    public Villano(String nombre, int salud, int nivel, String tipo) {
        this.nombre = nombre;
        this.salud = salud;
        this.nivel = nivel;
        this.tipo = tipo;
        this.inventario = new ArrayList<>();
        this.random = new Random();
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getNivel() { return nivel; }
    public String getTipo() { return tipo; }

    public void agregarItem(Item item) { inventario.add(item); }

    public void recibirDanio(int d) {
        salud -= d;
        if (salud < 0) salud = 0;
    }

    public Item atacar(Jugador jugador) {
        if (inventario.isEmpty()) return null;

        Item arma = inventario.get(random.nextInt(inventario.size()));
        int danio = 0;
        switch (arma.getNombre().toLowerCase()) {
            case "espada": danio = 15; break;
            case "disparador": danio = 20; break;
            case "bomba": danio = 40; break;
        }

        jugador.recibirDanio(danio);
        return arma;
    }
}
