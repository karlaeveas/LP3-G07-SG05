package ejerciciotres;

import java.util.ArrayList;
import java.util.List;

public class NotificadorPromociones {

    private List<Observer> observadores = new ArrayList<>();

    public void suscribir(Observer observer) {
        if (!observadores.contains(observer)) {
            observadores.add(observer);
        }
    }

    public void desuscribir(Observer observer) {
        observadores.remove(observer);
    }

    public void notificar(String mensaje) {
        for (Observer o : observadores) {
            o.update(mensaje);
        }
    }
}

