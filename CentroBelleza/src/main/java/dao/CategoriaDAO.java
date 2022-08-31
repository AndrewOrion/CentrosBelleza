package dao;

import java.util.List;

import modelo.Categoria;

public interface CategoriaDAO {

	public List<Categoria> getListaCategorias();
	public Categoria getCategoria(String id);
	public int insertarCategoria(Categoria p);
	public int eliminarCategoria(String id);
//	public int editarPersona(Persona p);
	public int modificarCategoria(Categoria p);
	
}
