package dao;

import java.util.List;

import modelo.Provincia;

public interface ProvinciaDAO {
	List<Provincia> getListaProvincias();
	Provincia getProvincia(int id);
}
