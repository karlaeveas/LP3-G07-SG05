package vista;

import java.util.List;
import modelo.Item;

public class InventarioView {
    public void mostrarInventario(List<Item> items) {
        if (items.isEmpty()) {
            System.out.println("El inventario está vacío.");
        } else {
            System.out.println("\n--- INVENTARIO ---");
            for (Item i : items) {
                System.out.println("- " + i.getNombre() + " (" + i.getTipo() + ") x" + i.getCantidad());
            }
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarDetallesItem(Item item) {
        if (item != null) {
            System.out.println("\n--- DETALLES DEL ITEM ---");
            System.out.println("Nombre: " + item.getNombre());
            System.out.println("Tipo: " + item.getTipo());
            System.out.println("Cantidad: " + item.getCantidad());
            System.out.println("Descripción: " + item.getDescripcion());
        } else {
            System.out.println("El ítem no existe en el inventario.");
        }
    }
}

