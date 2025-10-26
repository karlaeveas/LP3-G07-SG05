package veterinaria;

import java.sql.*;
import java.util.Scanner;

public class MascotaCRUD {
    private static final String CLAVE = "vet123";
    private final Scanner sc = new Scanner(System.in);

    public MascotaCRUD() {
        crearTabla();
    }

    private void crearTabla() {
        String sql = "CREATE TABLE IF NOT EXISTS mascota (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                     "nombre TEXT, especie TEXT, edad INTEGER)";
        try (Connection con = ConexionSQLite.conectar();
             Statement st = con.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertar() {
        String sql = "INSERT INTO mascota(nombre, especie, edad) VALUES (?, ?, ?)";
        try (Connection con = ConexionSQLite.conectar()) {
            con.setAutoCommit(false);

            System.out.print("Nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Especie: ");
            String especie = sc.nextLine();
            System.out.print("Edad: ");
            int edad = sc.nextInt();
            sc.nextLine();

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, nombre);
                ps.setString(2, especie);
                ps.setInt(3, edad);
                ps.executeUpdate();
            }

            if (confirmarOperacion()) {
                con.commit();
                System.out.println("✅ Mascota registrada.");
            } else {
                con.rollback();
                System.out.println("❌ Operación cancelada.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrar() {
        String sql = "SELECT * FROM mascota";
        try (Connection con = ConexionSQLite.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            System.out.println("\n🐾 LISTA DE MASCOTAS:");
            while (rs.next()) {
                System.out.printf("%d | %s | %s | %d años%n",
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("especie"),
                        rs.getInt("edad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizar() {
        String sql = "UPDATE mascota SET nombre=?, especie=?, edad=? WHERE id=?";
        try (Connection con = ConexionSQLite.conectar()) {
            con.setAutoCommit(false);

            System.out.print("ID a actualizar: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Nuevo nombre: ");
            String nombre = sc.nextLine();
            System.out.print("Nueva especie: ");
            String especie = sc.nextLine();
            System.out.print("Nueva edad: ");
            int edad = sc.nextInt();
            sc.nextLine();

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setString(1, nombre);
                ps.setString(2, especie);
                ps.setInt(3, edad);
                ps.setInt(4, id);
                ps.executeUpdate();
            }

            if (confirmarOperacion()) {
                con.commit();
                System.out.println("✅ Actualización confirmada.");
            } else {
                con.rollback();
                System.out.println("❌ Operación cancelada.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar() {
        String sql = "DELETE FROM mascota WHERE id=?";
        try (Connection con = ConexionSQLite.conectar()) {
            con.setAutoCommit(false);
            System.out.print("ID a eliminar: ");
            int id = sc.nextInt();
            sc.nextLine();

            try (PreparedStatement ps = con.prepareStatement(sql)) {
                ps.setInt(1, id);
                ps.executeUpdate();
            }

            if (confirmarOperacion()) {
                con.commit();
                System.out.println("✅ Mascota eliminada.");
            } else {
                con.rollback();
                System.out.println("❌ Eliminación cancelada.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean confirmarOperacion() {
        System.out.print("Ingrese clave (vet123): ");
        return sc.nextLine().equals(CLAVE);
    }
}

