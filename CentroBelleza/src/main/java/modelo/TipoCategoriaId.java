package modelo;

import java.util.Objects;

/**
 * 
 * @author Andrés Pino Gallardo
 *
 *Clase que modela tipo de categoría
 *Incluye constructor, getters y setters, toString
 */
public class TipoCategoriaId {
	private String id;
	private String nombre;

/**
 * Constructor parametrizado
 * @param id -> id único del tipo de categoría
 * @param nombre -> nombre del tipo de categoría
 */
	public TipoCategoriaId(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	

	@Override
	public String toString() {
		return "TipoCategoriaId [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
