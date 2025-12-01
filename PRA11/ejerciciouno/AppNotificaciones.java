package ejerciciouno;

public class AppNotificaciones {

    public static void main(String[] args) {
        
        // 1. Crear el sujeto (sistema de notificaciones)
        Notificador notificador = new Notificador();
        
        // 2. Crear varios usuarios (observadores)
        Usuario usuario1 = new Usuario("Amanda");
        Usuario usuario2 = new Usuario("Mariela");
        Usuario usuario3 = new Usuario("Gabriel");
        
        // 3. Suscribir usuarios al sistema de notificaciones
        notificador.suscribir(usuario1);
        notificador.suscribir(usuario2);
        notificador.suscribir(usuario3);
        
        // 4. Enviar primera notificación
        System.out.println("== Enviando notificación 1 ==");
        notificador.notificar("Nueva promoción 2x1 en productos seleccionados.");
        
        // 5. Desuscribir a un usuario
        System.out.println("\nGabriel se desuscribe de las notificaciones.\n");
        notificador.desuscribir(usuario3);
        
        // 6. Enviar segunda notificación
        System.out.println("== Enviando notificación 2 ==");
        notificador.notificar("Descuento del 30% por compras mayores a S/ 150.");
    }
}

