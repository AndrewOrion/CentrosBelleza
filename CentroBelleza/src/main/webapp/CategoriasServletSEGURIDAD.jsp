package controlador;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.apache.tomcat.jakartaee.commons.io.IOUtils;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import dao.CategoriaDAO;
import dao.CategoriaDAOMySQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Categoria;


@WebServlet(
	    name = "CategoriasServlet", 
	    urlPatterns = {"/CategoriasServlet"}
	)
	
public class CategoriasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String id;
	String nombre;
	String foto;
	String tipoCategoriaId;
	boolean padre=false;
	boolean activo=false;
	String opcion;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//env�o parametro para listado o nuevo o eliminar...
		String opcion = request.getParameter("opcion");
		if (opcion==null || opcion.equals("listado")) {
			mostrarListado(request,response);
		} else if (opcion.equals("nuevo")) {
			mostrarFormularioAlta(request,response);
		} else if (opcion.equals("eliminar")) {
			eliminarCategoria(request,response);
		}else if (opcion.equals("editar")) {
			System.out.println(opcion);;
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		if (opcion.equals("insertar")) {
			insertarCategoria(request,response);
		}
	}
		
	private void insertarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		PrintWriter out = response.getWriter();
		
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
        
		/*
		java.sql.Blob foto=null;
		FileInputStream myStream = new FileInputStream("C:\\Users\\Andrew\\git\\CentrosBelleza\\CentroBelleza\\src\\main\\webapp\\imagenes\\"+request.getParameter("foto"));
		byte[] imageInBytes = IOUtils.toByteArray(myStream);

		try {
			foto = new javax.sql.rowset.serial.SerialBlob(imageInBytes);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	
	
		
        foto = request.getParameter("foto");
		tipoCategoriaId = request.getParameter("tipoCategoriaId");
		padre = Boolean.parseBoolean(request.getParameter("padre"));
		activo = Boolean.parseBoolean(request.getParameter("activo"));		

		
		
	//	String f = org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(imageInBytes);
		
		Categoria p= new Categoria(nombre, foto, tipoCategoriaId, padre ,activo);
		
		CategoriaDAO dao = new CategoriaDAOMySQL();
		dao.insertarCategoria(p); 
		
		mostrarListado(request,response);
		
	}
		
	private void mostrarFormularioAlta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoriaDAO dao = new CategoriaDAOMySQL();
		List<Categoria> lista = dao.getListaCategorias();
		request.setAttribute("listaCategorias", lista);
		request.getRequestDispatcher("/categorias/altaCategoria.jsp").forward(request,response);
			
		mostrarListado(request,response); //muestro la lista de nuevo
			
		}

	
	
	private void mostrarListado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CategoriaDAO dao = new CategoriaDAOMySQL();
		List <Categoria> lista = dao.getListaCategorias();//obtengo listado
		request.setAttribute("listaCategorias", lista);
		request.getRequestDispatcher("/categorias/listadoCategorias.jsp").forward(request,response);

		}

	private void eliminarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("ID"); 	
		CategoriaDAO dao = new CategoriaDAOMySQL();
		dao.eliminarCategoria(id);
		mostrarListado(request,response); //muestro la lista de nuevo
		
	}
	
    private void modificarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		nombre = request.getParameter("nombre");
		 /* java.sql.Blob foto=null;	
			FileInputStream myStream = new FileInputStream("C:\\Users\\Andrew\\git\\CentrosBelleza\\CentroBelleza\\src\\main\\webapp\\imagenes\\"+request.getParameter("cambiar"));
			byte[] imageInBytes = IOUtils.toByteArray(myStream);

			try {
				foto = new javax.sql.rowset.serial.SerialBlob(imageInBytes);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		tipoCategoriaId = request.getParameter("tipoCategoriaId");
		foto = request.getParameter("foto");
		padre = Boolean.parseBoolean(request.getParameter("padre"));		
		activo = Boolean.parseBoolean(request.getParameter("activo"));
		
		Categoria Categoria = new Categoria(nombre, foto, tipoCategoriaId,padre,activo);
		
		CategoriaDAO dao = new CategoriaDAOMySQL();
		dao.modificarCategoria(Categoria);
		mostrarListado(request, response);
		
	}
    
   
	
}

