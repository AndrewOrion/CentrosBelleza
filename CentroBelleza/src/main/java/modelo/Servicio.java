package modelo;

import java.sql.Blob;
import java.util.Objects;

public class Servicio {
	
	private String id;
	private String nombre;
	private String foto;
	private double precio;
	private int puntos;
	private boolean activo;
	
	public Servicio () {
		
	}
	public Servicio(String id, String nombre, String foto, double precio, int puntos, boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
		this.precio = precio;
		this.puntos = puntos;
		this.activo = activo;
	}
	
	public Servicio( String nombre, String foto, double precio, int puntos, boolean activo) {
		super();
		this.nombre = nombre;
		this.foto = foto;
		this.precio = precio;
		this.puntos = puntos;
		this.activo = activo;
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public boolean isActivo() {
		return activo;
	}
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servicio other = (Servicio) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return "Servicio [id=" + id + ", nombre=" + nombre + ", foto=" + foto + ", precio=" + precio + ", puntos="
				+ puntos + ", activo=" + activo + "]";
	}
	
	
	





}