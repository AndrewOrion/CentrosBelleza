package modelo;

/**
 * 
 * @author Andrés Pino Gallardo
 *
 *Clase que modela la Provincia
 *
 *Incluye getter y setter de provincia
 */
public class Provincia {
	private int id;
	private String nombre;
	
/**
 * Constructor de provincia	
 * @param id ->id único de provincia
 * @param nombre-> nombre de provincia
 */
	
	public Provincia(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}

	
	
}
