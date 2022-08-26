package dao;

import java.util.List;

import modelo.Servicio;

public interface ServicioDAO {

	public List<Servicio> getListaServicios();
	public Servicio getServicio(String id);
	public int insertarServicio(Servicio s);
	public int eliminarServicio(String id);
	public int modificarServicio(Servicio s);
	
}
