package controlador;

import java.io.IOException;
import java.io.PrintWriter;

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
//@WebServlet({ "/PersonasEditServlet", "/personasEdit" })
@WebServlet(
	    name = "PersonasEditServlet", 
	    urlPatterns = {"/PersonasEditServlet"}
	)
public class PersonasEditar extends HttpServlet {
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
    public PersonasEditar() {
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
		String id = request.getParameter("id");
		
		PrintWriter out = response.getWriter();
		
		PersonaDAO pDAO = new PersonaDAOMySQL();
		Persona p = pDAO.getPersona(id);
		
		String activoEstado;
		
		nombre = p.getNombre();
		documento = p.getDocumento();
		fechaNacimiento = p.getFechaNacimiento();
		direccion = p.getDireccion();
		localidad = p.getLocalidad();
		cp = p.getCp();
		provinciaId = p.getProvinciaId();
		email = p.getEmail();
		telefono = p.getTelefono();
		comunicaciones = p.getComunicaciones();
		fechaAlta = p.getFechaAlta();
		ip = p.getIp();
		activo = p.isActivo();
		
		if(activo==true) {
			activoEstado="checked";
		}else {
			activoEstado="";
		}
		
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>CRUD de Persona - Actualizar</title>\r\n"
				+ "</head>\r\n"
				+ "<body>");
		
		out.println("<h1>Actualice Persona</h1>");
		out.println("<h2>Datos de la Persona:</h2>");
		out.println("<form action=\"PersonasModificarServlet\" method=\"post\">");
		out.println("<div>\n"
				+ "            <label for=\"id\">ID:</label>\n"
				+ "            <input type=\"text\" name=\"id\" id=\"id\" value='"+id+"' readonly>\n"
				+ "        </div>");
		out.println("<div>\n"
				+ "            <label for=\"nombre\">Nombre:</label>\n"
				+ "            <input type=\"text\" name=\"nombre\" id=\"nombre\" value='"+nombre+"'>\n"
				+ "        </div>");
		out.println("<div>\n"
				+ "            <label for=\"documento\">Documento:</label>\n"
				+ "            <input type=\"text\" name=\"documento\" id=\"documento\"  pattern=\"[0-9]{8}[A-Za-z]{1}\"  value='"+documento+"'>\n"
				+ "        </div>");
		out.println("<div>\n"
				+ "            <label for=\"direccion\">Direccion:</label>\n"
				+ "            <input type=\"text\" name=\"direccion\" id=\"direccion\" value='"+direccion+"'>\n"
				+ "        </div>");
		out.println("<div>\n"
				+ "            <label for=\"localidad\">Localidad:</label>\n"
				+ "            <input type=\"text\" name=\"localidad\" id=\"localidad\" value='"+localidad+"'>\n"
				+ "        </div>");
		out.println("<div>\n"
				+ "            <label for=\"cp\">CP:</label>\n"
				+ "            <input type=\"text\" name=\"cp\" id=\"cp\" value='"+cp+"'>\n"
				+ "        </div>");
		out.println("<div>\n"
				+ "            <label for=\"provinciaId\">Provincia:</label>\n"
				+ "            <select name=provinciaId id=\"provinciaId\">\n"
				+ "                <option value=\"1\">Montilla</option>\n"
				+ "                <option value=\"6\">Granada</option>\n"
				+ "                <option value=\"3\">Almeria</option>\n"
				+ "            </select>\n"
				+ "        </div>");
		out.println("<div>\n"
				+ "            <label for=\"email\">Email:</label>\n"
				+ "            <input type=\"email\" name=\"email\" id=\"email\" value='"+email+"'>\n"
				+ "        </div>");
		out.println("<div>\n"
				+ "            <label for=\"telefono\">Telefono:</label>\n"
				+ "            <input type=\"text\" name=\"telefono\" id=\"telefono\" pattern=\"[0-9]{8}\" value='"+telefono+"'>\n"
				+ "        </div>");
		out.println("<div>\n"
				+ "            <label for=\"comunicaciones\">Comunicaciones:</label>\n"
				+ "            <input type=\"text\" name=\"comunicaciones\" id=\"comunicaciones\" value='"+comunicaciones+"'>\n"
				+ "        </div>");
		out.println("<div>\n"
				+ "            <label for=\"fechaALta\">Fecha Alta:</label>\n"
				+ "            <input type=\"text\" name=\"fechaAlta\" id=\"fechaAlta\" value='"+fechaAlta+"'>\n"
				+ "        </div>");
		out.println("<div>\n"
				+ "            <label for=\"ip\">IP:</label>\n"
				+ "            <input type=\"text\" name=\"ip\" id=\"ip\" value='"+ip+"'>\n"
				+ "        </div>");
		out.println("<div>\n"
				+ "            <label for=\"activo\">Activo:</label>\n"
				+ "            <input type=\"checkbox\" name=\"activo\" id=\"activo\" "+activoEstado+">\n"
				+ "        </div>");
		out.println("<div>\n"
				+ "            <input type=\"submit\" value=\"Confirmar\">\n"
				+ "        </div>");
		out.println("</form>");
		out.println("<a href='index.jsp'>Volver</a>");
		
		out.println("</body>\r\n"
				+ "</html>");
		
		
		

	}
	}
