package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import modelo.Provincia;
import modelo.TipoCategoriaId;
import utilidades.ConexionBD;

public class TipoCategoriaIdDAOMySQL implements TipoCategoriaIdDAO{
	private ConexionBD conexion;
	private Statement consulta = null;
	private PreparedStatement consultaPreparada = null;
	private ResultSet resultado = null;
	
	public TipoCategoriaIdDAOMySQL() {
		conexion = new ConexionBD();
	}

	@Override
	public List<TipoCategoriaId> getListaTipoCategoriaId() {
		List<TipoCategoriaId> listaTipoCategoriaId = new ArrayList<TipoCategoriaId>();
		Connection con = conexion.getConexion();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from tipocategoria");
			while (resultado.next()) {
				String id = resultado.getString("id");
				String nombre = resultado.getString("nombre");
				
				TipoCategoriaId p = new TipoCategoriaId(id, nombre);
				listaTipoCategoriaId.add(p);
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre tipo categorías: "+e.getMessage());
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

		
		return listaTipoCategoriaId;
	}

	@Override
	public TipoCategoriaId getTipoCategoriaId(String id) {
		Connection con = conexion.getConexion();
		TipoCategoriaId p = null;
		
		try {
			consultaPreparada = con.prepareStatement("select * from tipocategoria"
					+ " where id = ?");
			consultaPreparada.setString(1, id);
			resultado=consultaPreparada.executeQuery();
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			if (resultado.next()) {
				String nombre = resultado.getString("nombre");
				
				p = new TipoCategoriaId(id, nombre);
			}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre tipo categoría: "
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