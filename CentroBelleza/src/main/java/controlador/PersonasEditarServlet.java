package controlador;

import java.io.IOException;
import java.io.PrintWriter;
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


/**
 * @author Andrés Pino Gallardo
 * 
 * Implementación del Servlet PersonasEditarServlet que muestra un formulario con los datos de la persona
 * a editar y se envían a PersonasMoficarServlet para su actualización
 */

@WebServlet(
	    name = "PersonasEditarServlet", 
	    urlPatterns = {"/PersonasEditarServlet"}
	)
public class PersonasEditarServlet extends HttpServlet {
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
    public PersonasEditarServlet() {
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
	 * Obtenemos los datos a modificar y se muestran para su edición
	 *  
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
		
		/**
		 * Condicional para mostrar clicado o no el checkbox, según su estado
		 */
		if(activo==true) {
			activoEstado="checked";
		}else {
			activoEstado="";
		}
		String estado ="";
		
		ProvinciaDAO listaProvinciaDAO = new ProvinciaDAOMySQL();
		List<Provincia> listaProvincia = listaProvinciaDAO.getListaProvincias();
		
		
		/**
		 * Formulario para actualizar persona
		 * 
		 */
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ " <link rel='stylesheet' type='text/css' href='estilo.css'>"
				+ "    <title>CRUD de Persona - Actualizar</title>\r\n"
				+ "</head>\r\n"
				+ "<body>");
		
		out.println("<div class='titulo'>");

		out.println("<h1>Actualice Persona</h1>");
		out.println("</div>");
		out.println("<div class='formu'>");

		out.println("<form action=\"PersonasModificarServlet\" method=\"post\">");
		out.println("<table>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"id\">ID:</label></td><td>\n"
				+ "            <input type=\"text\" name=\"id\" id=\"id\" value='"+id+"' readonly></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"nombre\">Nombre:</label></td><td>\n"
				+ "            <input type=\"text\" name=\"nombre\" id=\"nombre\" value='"+nombre+"'></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"documento\">Documento:</label></td><td>\n"
				+ "            <input type=\"text\" name=\"documento\" id=\"documento\"  pattern=\"[0-9]{8}[A-Za-z]{1}\"  value='"+documento+"'></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"fechaNacimiento\">Fecha Nacimiento:</label></td><td>\n"
				+ "            <input type=\"text\" name=\"fechaNacimiento\" id=\"fechaNacimiento\" value='"+fechaNacimiento+"'></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"direccion\">Direccion:</label></td><td>\n"
				+ "            <input type=\"text\" name=\"direccion\" id=\"direccion\" value='"+direccion+"'></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"localidad\">Localidad:</label></td><td>\n"
				+ "            <input type=\"text\" name=\"localidad\" id=\"localidad\" value='"+localidad+"'></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"cp\">CP:</label></td><td>\n"
				+ "            <input type=\"text\" name=\"cp\" id=\"cp\" value='"+cp+"'></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"provinciaId\">Provincia:</label></td><td>\n"
				+ "            <select name=provinciaId id=\"provinciaId\">\n");
		
		/**
		 * Bucle for para mostrar en el desplegable la lista de provincias
		 */
				for (Provincia p1:listaProvincia) {
					if(p1.getId()==provinciaId) {
						estado="selected";
					}else {
						estado="";
					}
					//System.out.println(p1.getId());
					out.println("<option value='"+p1.getId()+"' "+estado+">"+p1.getNombre()+"</option>");
				}
				out.println("</select>\n"
				+ "    </td>    </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"email\">Email:</label></td><td>\n"
				+ "            <input type=\"email\" name=\"email\" id=\"email\" value='"+email+"'></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"telefono\">Telefono:</label></td><td>\n"
				+ "            <input type=\"text\" name=\"telefono\" id=\"telefono\"  value='"+telefono+"'></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"comunicaciones\">Comunicaciones:</label></td><td>\n"
				+ "            <input type=\"text\" name=\"comunicaciones\" id=\"comunicaciones\" value='"+comunicaciones+"'></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"fechaALta\">Fecha Alta:</label></td><td>\n"
				+ "            <input type=\"text\" name=\"fechaAlta\" id=\"fechaAlta\" value='"+fechaAlta+"'></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"ip\">IP:</label></td><td>\n"
				+ "            <input type=\"text\" name=\"ip\" id=\"ip\" value='"+ip+"'></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"activo\">Activo:</label></td><td>\n"
				+ "            <input type=\"checkbox\" name=\"activo\" id=\"activo\" "+activoEstado+"></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <input type=\"submit\" class=\"boton\" value=\"Confirmar\"></td>\n"
				+ "        </tr>");
		out.println("</table>");
		out.println("</div>");

		out.println("</form>");
		out.println("<a href='index.jsp'>Volver</a>");
		
		out.println("</body>\r\n"
				+ "</html>");
		
		
		

	}
	}
