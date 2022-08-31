package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import modelo.Persona;
import utilidades.ConexionBD;

public class PersonaDAOMySQL implements PersonaDAO {
	
	private ConexionBD conexion;
	private Statement consulta = null;
	private PreparedStatement consultaPreparada = null;
	private ResultSet resultado = null;
	
	public PersonaDAOMySQL() {
		conexion = new ConexionBD();
	}

	@Override
	public List<Persona> getListaPersonas(){
		List<Persona> listaPersonas = new ArrayList<Persona>();
		Connection con = conexion.getConexion();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from personas");
			while (resultado.next()) {
			
				String id = resultado.getString("ID");
				String nombre = resultado.getString("nombre");
				String documento = resultado.getString("documento");
				String fechaNacimiento = resultado.getString("fechaNacimiento");
				String direccion = resultado.getString("direccion");
				String localidad = resultado.getString("localidad");
				String cp = resultado.getString("cp");
				int provinciaID = resultado.getInt("provinciaId");
				String email = resultado.getString("email");
				String telefono = resultado.getString("telefono");
				String comunicaciones = resultado.getString("comunicaciones");
				String fechaAlta = resultado.getString("fechaAlta");
				String ip = resultado.getString("ip");
				boolean activo = resultado.getBoolean("activo");
				
				Persona p = new Persona(id,nombre, documento, fechaNacimiento, direccion,
						localidad, cp, provinciaID, email, telefono,comunicaciones,fechaAlta,
						ip,activo);
				listaPersonas.add(p);
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre personas: "+e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}

		return listaPersonas;
	}

	@Override
	public Persona getPersona(String id) {
		Connection con = conexion.getConexion();
		Persona a = null;
		
		try {
			consultaPreparada = con.prepareStatement("select * from personas"
					+ " where ID = ?");
			consultaPreparada.setString(1, id);
			resultado=consultaPreparada.executeQuery();
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			if (resultado.next()) {
				String id1 = resultado.getString("id");
				String nombre = resultado.getString("nombre");
				String documento = resultado.getString("documento");
				String fechaNacimiento = resultado.getString("fechaNacimiento");
				String direccion = resultado.getString("direccion");
				String localidad = resultado.getString("localidad");
				String cp = resultado.getString("cp");
				int provinciaID = resultado.getInt("provinciaId");
				String email = resultado.getString("email");
				String telefono = resultado.getString("telefono");
				String comunicaciones = resultado.getString("comunicaciones");
				String fechaAlta = resultado.getString("fechaAlta");
				String ip = resultado.getString("ip");
				boolean activo = resultado.getBoolean("activo");
				
				a = new Persona(id1, nombre, documento, fechaNacimiento, direccion,
						localidad, cp, provinciaID, email, telefono,comunicaciones,fechaAlta,
						ip,activo);
				}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre la persona: "
		         +e.getMessage());
		} finally {
			try {
				resultado.close();
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return a;
	}



	@Override
	public int eliminarPersona(String id) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("DELETE FROM personas WHERE ID = ?");
			
			consultaPreparada.setString(1, id);
			resultado=consultaPreparada.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar el borrado de un asesor: "+e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;
	}		
	
	@Override
	public int insertarPersona(Persona a) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement(
					"insert into personas values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			consultaPreparada.setString(1, a.getId());
			consultaPreparada.setString(2, a.getNombre());
			consultaPreparada.setString(3, a.getDocumento());
			consultaPreparada.setString(4, a.getFechaNacimiento());
			consultaPreparada.setString(5, a.getDireccion());
			consultaPreparada.setString(6, a.getLocalidad());
			consultaPreparada.setString(7, a.getCp());
			consultaPreparada.setInt(8, a.getProvinciaId());
			consultaPreparada.setString(9, a.getEmail());
			consultaPreparada.setString(10, a.getTelefono());
			consultaPreparada.setString(11, a.getComunicaciones());
			consultaPreparada.setString(12, a.getFechaAlta());
			consultaPreparada.setString(13, a.getIp());
			consultaPreparada.setBoolean(14, a.isActivo());
			
			resultado=consultaPreparada.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar persona: "
					+e.getMessage());
		} finally {
			try {
				consulta.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;

	}

	@Override
	public int modificarPersona(Persona persona) {
		Connection con = conexion.getConexion();
		PreparedStatement consultaPreparada =null;
		int resultado=0;
		System.out.println(persona.isActivo());
		System.out.println(persona);
		try {
			consultaPreparada = con.prepareStatement("UPDATE personas "
					+ "SET nombre=?, "
					+ "documento=?, "
					+ "fechaNacimiento=?, "
					+ "direccion=?, "
					+ "localidad=?, "
					+ "cp=?, "
					+ "provinciaID=?, "
					+ "email=?, "
					+ "telefono=?, "
					+ "comunicaciones=?, "
					+ "fechaAlta=?, "
					+ "IP=?, "
					+ "activo=? "
					+ "WHERE ID=?");
			
			consultaPreparada.setString(1, persona.getNombre());
			consultaPreparada.setString(2, persona.getDocumento());
			consultaPreparada.setString(3, persona.getFechaNacimiento());
			consultaPreparada.setString(4, persona.getDireccion());
			consultaPreparada.setString(5, persona.getLocalidad());
			consultaPreparada.setString(6, persona.getCp());
			consultaPreparada.setInt(7, persona.getProvinciaId());
			consultaPreparada.setString(8, persona.getEmail());
			consultaPreparada.setString(9, persona.getTelefono());
			consultaPreparada.setString(10, persona.getComunicaciones());
			consultaPreparada.setString(11, persona.getFechaAlta());
			consultaPreparada.setString(12, persona.getIp());
			consultaPreparada.setBoolean(13, persona.isActivo());
			consultaPreparada.setString(14, persona.getId());
			
			resultado=consultaPreparada.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la actualizacion de la persona: "
					+e.getMessage());
		} finally {
			try {
				consultaPreparada.close();
				conexion.desconectar();
			} catch (SQLException e) {
				System.out.println("Error al liberar recursos: "+e.getMessage());
			} catch (Exception e) {
				
			}
		}
		return resultado;

	
	}
}
