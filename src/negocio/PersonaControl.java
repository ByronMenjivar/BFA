package negocio;
import datos.PersonaDAO;
import entidades.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PersonaControl {
	PersonaDAO datos;
    Persona persona;
    
    DefaultTableModel modelo;
    
    public PersonaControl(){
        datos = new PersonaDAO();
        persona = new Persona();
    }
    
    public String insertar(String dni, String nombre, String apellido, String telefono, int edad){
        
        persona.setDni(dni);
        persona.setNombre(nombre);
        persona.setApellido(apellido);
        persona.setTelefono(telefono);
        persona.setEdad(edad);
        
        if (datos.insertar(persona)) {
            return "OK";
        }else{
            return "Ocurrio un error en el registro";
        }
    }
    
    public DefaultTableModel mostrar(){
        List<Persona> lista = new ArrayList<>();
        
        lista.addAll(datos.listar());
        
        String[] title = {"idPersona", "Dni", "Nombre", "Apellido", "Telefono", "Edad"};
        modelo = new DefaultTableModel(null, title);
        
        String[] registro = new String[6];
        
        for (Persona item : lista) {
            registro[0] = Integer.toString(item.getIdPersona());
            registro[1] = item.getDni();
            registro[2] = item.getNombre();
            registro[3] = item.getApellido();
            registro[4] = item.getTelefono();
            registro[5] = Integer.toString(item.getEdad());
            
            modelo.addRow(registro);
        }
        
        return modelo;
        
    }
    
    public Persona buscar(int id){
        persona = datos.buscar(id);
        return persona;
    }
    
    public String actualizar(Persona persona){
        if (datos.actualizar(persona)) {
            return "OK";
        }else{
            return "Ocurrio un error al actualizar";
        }
    }
    
    public String eliminar(String dni){
        if (datos.eliminar(dni)) {
            return "OK";
        }else{
            return "Ocurrio un error al eliminar";
        }
    }
}
