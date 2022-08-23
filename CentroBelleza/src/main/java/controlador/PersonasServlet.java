package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import dao.PersonaDAO;
import dao.PersonaDAOMySQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Persona;


/**
 * Servlet implementation class BellezaServlet
 */
@WebServlet("/PersonasServlet")

	
public class PersonasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String ID;
	String nombre;
	String documento;
	String fechaNacimiento;
	String direccion;
	String localidad;
	String cp;
	String provinciaID;
	String email;
	String telefono;
	String comunicaciones;
	String fechaAlta;
	String IP;
	boolean activo;
	
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
			mostrarListado(request,response);//necesito mandarle el request y el response
		} else if (opcion.equals("nuevo")) {
			mostrarFormulario(request,response);
		} else if (opcion.equals("eliminar")) {
			eliminar(request,response);
		}else if (opcion.equals("editar")) {
			editar(request,response);
		}
		
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		//ID = request.getParameter("id");
		nombre = request.getParameter("nombre");
		documento = request.getParameter("documento");
		fechaNacimiento = request.getParameter("fechaNacimiento");
		direccion = request.getParameter("direccion");
		localidad = request.getParameter("localidad");
		cp = request.getParameter("cp");
		provinciaID = request.getParameter("provinciaID");
		email = request.getParameter("email");
		telefono = request.getParameter("telefono");
		comunicaciones = request.getParameter("comunicaciones");
		fechaAlta = request.getParameter("fechaAlta");
		IP = request.getParameter("IP");
		activo = Boolean.parseBoolean(request.getParameter("activo"));
		
		
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Datos</title>\r\n"
				+ "</head>\r\n"
				+ "<body>");
		
		out.println("<h1>Datos de Personas</h1>");
		out.println("<ul>");
		out.println("<li>Nombre: " + nombre + "</li>");
		out.println("<li>Documento: " + documento + "</li>");
		out.println("<li>Fecha de Nacimiento: " + fechaNacimiento + "</li>");
		out.println("<li>Dirección: " + direccion + "</li>");
		out.println("<li>Localidad: " + localidad + "</li>");
		out.println("<li>CP: " + cp + "</li>");
		out.println("<li>Provincia: " + provinciaID + "</li>");
		out.println("<li>Email: " + email + "</li>");
		out.println("<li>Telefono: " + telefono + "</li>");
		out.println("<li>Comunicaciones: " + comunicaciones + "</li>");
		out.println("<li>Fecha de alta: " + fechaAlta + "</li>");
		out.println("<li>IP: " + IP + "</li>");
		out.println("<li>Activo: " + activo + "</li>");
		
		out.println("</ul>");	
		out.println("</body>\r\n"
				+ "</html>");
		insertarPersona(request,response);
	}
	private void insertarPersona(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Persona p = new Persona(ID, nombre, documento, fechaNacimiento, direccion,
				localidad, cp, provinciaID, email, telefono,comunicaciones,fechaAlta,
				IP,activo);
		
		PersonaDAO dao = new PersonaDAOMySQL();
			
		dao.insertarPersona(p); 
		
	}
		


	private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PersonaDAO dao = new PersonaDAOJDBC();
			List<Persona> lista = dao.getListaPersonas();
			request.setAttribute("listaPersonas", lista);

			request.getRequestDispatcher("/personas/nuevo.jsp").forward(request,response);
			
		}

	private void mostrarListado(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PersonaDAO dao = new PersonaDAOJDBC();//instancia la persona para acceder a bd
			List <Persona> lista = dao.getListaPersonas();//obtengo listado
			request.setAttribute("listaPersonas", lista);
			request.getRequestDispatcher("/personas/listado.jsp").forward(request,response);
			
		}

	
}
