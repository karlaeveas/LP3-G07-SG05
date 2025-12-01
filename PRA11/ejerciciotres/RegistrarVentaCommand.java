package ejerciciotres;

public class RegistrarVentaCommand implements Command {

    private Libreria libreria;

    public RegistrarVentaCommand(Libreria libreria) {
        this.libreria = libreria;
    }

    @Override
    public void ejecutar() {
        libreria.registrarVenta();
    }
}

