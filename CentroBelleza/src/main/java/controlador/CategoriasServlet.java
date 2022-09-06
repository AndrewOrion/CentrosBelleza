package controlador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import dao.CategoriaDAO;
import dao.CategoriaDAOMySQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.Categoria;

/**
 * 
 * @author Andrés Pino Gallardo
 *
 *Implementación del servlet CategoriasServlet que contiene diversos métodos para
 *mostrar listado de categoriass, eliminar categoria e insertar nueva categoria
 */
@MultipartConfig
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
	/*FOTO*/
	private String pathFiles = "\\imagenes\\";
	private File uploads = new File(pathFiles);
	private String[] extens = {".ico", ".png", ".jpg", ".jpeg"};
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 *  Método doGet recibe parámetro opción del formulario y según la orden ejecuta un método u otro
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//envío parametro para listado o nuevo o eliminar...
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
	 * 
	 * Método que instancia una categoria con los datos nuevos del formulario y llama al controlador
	 * CategoriaDAOMySQL para que inserte la categoría nueva
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		if (opcion.equals("insertar")) {
			insertarCategoria(request,response);
		}
	}
	
	/**
	 * Mñetodo para insertar una nueva categoría
	 * 
	 * 
	 */
	private void insertarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		PrintWriter out = response.getWriter();
		
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
        foto = request.getParameter("foto");
		
	//try {
		tipoCategoriaId = request.getParameter("tipoCategoriaId");
		padre = Boolean.parseBoolean(request.getParameter("padre"));
		activo = Boolean.parseBoolean(request.getParameter("activo"));		
		
		/*	Part part = request.getPart("foto");
			System.out.println(part);
			if(part == null) {
				System.out.println("No ha seleccionado un archivo");
				return;
			}
			
			if(isExtension(part.getSubmittedFileName(), extens)) {
				String photo = saveFile(part, uploads);*/
				Categoria p= new Categoria(nombre, foto, tipoCategoriaId, padre ,activo);
				System.out.println(p);
				CategoriaDAO dao = new CategoriaDAOMySQL();
				dao.insertarCategoria(p); 
				
				mostrarListado(request,response);
		//	}
			
	/*	} catch (Exception e) {
			e.printStackTrace();
		}
		
		response.sendRedirect("index.jsp");*/
	}
	
	/**
	 * Método que muestra el formulario para realizar un alta nueva
	 */
	private void mostrarFormularioAlta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CategoriaDAO dao = new CategoriaDAOMySQL();
		List<Categoria> lista = dao.getListaCategorias();
		request.setAttribute("listaCategorias", lista);
		request.getRequestDispatcher("/categorias/altaCategoria.jsp").forward(request,response);
			
		mostrarListado(request,response); //muestro la lista de nuevo
			
		}

/**
 * Método que muestra el listado de categorías
 */
	
	private void mostrarListado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CategoriaDAO dao = new CategoriaDAOMySQL();
		List <Categoria> lista = dao.getListaCategorias();//obtengo listado
		request.setAttribute("listaCategorias", lista);
		request.getRequestDispatcher("/categorias/listadoCategorias.jsp").forward(request,response);

		}

/**Método que elimina una categoría
 * 
 * 
 */
	private void eliminarCategoria(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("ID"); 	
		CategoriaDAO dao = new CategoriaDAOMySQL();
		dao.eliminarCategoria(id);
		mostrarListado(request,response); //muestro la lista de nuevo
		
	}
	
   
	private String saveFile(Part part, File pathUploads) {
		String pathAbsolute = "";
		
		try {
			
			Path path = Paths.get(part.getSubmittedFileName());
			String fileName = path.getFileName().toString();
			InputStream input = part.getInputStream();
			
			if(input != null) {
				File file = new File(pathUploads, fileName);
				pathAbsolute = file.getAbsolutePath();
				Files.copy(input, file.toPath());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return pathAbsolute;
	}
	
	private boolean isExtension(String fileName, String[] extensions) {
		for(String et : extensions) {
			if(fileName.toLowerCase().endsWith(et)) {
				return true;
			}
		}
		
		return false;
	}
   
	
}

