package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import modelo.Categoria;
import utilidades.ConexionBD;

public class CategoriaDAOMySQL implements CategoriaDAO {

	
	private ConexionBD conexion;
	private Statement consulta = null;
	private PreparedStatement consultaPreparada = null;
	private ResultSet resultado = null;
	
	public CategoriaDAOMySQL() {
		conexion = new ConexionBD();
	}

	@Override
	public List<Categoria> getListaCategorias(){
		List<Categoria> listaCategorias = new ArrayList<Categoria>();
		Connection con = conexion.getConexion();
		
		try {
			consulta = con.createStatement();
			resultado = consulta.executeQuery("select * from categorias");
			while (resultado.next()) {
			
				String id = resultado.getString("id");
				String nombre = resultado.getString("nombre");
		//		Blob foto = resultado.getBlob("foto");
				String foto =resultado.getString("foto");
				String tipoCategoriaId = resultado.getString("tipoCategoriaId");
				boolean padre = resultado.getBoolean("padre");
				boolean activo = resultado.getBoolean("activo");
				
				Categoria s = new Categoria(id,nombre, foto, tipoCategoriaId , padre, activo);
				listaCategorias.add(s);
			}
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre Categorias: "+e.getMessage());
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

		return listaCategorias;
	}

	@Override
	public Categoria getCategoria(String id) {
		Connection con = conexion.getConexion();
		Categoria s = null;
		
		try {
			consultaPreparada = con.prepareStatement("select * from categorias"
					+ " where ID = ?");
			consultaPreparada.setString(1, id);
			resultado=consultaPreparada.executeQuery();
			
			// Bucle para recorrer todas las filas que devuelve la consulta
			if (resultado.next()) {
				
				
				String nombre = resultado.getString("nombre");
				String foto = resultado.getString("foto");
				String tipoCategoriaId = resultado.getString("tipoCategoriaId");
				boolean padre = resultado.getBoolean("padre");
				boolean activo = resultado.getBoolean("activo");
				
				s = new Categoria(id,nombre, foto, tipoCategoriaId, padre, activo);
				
				}
			
		} catch (SQLException e) {
			System.out.println("Error al realizar la consulta sobre la Categoria: "
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
	public int eliminarCategoria(String id) {
		Connection con = conexion.getConexion();
		int resultado=0;
		
		try {
			consultaPreparada = con.prepareStatement("DELETE FROM categorias WHERE ID = ?");
			
			consultaPreparada.setString(1, id);
			resultado=consultaPreparada.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar el borrado de Categoria: "+e.getMessage());
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
	public int insertarCategoria(Categoria a) {
		Connection con = conexion.getConexion();
		int resultado=0;
		boolean activoEstado;
		boolean padreEstado;
		if(a.isActivo()==true) {
			activoEstado=true;
		}else {
			activoEstado=false;
		}
		if(a.isPadre()==true) {
			padreEstado=true;
		}else {
			padreEstado=false;
		}
		try {
			
			consultaPreparada = con.prepareStatement(
					"insert into categorias values(?,?,?,?,?,?)");
			
			consultaPreparada.setString(1, a.getId());
			consultaPreparada.setString(2, a.getNombre());
			consultaPreparada.setString(3, a.getFoto());
			consultaPreparada.setString(4, a.getTipoCategoriaId());
			consultaPreparada.setBoolean(5, padreEstado);
			consultaPreparada.setBoolean(6, activoEstado);
			
			resultado=consultaPreparada.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al insertar Categoria: "
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
	public int modificarCategoria(Categoria Categoria) {
		Connection con = conexion.getConexion();
		PreparedStatement consultaPreparada =null;
		int resultado=0;
		try {
			consultaPreparada = con.prepareStatement("UPDATE categorias "
					+ "SET nombre=?, "
					+ "foto=?, "
					+ "tipoCategoriaId=?, "
					+ "padre=?, "
					+ "activo=? "
					+ "WHERE ID=?");
			
			consultaPreparada.setString(1, Categoria.getNombre());
			consultaPreparada.setString(2, Categoria.getFoto());
			consultaPreparada.setString(3, Categoria.getTipoCategoriaId());
			consultaPreparada.setBoolean(4, Categoria.isPadre());
			consultaPreparada.setBoolean(5, Categoria.isActivo());
			consultaPreparada.setString(6, Categoria.getId());

			resultado=consultaPreparada.executeUpdate();

		} catch (SQLException e) {
			System.out.println("Error al realizar la actualizacion de Categoria: "
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
