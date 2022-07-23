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

/*
create table persona(
	idPersona INTEGER GENERATED ALWAYS AS IDENTITY (START WITH 1 INCREMENT BY 1),
    dni VARCHAR2(8) not null,
    nombre VARCHAR2(30) not null,
    apellido VARCHAR2(30) not null,
    telefono VARCHAR2(9) not null,
    edad int not null,
    UNIQUE (idPersona)
);

Insert into persona (dni,nombre, apellido, telefono, edad) values ('0000','byron','apellido','123',141);

select * from persona;
*/