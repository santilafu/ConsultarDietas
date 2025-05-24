//Importamos lo necesario para trabajar con JDBC
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Esta clase se encarga de actualizar las dietas del departamento de Ventas
 * aumentando su valor un 10%.
 */
public class ActualizarDietasVentas {
    public static void main(String[] args) {
        // Nos conectamos a la base de datos
        Connection conexion = ConexionBD.conectar();

        if (conexion == null) {
            System.out.println("No se pudo establecer conexión. Finalizando...");
            return;
        }

        // Sentencia SQL para actualizar las dietas del departamento de Ventas
        String sql = "UPDATE Dietas SET cantidad = cantidad * 1.10 WHERE departamento = '?'";

        try {
            PreparedStatement ps = conexion.prepareStatement(sql);
            // Actualizamos las dietas del departamento de Ventas
            int filasActualizadas = ps.executeUpdate();
            System.out.println("Filas actualizadas: " + filasActualizadas);
        } catch (SQLException e) {
            System.out.println("Error al actualizar las dietas: " + e.getMessage());
        } finally {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}