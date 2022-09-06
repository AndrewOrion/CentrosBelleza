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
 * 
 * @author Andrés Pino Gallardo
 * 
 * Implementación del Servlet PersonasModificarServlet que recibe del formulario de PersonasEditarServlet los
 * datos de la persona para modificarla.
 *
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
	int provinciaId;
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
	 * doPost recibe del formulario los datos y los guarda en variables que se muestran posteriormente
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
	
		id= request.getParameter("id");
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
		
		boolean activo=false;
		
		if(request.getParameter("activo") != null) {
			activo=true;
		}
		/**
		 * Formulario que muestra los datos actualizados
		 */
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>CRUD de Persona - Persona Insertada</title>\r\n"
				+ "</head>\r\n"
				+ "<body>");
		
		out.println("<h1>Persona modificada Correctamente</h1>");
		out.println("<h2>Datos de la Persona</h2>");
		out.println("<ul>");
		out.println("<li>Id: "+id+"</li>");
		out.println("<li>Nombre: "+nombre+"</li>");
		out.println("<li>Documento: "+documento+"</li>");
		out.println("<li>Fecha Nacimiento: "+fechaNacimiento+"</li>");		
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
		
		/**
		 * Instaciamos la persona p de clase Persona
		 */
		Persona p = new Persona(id, nombre, documento, fechaNacimiento, direccion,
				localidad, cp, provinciaId, email, telefono,comunicaciones,fechaAlta,
				ip,activo);
		
		/**
		 * Enviamos el objeto persona p al método modificarPersona() que se encuentra en PersonaDAOMySQL
		 */
		PersonaDAO actualizarDAO = new PersonaDAOMySQL();
		actualizarDAO.modificarPersona(p);
		
		//System.out.println(p);
		

	}

}
