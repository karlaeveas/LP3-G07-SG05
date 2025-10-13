public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor("personajes.txt");

        gestor.mostrarPersonajes();

        gestor.filtrarPor("ataque");
        gestor.actualizarAtributo("Guerrero", "vida", 10);
        gestor.subirNivel("Caballero");
        gestor.mostrarEstadisticas();

        // Ejemplo de importación externa
        // gestor.importarDesdeArchivo("nuevos_personajes.txt");
    }
}

