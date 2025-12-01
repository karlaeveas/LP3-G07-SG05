package ejerciciotres;

public class MostrarCatalogoCommand implements Command {

    private Libreria libreria;

    public MostrarCatalogoCommand(Libreria libreria) {
        this.libreria = libreria;
    }

    @Override
    public void ejecutar() {
        libreria.mostrarCatalogo();
    }
}

