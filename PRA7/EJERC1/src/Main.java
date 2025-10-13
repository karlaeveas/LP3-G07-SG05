public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor("personajes.txt");

        // Mostrar personajes actuales
        gestor.mostrarPersonajes();

        // Agregar personajes
        gestor.agregarPersonaje("Caballero", 4, 2, 4, 2);
        gestor.agregarPersonaje("Guerrero", 2, 4, 2, 4);
        gestor.agregarPersonaje("Arquero", 2, 4, 1, 8);

        // Mostrar lista actualizada
        gestor.mostrarPersonajes();

        // Modificar personaje
        gestor.modificarPersonaje("Guerrero", 3, 5, null, null);

        // Eliminar personaje
        gestor.eliminarPersonaje("Arquero");

        // Mostrar resultado final
        gestor.mostrarPersonajes();
    }
}
