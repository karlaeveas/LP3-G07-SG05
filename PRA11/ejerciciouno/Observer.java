package ejerciciouno;

public interface Observer {
    
    /**
     * Método que será llamado cuando el sujeto envíe una notificación.
     * 
     * @param mensaje Mensaje enviado por el sujeto.
     */
    void update(String mensaje);
}