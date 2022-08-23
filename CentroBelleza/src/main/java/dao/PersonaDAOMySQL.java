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
				String provinciaID = resultado.getString("provinciaID");
				String email = resultado.getString("email");
				String telefono = resultado.getString("telefono");
				String comunicaciones = resultado.getString("comunicaciones");
				String fechaAlta = resultado.getString("fechaAlta");
				String IP = resultado.getString("IP");
				boolean activo = resultado.getBoolean("activo");
				
				Persona p = new Persona(id, nombre, documento, fechaNacimiento, direccion,
						localidad, cp, provinciaID, email, telefono,comunicaciones,fechaAlta,
						IP,activo);
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
				String ID = resultado.getString("ID");
				String nombre = resultado.getString("nombre");
				String documento = resultado.getString("documento");
				String fechaNacimiento = resultado.getString("fechaNacimiento");
				String direccion = resultado.getString("direccion");
				String localidad = resultado.getString("localidad");
				String cp = resultado.getString("cp");
				String provinciaID = resultado.getString("provinciaID");
				String email = resultado.getString("email");
				String telefono = resultado.getString("telefono");
				String comunicaciones = resultado.getString("comunicaciones");
				String fechaAlta = resultado.getString("fechaAlta");
				String IP = resultado.getString("IP");
				boolean activo = resultado.getBoolean("activo");
				
				a = new Persona(ID, nombre, documento, fechaNacimiento, direccion,
						localidad, cp, provinciaID, email, telefono,comunicaciones,fechaAlta,
						IP,activo);
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
	public int eliminarPersona(String ID) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("DELETE FROM asesores\r\n"
					+ "WHERE ID = ?");
			
			consultaPreparada.setString(1, ID);
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
	public int actualizarPersona(Persona a) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("UPDATE personas\r\n"
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
					+ "activo=?\r\n"
					+ "WHERE ID=?");
			
			consultaPreparada.setString(1, a.getNombre());
			consultaPreparada.setString(2, a.getDocumento());
			consultaPreparada.setString(3, a.getFechaNacimiento());
			consultaPreparada.setString(4, a.getDireccion());
			consultaPreparada.setString(5, a.getLocalidad());
			consultaPreparada.setString(6, a.getCp());
			consultaPreparada.setString(7, a.getProvinciaID());
			consultaPreparada.setString(8, a.getEmail());
			consultaPreparada.setString(9, a.getTelefono());
			consultaPreparada.setString(10, a.getComunicaciones());
			consultaPreparada.setString(11, a.getFechaAlta());
			consultaPreparada.setString(12, a.getIP());
			consultaPreparada.setBoolean(13, a.isActivo());
			resultado=consultaPreparada.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la actualizacion de la persona: "
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
	public int insertarPersona(Persona a) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement(
					"insert into personas values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			

			consultaPreparada.setString(1, a.getNombre());
			consultaPreparada.setString(2, a.getDocumento());
			consultaPreparada.setString(3, a.getFechaNacimiento());
			consultaPreparada.setString(4, a.getDireccion());
			consultaPreparada.setString(5, a.getLocalidad());
			consultaPreparada.setString(6, a.getCp());
			consultaPreparada.setString(7, a.getProvinciaID());
			consultaPreparada.setString(8, a.getEmail());
			consultaPreparada.setString(9, a.getTelefono());
			consultaPreparada.setString(10, a.getComunicaciones());
			consultaPreparada.setString(11, a.getFechaAlta());
			consultaPreparada.setString(12, a.getIP());
			consultaPreparada.setBoolean(13, a.isActivo());
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

	

}
