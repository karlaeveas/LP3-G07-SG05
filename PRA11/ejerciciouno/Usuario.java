package ejerciciouno;

public class Usuario implements Observer {
    
    private String nombre;
    
    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    
    @Override
    public void update(String mensaje) {
        System.out.println(nombre + " recibió: " + mensaje);
    }
    
    public String getNombre() {
        return nombre;
    }
}