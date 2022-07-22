package datos;
import datos.interfaces.PersonaInterface;
import entidades.Persona;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PersonaDAO implements PersonaInterface{

	PreparedStatement ps;
    ResultSet rs;
    
	@Override
	public boolean insertar(Persona obj) {
        boolean resp = false;

        try {
            String sql = "Insert into persona (dni, nombre, apellido, telefono, edad) values(?, ?, ?, ?, ?)";

            ps = Conexion.getconexion().prepareStatement(sql);
            ps.setString(1, obj.getDni());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getApellido());
            ps.setString(4, obj.getTelefono());
            ps.setInt(5, obj.getEdad());

            if (ps.executeUpdate() > 0) {
                resp = true;
            }
            ps.close();
            Conexion.cerrarConexion();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return resp;
	}

	@Override
	public List<Persona> listar() {
		List<Persona> registros = new ArrayList<>();

        try {
            String consulta = "select * from persona";
            ps = Conexion.getconexion().prepareStatement(consulta);

            rs = ps.executeQuery();

            while (rs.next()) {
                int idPersona = rs.getInt(1);
                String dni = rs.getString(2);
                String nombre = rs.getString(3);
                String apellido = rs.getString(4);
                String telefono = rs.getString(5);
                int edad = rs.getInt(6);

                registros.add(new Persona(idPersona, dni, nombre, apellido, telefono, edad));
            }
            rs.close();
            ps.close();
            Conexion.cerrarConexion();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return registros;
	}

	@Override
	public Persona buscar(String dniPersona) {
		Persona persona = null;

        try {
            String consulta = "select * from persona where dni = ?";

            ps = Conexion.getconexion().prepareStatement(consulta);
            ps.setString(1, dniPersona);
            rs = ps.executeQuery();

            if (rs.next()) {
                int idPersona = rs.getInt(1);
                String dni = rs.getString(2);
                String nombre = rs.getString(3);
                String apellido = rs.getString(4);
                String telefono = rs.getString(5);
                int edad = rs.getInt(6);
                
                persona = new Persona(idPersona, dni, nombre, apellido, telefono, edad);
            }
            
            rs.close();
            ps.close();
            Conexion.cerrarConexion();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return persona;
	}

	@Override
	public boolean actualizar(Persona obj) {
boolean resp = false;
        
        try {
            String update = "update persona set dni =?, nombre =?, apellido = ?, telefono = ?, edad = ? where idPersona = ?";
            
            ps = Conexion.getconexion().prepareStatement(update);
            ps.setString(1, obj.getDni());
            ps.setString(2, obj.getNombre());
            ps.setString(3, obj.getApellido());
            ps.setString(4, obj.getTelefono());
            ps.setInt(5, obj.getEdad());
            ps.setInt(6, obj.getIdPersona());
            
            if (ps.executeUpdate()>0) {
                resp = true;
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return resp;
	}

	@Override
	public boolean eliminar(String dni) {
boolean resp = false;
        try {
            String delete = "delete from persona where dni = ?";
            ps = Conexion.getconexion().prepareStatement(delete);
            ps.setString(1, dni);
            
            
            if (ps.executeUpdate()>0) {
                resp = true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return resp;
	}

}
