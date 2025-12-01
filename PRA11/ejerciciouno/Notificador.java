package ejerciciouno;


import java.util.ArrayList;
import java.util.List;

public class Notificador {
    
    private List<Observer> observadores;
    
    public Notificador() {
        this.observadores = new ArrayList<>();
    }
    
    /**
     * Registra un nuevo observador en la lista.
     * 
     * @param observer observador a suscribir
     */
    public void suscribir(Observer observer) {
        if (!observadores.contains(observer)) {
            observadores.add(observer);
        }
    }
    
    /**
     * Elimina un observador de la lista.
     * 
     * @param observer observador a desuscribir
     */
    public void desuscribir(Observer observer) {
        observadores.remove(observer);
    }
    
    /**
     * Envía un mensaje a todos los observadores registrados.
     * 
     * @param mensaje mensaje de notificación
     */
    public void notificar(String mensaje) {
        for (Observer observer : observadores) {
            observer.update(mensaje);
        }
    }
}