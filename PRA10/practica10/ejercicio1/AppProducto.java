package ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AppProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtNombre, txtPrecio, txtStock, txtCategoria;
    private JLabel lblInfo;
    private Producto producto;

    public AppProducto() {
        super("Gestión de Producto");

        producto = new Producto();

        setLayout(new GridLayout(6, 2, 5, 5));

        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        add(txtPrecio);

        add(new JLabel("Cantidad en Stock:"));
        txtStock = new JTextField();
        add(txtStock);

        add(new JLabel("Categoría:"));
        txtCategoria = new JTextField();
        add(txtCategoria);

        JButton btnActualizar = new JButton("Actualizar Producto");
        add(btnActualizar);

        lblInfo = new JLabel("Datos del producto aquí...");
        add(lblInfo);

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarProducto();
            }
        });

        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void actualizarProducto() {
        try {
            producto.setNombre(txtNombre.getText());
            producto.setPrecio(Double.parseDouble(txtPrecio.getText()));
            producto.setCantidadStock(Integer.parseInt(txtStock.getText()));
            producto.setCategoria(txtCategoria.getText());

          
            lblInfo.setText(producto.toString());

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Error: precio y stock deben ser numéricos.",
                "Datos inválidos",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppProducto());
    }
}
