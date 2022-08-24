package dao;

import java.util.List;

import modelo.Persona;

public interface PersonaDAO {

	public List<Persona> getListaPersonas();
	public Persona getPersona(String id);
	public int insertarPersona(Persona p);
	public int eliminarPersona(String id);
//	public int editarPersona(Persona p);
	public int modificarPersona(Persona p);
	
}
