package dao;

import java.util.List;

import modelo.Persona;

public interface PersonaDAO {

	List<Persona> getListaPersonas();
	Persona getPersona(String ID);
	int insertarPersona(Persona p);
	int eliminarPersona(String ID);
	int actualizarPersona(Persona p);
	
}
