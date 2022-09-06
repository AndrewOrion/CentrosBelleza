package controlador;

import java.io.IOException;
import java.util.List;

import dao.PersonaDAO;
import dao.PersonaDAOMySQL;
import dao.ProvinciaDAO;
import dao.ProvinciaDAOMySQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Persona;
import modelo.Provincia;
@WebServlet(
	    name = "PersonasServlet", 
	    urlPatterns = {"/PersonasServlet"}
	)
	
public class PersonasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String id;
	String nombre;
	String documento;
	String fechaNacimiento;
	String direccion;
	String localidad;
	String cp;
	int provinciaId;
	String email;
	String telefono;
	String comunicaciones;
	String fechaAlta;
	String ip;
	String opcion;
	boolean activo=false;
	
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonasServlet() {
        super();
      
    }
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//envío parametro para listado o nuevo o eliminar...
		opcion = request.getParameter("opcion");
		if (opcion==null || opcion.equals("listado")) {
			mostrarListado(request,response);
		} else if (opcion.equals("nuevo")) {
			mostrarFormularioAlta(request,response);
		} else if (opcion.equals("eliminar")) {
			eliminarPersona(request,response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		id = request.getParameter("id");
		nombre = request.getParameter("nombre");
		documento = request.getParameter("documento");
		fechaNacimiento = request.getParameter("fechaNacimiento");
		direccion = request.getParameter("direccion");
		localidad = request.getParameter("localidad");
		cp = request.getParameter("cp");
		provinciaId = Integer.parseInt(request.getParameter("provinciaId"));
		email = request.getParameter("email");
		telefono = request.getParameter("telefono");
		comunicaciones = request.getParameter("comunicaciones");
		fechaAlta = request.getParameter("fechaAlta");
		ip = request.getParameter("ip");
		
		activo = Boolean.parseBoolean(request.getParameter("activo"));		
		
		ProvinciaDAO listaProvinciaDAO = new ProvinciaDAOMySQL();
		Provincia pro= listaProvinciaDAO.getProvincia(provinciaId);
		
		Persona p = new Persona(nombre, documento, fechaNacimiento, direccion,
				localidad, cp, provinciaId, email, telefono,comunicaciones,fechaAlta,
				ip,activo);
		
		PersonaDAO dao = new PersonaDAOMySQL();
		dao.insertarPersona(p); 
		
		mostrarListado(request,response);
		
	}
		
	
	private void mostrarFormularioAlta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PersonaDAO dao = new PersonaDAOMySQL();
		List<Persona> lista = dao.getListaPersonas();
		request.setAttribute("listaPersonas", lista);
		request.getRequestDispatcher("/personas/altaPersona.jsp").forward(request,response);
			
		mostrarListado(request,response); //muestro la lista de nuevo
			
		}
	
	
	
	private void mostrarListado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PersonaDAO dao = new PersonaDAOMySQL();//instancia la persona para acceder a bd
		List <Persona> lista = dao.getListaPersonas();//obtengo listado
		request.setAttribute("listaPersonas", lista);
		request.getRequestDispatcher("/personas/listadoPersona.jsp").forward(request,response);

		}

	private void eliminarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id = request.getParameter("ID"); 	
		PersonaDAO dao = new PersonaDAOMySQL();
		dao.eliminarPersona(id);
		mostrarListado(request,response); //muestro la lista de nuevo
		
	}
	
}
