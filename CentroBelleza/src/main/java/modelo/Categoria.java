package modelo;

import java.sql.Blob;
import java.util.Objects;

public class Categoria {
	
	private String id;
	private String nombre;
	private Blob foto;
	private String tipoCategoriaId;
	private boolean padre;
	private boolean activo;
	
	public Categoria(String id, String nombre, Blob foto, String tipoCategoriaId, boolean padre, boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.foto = foto;
		this.tipoCategoriaId = tipoCategoriaId;
		this.padre = padre;
		this.activo = activo;
	}
	
	public Categoria(String nombre, Blob foto, String tipoCategoriaId, boolean padre, boolean activo) {
		super();
		this.nombre = nombre;
		this.foto = foto;
		this.tipoCategoriaId = tipoCategoriaId;
		this.padre = padre;
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

	public Blob getFoto() {
		return foto;
	}

	public void setFoto(Blob foto) {
		this.foto = foto;
	}

	public String getTipoCategoriaId() {
		return tipoCategoriaId;
	}

	public void setTipoCategoriaId(String tipoCategoriaId) {
		this.tipoCategoriaId = tipoCategoriaId;
	}

	public boolean isPadre() {
		return padre;
	}

	public void setPadre(boolean padre) {
		this.padre = padre;
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
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + ", foto=" + foto + ", tipoCategoriaId=" + tipoCategoriaId
				+ ", padre=" + padre + ", activo=" + activo + "]";
	}
	
	
	
	
	
	
	
	
}
