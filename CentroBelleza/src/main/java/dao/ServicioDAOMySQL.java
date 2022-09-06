package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import modelo.Servicio;
import utilidades.ConexionBD;

public class ServicioDAOMySQL implements ServicioDAO {

	
	private ConexionBD conexion;
	private Statement consulta = null;
	private PreparedStatement consultaPreparada = null;
	private ResultSet resultado = null;
	
	public ServicioDAOMySQL() {
		conexion = new ConexionBD();
	}

	@Override
	public List<Servicio> getListaServicios(){
		List<Servicio> listaServicios = new ArrayList<Servicio>();
		Connection con = conexion.getConexion();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from servicios");
			while (resultado.next()) {
			
				String id = resultado.getString("id");
				String nombre = resultado.getString("nombre");
				String foto = resultado.getString("foto");
				double precio = resultado.getDouble("precio");
				int puntos = resultado.getInt("puntos");
				boolean activo = resultado.getBoolean("activo");
				
				Servicio s = new Servicio(id,nombre, foto, precio, puntos, activo);
				listaServicios.add(s);
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre servicios: "+e.getMessage());
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

		return listaServicios;
	}

	@Override
	public Servicio getServicio(String id) {
		Connection con = conexion.getConexion();
		Servicio s = null;
		
		try {
			consultaPreparada = con.prepareStatement("select * from servicios"
					+ " where ID = ?");
			consultaPreparada.setString(1, id);
			resultado=consultaPreparada.executeQuery();
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			if (resultado.next()) {
				
				String nombre = resultado.getString("nombre");
				String foto = resultado.getString("foto");
				double precio = resultado.getDouble("precio");
				int puntos = resultado.getInt("puntos");				
				boolean activo = resultado.getBoolean("activo");
				
				
				s = new Servicio(id,nombre, foto, precio, puntos, activo);
				
				}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre el servicio: "
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
		return s;
	}

	@Override
	public int eliminarServicio(String id) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("DELETE FROM servicios WHERE ID = ?");
			
			consultaPreparada.setString(1, id);
			resultado=consultaPreparada.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar el borrado de servicio: "+e.getMessage());
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
	public int insertarServicio(Servicio a) {
		Connection con = conexion.getConexion();
		int resultado=0;
		boolean activoEstado = false;
		if(a.isActivo()==true) {
			activoEstado=true;
		}
		try {
			consultaPreparada = con.prepareStatement(
					"insert into servicios values(?,?,?,?,?,?)");
			
			consultaPreparada.setString(1, a.getId());
			consultaPreparada.setString(2, a.getNombre());
			consultaPreparada.setString(3, a.getFoto());
			consultaPreparada.setDouble(4, a.getPrecio());
			consultaPreparada.setInt(5, a.getPuntos());
			consultaPreparada.setBoolean(6, activoEstado);
			
			resultado=consultaPreparada.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar servicio: "
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
	public int modificarServicio(Servicio servicio) {
		Connection con = conexion.getConexion();
		PreparedStatement consultaPreparada =null;
		int resultado=0;
		try {
			consultaPreparada = con.prepareStatement("UPDATE servicios "
					+ "SET nombre=?, "
					+ "foto=?, "
					+ "precio=?, "
					+ "puntos=?, "
					+ "activo=? "
					+ "WHERE ID=?");
			
			consultaPreparada.setString(1, servicio.getNombre());
			consultaPreparada.setString(2, servicio.getFoto());
			consultaPreparada.setDouble(3, servicio.getPrecio());
			consultaPreparada.setInt(4, servicio.getPuntos());
			consultaPreparada.setBoolean(5, servicio.isActivo());
			consultaPreparada.setString(6, servicio.getId());

			resultado=consultaPreparada.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la actualizacion de servicio: "
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
