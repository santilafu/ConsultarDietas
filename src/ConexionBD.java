//Importamos librerias JDBC necesarias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * clase que se encarga de crear la conexion a la base de datos MySQL
 */
public class ConexionBD {
    //Ruta de conexion
    private static final String URL = "jdbc:mysql://localhost:3306/Empresa";
    //Usuario de la base de datos
    private static final String USUARIO = "root";
    //Contraseña de la base de datos
    private static final String PASSWORD = "2048C@mpeon1";

    /**
     * Metodo que establece la conexion a la base de datos
     * @return Connection
     */
    public static Connection conectar() {
        try {
            //Conectamos con la base de datos usando DriverManager
            Connection conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            //Imprimimos un mensaje de exito
            System.out.println("Conexión exitosa a la base de datos.");
            //Devolvemos la conexion
            return conexion;
        }catch(SQLException e) {
            //Imprimimos un mensaje de error
            System.out.println("Error al conectar con la base de datos.");
            e.printStackTrace();
            //Devolvemos null si hay un error
            return null;
        }
    }
}