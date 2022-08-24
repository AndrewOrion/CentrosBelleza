package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import dao.PersonaDAO;
import dao.PersonaDAOMySQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Persona;


/**
 * Servlet implementation class ModificarSalon
 */
@WebServlet(
	    name = "PersonasModificarServlet", 
	    urlPatterns = {"/PersonasModificarServlet"}
	)
public class PersonasModificarServlet extends HttpServlet {
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
    public PersonasModificarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		PrintWriter out = response.getWriter();
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
		
		boolean activo=false;
		
		if(request.getParameter("activo") != null) {
			activo=true;
		}
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>CRUD de Persona - Persona Insertada</title>\r\n"
				+ "</head>\r\n"
				+ "<body>");
		
		out.println("<h1>Peronsa modificada Correctamente</h1>");
		out.println("<h2>Datos de la Persona</h2>");
		out.println("<ul>");
		out.println("<li>Id: "+id+"</li>");
		out.println("<li>Nombre: "+nombre+"</li>");
		out.println("<li>Direccion: "+direccion+"</li>");
		out.println("<li>Localidad: "+localidad+"</li>");
		out.println("<li>CP: "+cp+"</li>");
		out.println("<li>provinciaId: "+provinciaId+"</li>");
		out.println("<li>Email: "+email+"</li>");
		out.println("<li>Telefono: "+telefono+"</li>");
		out.println("<li>Comunicaciones: "+comunicaciones+"</li>");
		out.println("<li>Fecha Alta: "+fechaAlta+"</li>");
		out.println("<li>IP: "+ip+"</li>");
		out.println("<li>activo: "+activo+"</li>");
		out.println("</ul>");
		out.println("<a href='index.jsp'>Volver</a>");
		
		out.println("</body>\r\n"
				+ "</html>");
		
		Persona p = new Persona(nombre, documento, fechaNacimiento, direccion,
				localidad, cp, provinciaId, email, telefono,comunicaciones,fechaAlta,
				ip,activo);
		
		PersonaDAO actualizarDAO = new PersonaDAOMySQL();
		actualizarDAO.modificarPersona(p);
		
		System.out.println(p);
	}

}
