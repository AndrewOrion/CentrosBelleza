package dao;

import java.util.List;

import modelo.TipoCategoriaId;

public interface TipoCategoriaIdDAO {
	List<TipoCategoriaId> getListaTipoCategoriaId();
	TipoCategoriaId getTipoCategoriaId(String id);
}
