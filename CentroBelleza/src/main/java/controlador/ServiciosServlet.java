package controlador;

import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

//import org.apache.tomcat.jakartaee.commons.io.IOUtils;

import dao.ServicioDAO;
import dao.ServicioDAOMySQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelo.Servicio;

@MultipartConfig
@WebServlet(
	    name = "ServiciosServlet", 
	    urlPatterns = {"/ServiciosServlet"}
	)
	
public class ServiciosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String id;
	String nombre;
	String foto;
	double precio;
	int puntos;
	boolean activo=false;
	String opcion;
	/*FOTO*/
	private String pathFiles = "\\imagenes";
	private File uploads = new File(pathFiles);
	private String[] extens = {".ico", ".png", ".jpg", ".jpeg"};
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiciosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//envío parametro para listado o nuevo o eliminar...
		String opcion = request.getParameter("opcion");
		if (opcion==null || opcion.equals("listado")) {
			mostrarListado(request,response);
		} else if (opcion.equals("nuevo")) {
			mostrarFormularioAlta(request,response);
		} else if (opcion.equals("eliminar")) {
			eliminarServicio(request,response);
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
			insertarServicio(request,response);
		}
	}
		
	private void insertarServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		PrintWriter out = response.getWriter();
		
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");		
		precio = Double.parseDouble(request.getParameter("precio"));
		puntos = Integer.parseInt(request.getParameter("puntos"));	
		foto = request.getParameter("foto");
		activo = Boolean.parseBoolean(request.getParameter("activo"));
				
		try {
			id = request.getParameter("id");
			nombre = request.getParameter("nombre");
			puntos = Integer.parseInt(request.getParameter("puntos"));
			precio = Double.parseDouble(request.getParameter("precio"));

			activo = Boolean.parseBoolean(request.getParameter("activo"));		
			
				Part part = request.getPart("foto");
				
				if(part == null) {
					System.out.println("No ha seleccionado un archivo");
					return;
				}
				
				if(isExtension(part.getSubmittedFileName(), extens)) {
					String photo = saveFile(part, uploads);
					Servicio p= new Servicio(nombre, photo, precio, puntos ,activo);
					
					ServicioDAO dao = new ServicioDAOMySQL();
					dao.insertarServicio(p); 
					
					mostrarListado(request,response);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			response.sendRedirect("index.jsp");
	}
		
	private void mostrarFormularioAlta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServicioDAO dao = new ServicioDAOMySQL();
		List<Servicio> lista = dao.getListaServicios();
		request.setAttribute("listaServicios", lista);
		request.getRequestDispatcher("/servicios/altaServicio.jsp").forward(request,response);
			
		mostrarListado(request,response); //muestro la lista de nuevo
			
		}
	
	
	private void mostrarListado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ServicioDAO dao = new ServicioDAOMySQL();
		List <Servicio> lista = dao.getListaServicios();//obtengo listado
		request.setAttribute("listaServicios", lista);
		request.getRequestDispatcher("/servicios/listadoServicios.jsp").forward(request,response);

		}

	private void eliminarServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("ID"); 	
		ServicioDAO dao = new ServicioDAOMySQL();
		dao.eliminarServicio(id);
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

