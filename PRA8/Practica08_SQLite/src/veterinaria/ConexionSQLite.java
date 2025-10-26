package veterinaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQLite {
    private static final String URL = "jdbc:sqlite:veterinaria.db";

    public static Connection conectar() throws SQLException {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection con = DriverManager.getConnection(URL);
            con.createStatement().execute("PRAGMA busy_timeout = 5000");
            return con;
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontró el driver SQLite", e);
        }
    }
}

