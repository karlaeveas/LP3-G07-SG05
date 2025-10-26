package veterinaria;

import java.sql.*;
import java.util.*;

public class GestorMascotas {
    private final List<Mascota> listaMascotas = new ArrayList<>();

    public void cargarDesdeBD() {
        listaMascotas.clear();
        String sql = "SELECT * FROM mascota";
        try (Connection con = ConexionSQLite.conectar();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                listaMascotas.add(new Mascota(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("especie"),
                        rs.getInt("edad")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultar(boolean soloMayores, boolean ascendente, int limite) {
        List<Mascota> resultado = new ArrayList<>(listaMascotas);
        if (soloMayores) resultado.removeIf(m -> m.getEdad() < 5);

        resultado.sort((a, b) ->
                ascendente ? Integer.compare(a.getEdad(), b.getEdad())
                           : Integer.compare(b.getEdad(), a.getEdad()));

        if (limite > 0 && limite < resultado.size())
            resultado = resultado.subList(0, limite);

        System.out.println("\n Resultado de la consulta:");
        resultado.forEach(System.out::println);
    }
}


