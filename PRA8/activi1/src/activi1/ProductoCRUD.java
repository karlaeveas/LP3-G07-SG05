package activi1;

import java.sql.*;

public class ProductoCRUD {

    private static final String URL = "jdbc:sqlite:tienda.db";
    private static final String CLAVE = "1234";
    private Connection con;

    public ProductoCRUD() {
        conectar();
        crearTabla();
    }

    private void conectar() {
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(URL);
            System.out.println("Conectado a tienda.db");
        } catch (Exception e) { e.printStackTrace(); }
    }

    private void crearTabla() {
        try (Statement st = con.createStatement()) {
            st.execute("""
                CREATE TABLE IF NOT EXISTS producto(
                  id INTEGER PRIMARY KEY AUTOINCREMENT,
                  nombre TEXT,
                  precio REAL)
            """);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void insertar(String nombre, double precio) {
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO producto(nombre,precio) VALUES(?,?)");
            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void mostrar() {
        try (Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM producto");
            while (rs.next()) {
                System.out.println(rs.getInt("id")+" | "+rs.getString("nombre")+
                    " | S/ "+rs.getDouble("precio"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    public void actualizar(int id, String nombre, double precio) {
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(
                "UPDATE producto SET nombre=?, precio=? WHERE id=?");
            ps.setString(1, nombre);
            ps.setDouble(2, precio);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public void eliminar(int id) {
        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM producto WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public boolean confirmar(String clave) {
        try {
            if (clave.equals(CLAVE)) {
                con.commit();
                return true;
            } else {
                con.rollback();
                return false;
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return false;
    }
}

