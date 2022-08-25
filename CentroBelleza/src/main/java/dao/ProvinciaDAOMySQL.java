package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Provincia;
import utilidades.ConexionBD;

public class ProvinciaDAOMySQL implements ProvinciaDAO {
	private ConexionBD conexion;
	private Statement consulta = null;
	private PreparedStatement consultaPreparada = null;
	private ResultSet resultado = null;
	
	public ProvinciaDAOMySQL() {
		conexion = new ConexionBD();
	}

	@Override
	public List<Provincia> getListaProvincias() {
		List<Provincia> listaProvincias = new ArrayList<Provincia>();
		Connection con = conexion.getConexion();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from provincias");
			while (resultado.next()) {
				int id = resultado.getInt("id");
				String nombre = resultado.getString("nombre");
				
				Provincia p = new Provincia(id, nombre);
				listaProvincias.add(p);
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre provincias: "+e.getMessage());
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

		
		return listaProvincias;
	}

	@Override
	public Provincia getProvincia(int id) {
		Connection con = conexion.getConexion();
		Provincia p = null;
		
		try {
			consultaPreparada = con.prepareStatement("select * from provincias"
					+ " where id = ?");
			consultaPreparada.setInt(1, id);
			resultado=consultaPreparada.executeQuery();
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			if (resultado.next()) {
				String nombre = resultado.getString("nombre");
				
				p = new Provincia(id, nombre);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre un asesor: "
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
		return p;
	}
}
