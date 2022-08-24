package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import dao.CentroDAO;
import dao.CentroDAOJDBC;
import dao.PersonaDAO;
import dao.PersonaDAOMySQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Centro;
import modelo.Persona;


/**
 * Servlet implementation class BellezaServlet
 */
@WebServlet("/PersonasServlet")

	
public class PersonasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String id;
	String nombre;
	String documento;
	String fechaNacimiento;
	String direccion;
	String localidad;
	String cp;
	String provinciaId;
	String email;
	String telefono;
	String comunicaciones;
	String fechaAlta;
	String ip;
	boolean activo;
	String opcion;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonasServlet() {
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
			eliminarPersona(request,response);
		}else if (opcion.equals("editar")) {
			System.out.println(opcion);;
		}else if (opcion.equals("modificar")) {
			modificarPersona(request,response);
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		opcion = request.getParameter("opcion");
		if (opcion.equals("insertar")) {
			insertarPersona(request,response);
		}else if (opcion.equals("modificar")) {
			modificarPersona(request,response);
		}
	}
		
	private void insertarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//ID = request.getParameter("id");
		nombre = request.getParameter("nombre");
		documento = request.getParameter("documento");
		fechaNacimiento = request.getParameter("fechaNacimiento");
		direccion = request.getParameter("direccion");
		localidad = request.getParameter("localidad");
		cp = request.getParameter("cp");
		provinciaId = request.getParameter("provinciaID");
		email = request.getParameter("email");
		telefono = request.getParameter("telefono");
		comunicaciones = request.getParameter("comunicaciones");
		fechaAlta = request.getParameter("fechaAlta");
		ip = request.getParameter("ip");
		activo = Boolean.parseBoolean(request.getParameter("activo"));
		
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
	private void mostrarFormularioEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("ID"); 
		
		PersonaDAO dao = new PersonaDAOMySQL();
		
		
		Persona persona = dao.getPersona(id);
		request.setAttribute("persona",persona);	
		request.getRequestDispatcher("/personas/editarPersona.jsp").forward(request, response);
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
	
    private void modificarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		nombre = request.getParameter("nombre");
		documento = request.getParameter("documento");
		fechaNacimiento = request.getParameter("fechaNacimiento");
		direccion = request.getParameter("direccion");
		localidad = request.getParameter("localidad");
		cp = request.getParameter("cp");
		provinciaId = request.getParameter("provinciaID");
		email = request.getParameter("email");
		telefono = request.getParameter("telefono");
		comunicaciones = request.getParameter("comunicaciones");
		fechaAlta = request.getParameter("fechaAlta");
		ip = request.getParameter("ip");
		activo = Boolean.parseBoolean(request.getParameter("activo"));
		
		Persona persona = new Persona(nombre, documento, fechaNacimiento, direccion,
				localidad, cp, provinciaId, email, telefono,comunicaciones,fechaAlta,
				ip,activo);
		
		PersonaDAO dao = new PersonaDAOMySQL();
		dao.modificarPersona(persona);
		mostrarListado(request, response);
		
	}
    
   
	
}
