package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import dao.ServicioDAO;
import dao.ServicioDAOMySQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Servicio;


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
	boolean activo;
	String opcion;
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
		}else if (opcion.equals("modificar")) {
			modificarServicio(request,response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		opcion = request.getParameter("opcion");
		if (opcion.equals("insertar")) {
			insertarServicio(request,response);
		}else if (opcion.equals("modificar")) {
			modificarServicio(request,response);
		}
	}
		
	private void insertarServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		PrintWriter out = response.getWriter();
		
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		foto = request.getParameter("foto");
		precio = Double.parseDouble(request.getParameter("precio"));
		puntos = Integer.parseInt(request.getParameter("puntos"));		
		activo = Boolean.parseBoolean(request.getParameter("activo"));
		
	
		Servicio p= new Servicio(nombre, foto, precio, puntos,activo);
		
		ServicioDAO dao = new ServicioDAOMySQL();
		dao.insertarServicio(p); 
		
		mostrarListado(request,response);
		
	}
		
	private void mostrarFormularioAlta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServicioDAO dao = new ServicioDAOMySQL();
		List<Servicio> lista = dao.getListaServicios();
		request.setAttribute("listaServicios", lista);
		request.getRequestDispatcher("/servicios/altaServicio.jsp").forward(request,response);
			
		mostrarListado(request,response); //muestro la lista de nuevo
			
		}
/*	private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("ID"); 
		
		PersonaDAO dao = new PersonaDAOMySQL();
		
		
		Persona persona = dao.getPersona(id);
		request.setAttribute("persona",persona);	
		request.getRequestDispatcher("/personas/editarPersona.jsp").forward(request, response);
	}*/
	
	
	
	
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
	
    private void modificarServicio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		nombre = request.getParameter("nombre");
		foto = request.getParameter("foto");
		precio = Double.parseDouble(request.getParameter("precio"));
		puntos = Integer.parseInt(request.getParameter("puntos"));		
		activo = Boolean.parseBoolean(request.getParameter("activo"));
		
		Servicio servicio = new Servicio(nombre, foto, precio,puntos,activo);
		
		ServicioDAO dao = new ServicioDAOMySQL();
		dao.modificarServicio(servicio);
		mostrarListado(request, response);
		
	}
    
   
	
}
