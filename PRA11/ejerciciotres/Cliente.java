package ejerciciotres;

public class Cliente implements Observer {

    private String nombre;
    private String email;

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    @Override
    public void update(String mensaje) {
        System.out.println("Cliente " + nombre + " (" + email + ") recibió notificación: " + mensaje);
    }

    public String getNombre() {
        return nombre;
    }
}
