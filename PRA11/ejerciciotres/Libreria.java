package ejerciciotres;

import java.util.ArrayList;
import java.util.List;

public class Libreria {

    private List<Libro> catalogo = new ArrayList<>();
    private List<ItemCarrito> carrito = new ArrayList<>();
    private NotificadorPromociones notificador = new NotificadorPromociones();
    private EstrategiaDescuento estrategia = new SinDescuento();

    public Libreria() {
        // Catálogo inicial
        catalogo.add(new Libro(1, "Clean Code", 150.0));
        catalogo.add(new Libro(2, "Design Patterns", 200.0));
        catalogo.add(new Libro(3, "Refactoring", 180.0));
        catalogo.add(new Libro(4, "Java Effective", 160.0));

        // Clientes suscritos
        Cliente c1 = new Cliente("Ana", "ana@example.com");
        Cliente c2 = new Cliente("Luis", "luis@example.com");
        notificador.suscribir(c1);
        notificador.suscribir(c2);
    }

    public void mostrarCatalogo() {
        System.out.println("\n=== CATÁLOGO DE LIBROS ===");
        for (Libro libro : catalogo) {
            System.out.println(libro);
        }
    }

    public Libro buscarLibroPorId(int id) {
        for (Libro libro : catalogo) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public void agregarLibroAlCarrito(Libro libro, int cantidad) {
        if (libro == null || cantidad <= 0) {
            System.out.println("Libro inválido o cantidad no válida.");
            return;
        }
        // Si el libro ya está en el carrito, solo aumenta la cantidad
        for (ItemCarrito item : carrito) {
            if (item.getLibro().getId() == libro.getId()) {
                item.agregarCantidad(cantidad);
                System.out.println("Se agregó " + cantidad + " unidad(es) de \"" + libro.getTitulo() + "\" al carrito.");
                return;
            }
        }
        carrito.add(new ItemCarrito(libro, cantidad));
        System.out.println("Se agregó \"" + libro.getTitulo() + "\" x " + cantidad + " al carrito.");
    }

    public void mostrarCarrito() {
        System.out.println("\n=== CARRITO ACTUAL ===");
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }
        double subtotal = 0.0;
        for (ItemCarrito item : carrito) {
            System.out.println(" - " + item);
            subtotal += item.getSubtotal();
        }
        System.out.println("Subtotal sin descuento: S/ " + subtotal);
        double totalConDescuento = estrategia.calcularTotal(carrito);
        System.out.println("Total con descuento (estrategia actual): S/ " + totalConDescuento);
    }

    public void setEstrategia(EstrategiaDescuento estrategia) {
        this.estrategia = estrategia;
    }

    public void registrarVenta() {
        if (carrito.isEmpty()) {
            System.out.println("No hay productos en el carrito para registrar la venta.");
            return;
        }
        double total = estrategia.calcularTotal(carrito);
        System.out.println("\n=== REGISTRO DE VENTA ===");
        mostrarCarrito();
        System.out.println("Monto final a pagar: S/ " + total);
        carrito.clear();
        notificador.notificar("Se ha registrado una nueva venta en la librería. Gracias por su preferencia.");
    }

    public void enviarPromocion(String mensaje) {
        notificador.notificar("PROMOCIÓN LIBRERÍA: " + mensaje);
    }
}

