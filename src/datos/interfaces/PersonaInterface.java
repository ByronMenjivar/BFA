package datos.interfaces;
import entidades.Persona;
import java.util.List;

public interface PersonaInterface {
	public boolean insertar(Persona obj);
	public List<Persona> listar();
	public Persona buscar(int idPersona);
	public boolean actualizar(Persona obj);
	public boolean eliminar(int dniPersona);
}
