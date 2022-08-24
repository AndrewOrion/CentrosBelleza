package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonaDAO;
import dao.PersonaDAOMySQL;
import modelo.Persona;

/**
 * Servlet implementation class PersonasEditServlet
 */
@WebServlet("PersonasEditServlet")
public class PersonasEditServlet extends HttpServlet {
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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonasEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		if (opcion.equals("modificar")) {
			modificarPersona(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		if (opcion.equals("modificar")) {
			modificarPersona(request,response);
		}
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
		
		Persona per = new Persona(nombre, documento, fechaNacimiento, direccion,
				localidad, cp, provinciaId, email, telefono,comunicaciones,fechaAlta,
				ip,activo);
		
		PersonaDAO dao1 = new PersonaDAOMySQL();
		dao1.modifPersona(per);
		
	}

}
