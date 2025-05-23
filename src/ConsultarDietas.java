// Importamos JDBC para conexión, consultas y manejo de resultados
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase que consulta y muestra dietas del departamento de Informática
 * con importe mayor a 30 euros.
 */
public class ConsultarDietas {
    public static void main(String[] args) {
        // Conectamos a la base de datos
        Connection conexion = ConexionBD.conectar();

        if (conexion == null) {
            System.out.println("No se pudo conectar a la base de datos.");
            return;
        }

        // Consulta SQL con condición de filtro
        String sql = "SELECT * FROM Dietas WHERE departamento = ? AND cantidad > ?";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);

            // Establecemos los valores de los parámetros
            ps.setString(1, "Informática");
            ps.setDouble(2, 30);

            // Ejecutamos la consulta
            ResultSet rs = ps.executeQuery();

            System.out.println(" DIETAS mayores 30€ DEL DEPARTAMENTO DE INFORMÁTICA ");

            // Recorremos los resultados
            while (rs.next()) {
                int id = rs.getInt("id");
                String empleado = rs.getString("empleado");
                double cantidad = rs.getDouble("cantidad");
                String concepto = rs.getString("concepto");

                System.out.println("ID: " + id +
                        " | Empleado: " + empleado +
                        " | Cantidad: " + cantidad +
                        "€ | Concepto: " + concepto);
            }

            rs.close();
            ps.close();
            conexion.close();

        } catch (SQLException e) {
            System.out.println(" Error al realizar la consulta.");
            e.printStackTrace();
        }
    }
}
