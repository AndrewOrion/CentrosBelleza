package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.ServicioDAO;
import dao.ServicioDAOMySQL;

import modelo.Servicio;

/**
 * Servlet implementation class ServiciosEditarServlet
 */

@WebServlet(
	    name = "ServiciosEditarServlet", 
	    urlPatterns = {"/ServiciosEditarServlet"}
	)
public class ServiciosEditarServlet extends HttpServlet {
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
    public ServiciosEditarServlet() {
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
		
		ServicioDAO pDAO = new ServicioDAOMySQL();
		Servicio p = pDAO.getServicio(id);
		
		String activoEstado;
		
		nombre = p.getNombre();
		foto = p.getFoto();
		precio = p.getPrecio();
		puntos = p.getPuntos();
		activo = p.isActivo();
		
		if(activo==true) {
			activoEstado="checked";
		}else {
			activoEstado="";
		}
		String estado ="";
		
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>CRUD de Servicios - Actualizar</title>\r\n"
				+ "</head>\r\n"
				+ "<body>");
		
		out.println("<h1>Actualice Servicio</h1>");
		out.println("<h2>Datos de la Persona:</h2>");
		out.println("<form action=\"ServiciosModificarServlet\" method=\"post\">");
		out.println("<div>\n"
				+ "            <label for=\"id\">ID:</label>\n"
				+ "            <input type=\"text\" name=\"id\" id=\"id\" value='"+id+"' readonly>\n"
				+ "        </div>");
		out.println("<div>\n"
				+ "            <label for=\"nombre\">Nombre:</label>\n"
				+ "            <input type=\"text\" name=\"nombre\" id=\"nombre\" value='"+nombre+"'>\n"
				+ "        </div>");
		out.println("<div>\n"
				+ "            <label for=\"foto\">Foto:</label>\n"
				+ "            <input type=\"text\" name=\"foto\" id=\"foto\" value='"+foto+"'>\n"
				+ "        </div>");
		out.println("<div>\n"
				+ "            <label for=\"precio\">Precio:</label>\n"
				+ "            <input type=\"text\" name=\"precio\" id=\"precio\" value='"+precio+"'>\n"
				+ "        </div>");
		out.println("<div>\n"
				+ "            <label for=\"puntos\">Puntos:</label>\n"
				+ "            <input type=\"text\" name=\"puntos\" id=\"puntos\" value='"+puntos+"'>\n"
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
