package modelo;

import java.io.File;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Objects;

/**
 * @author Andrés Pino Gallardo 
 * Clase que modela los datos de una persona
 * 
 * 
 *
 *Incluye constructor, getters y setters, toString, hashcode y equals
 */
public class Persona {

	private String id;
	private String nombre;
	private String documento;
	private String fechaNacimiento;
	private String direccion;
	private String localidad;
	private String cp;
	private int provinciaId;
	private String email;
	private String telefono;
	private String comunicaciones;
	private String fechaAlta;
	private String ip;
	private boolean activo;
	public Persona() {
		
	}

/**
 * Constructor de clase Persona
 * 
 * @param id ->id único de la persona
 * @param nombre ->nombre completo de la persona
 * @param documento -> documento de identidad
 * @param fechaNacimiento -> fecha de nacimiento de la persona
 * @param direccion -> dirección de la persona
 * @param localidad -> localidad donde vive
 * @param cp -> código postal
 * @param provinciaId -> id de la provincia que se obtiene de la tabla provincias
 * @param email -> email de la persona
 * @param telefono -> teléfono de la persona
 * @param comunicaciones -> otras vías de comunicación
 * @param fechaAlta -> fecha en la que se dio de alta
 * @param ip -> número de ip
 * @param activo -> booleano que indica si está activo o no
 */
	public Persona(String id, String nombre, String documento, String fechaNacimiento, String direccion, String localidad,
			String cp, int provinciaId, String email, String telefono, String comunicaciones, String fechaAlta,
			String ip, boolean activo) {
		super();
		this.id = id;
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

/**
 * Constructor de clase persona sin incluir parámetro id
 * @param nombre
 * @param documento
 * @param fechaNacimiento
 * @param direccion
 * @param localidad
 * @param cp
 * @param provinciaId
 * @param email
 * @param telefono
 * @param comunicaciones
 * @param fechaAlta
 * @param ip
 * @param activo
 */
	public Persona(String nombre, String documento, String fechaNacimiento, String direccion, String localidad,
			String cp, int provinciaId, String email, String telefono, String comunicaciones, String fechaAlta,
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

/** getters y setters de persona
 * 
 * 
 */
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

	public int getProvinciaId() {
		return provinciaId;
	}

	public void setProvinciaId(int provinciaId) {
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
				+ ", provinciaId=" + provinciaId + ", email=" + email + ", telefono=" + telefono + ", comunicaciones="
				+ comunicaciones + ", fechaAlta=" + fechaAlta + ", IP=" + ip + ", activo=" + activo + "]";
	}
	
	 
	
	
	
}
