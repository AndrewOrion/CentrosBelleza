package modelo;

import java.util.Date;
import java.util.Objects;

/** 
 * Clase que modela los datos de una persona
 * 
 * @author Andres Pino
 *
 */
public class Persona {

	private String id;
	private String nombre;
	private String documento;
	private String fechaNacimiento;
	private String direccion;
	private String localidad;
	private String cp;
	private String provinciaID;
	private String email;
	private String telefono;
	private String comunicaciones;
	private String fechaAlta;
	private String ip;
	private boolean activo;
	private String provinciaId;
	
	public Persona() {
		
	}
	
	public Persona(String id, String nombre, String documento, String fechaNacimiento, String direccion, String localidad,
			String cp, String provinciaID, String email, String telefono, String comunicaciones, String fechaAlta,
			String ip, boolean activo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.documento = documento;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.localidad = localidad;
		this.cp = cp;
		this.provinciaID = provinciaID;
		this.email = email;
		this.telefono = telefono;
		this.comunicaciones = comunicaciones;
		this.fechaAlta = fechaAlta;
		this.ip = ip;
		this.activo = activo;
	}
	
	public Persona(String nombre, String documento, String fechaNacimiento, String direccion, String localidad,
			String cp, String provinciaId, String email, String telefono, String comunicaciones, String fechaAlta,
			String ip, boolean activo) {
		super();
		this.nombre = nombre;
		this.documento = documento;
		this.fechaNacimiento = fechaNacimiento;
		this.direccion = direccion;
		this.localidad = localidad;
		this.cp = cp;
		this.provinciaId = provinciaId;
		this.email = email;
		this.telefono = telefono;
		this.comunicaciones = comunicaciones;
		this.fechaAlta = fechaAlta;
		this.ip = ip;
		this.activo = activo;
	}

	public String getId() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getProvinciaId() {
		return provinciaId;
	}

	public void setProvinciaId(String provinciaId) {
		this.provinciaId = provinciaId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getComunicaciones() {
		return comunicaciones;
	}

	public void setComunicaciones(String comunicaciones) {
		this.comunicaciones = comunicaciones;
	}

	public String getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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
		Persona other = (Persona) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Persona [ID=" + id + ", nombre=" + nombre + ", documento=" + documento + ", fechaNacimiento="
				+ fechaNacimiento + ", direccion=" + direccion + ", localidad=" + localidad + ", cp=" + cp
				+ ", provinciaID=" + provinciaID + ", email=" + email + ", telefono=" + telefono + ", comunicaciones="
				+ comunicaciones + ", fechaAlta=" + fechaAlta + ", IP=" + ip + ", activo=" + activo + "]";
	}
	
	
	
	
	
}
