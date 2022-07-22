/**
 * 
 */
package datos;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 * @author Byron
 *
 */
public class Conexion {
	private static Connection conexion = null;
	
	public static Connection getconexion() {
		try {
			Class.forName ("oracle.jdbc.driver.OracleDriver");
            conexion = DriverManager.getConnection
            	     ("jdbc:oracle:thin:@192.168.1.79:1521/XEPDB1", "hr", "oracle");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conexion;
	}
	
    public static void cerrarConexion(){
        try {
            conexion.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

/*class testconection{
	public static void main(String[] args) {
		System.out.println(Conexion.getconexion());
		Conexion.cerrarConexion();
		
	}
}
*/