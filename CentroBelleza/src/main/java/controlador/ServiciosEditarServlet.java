package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.util.List;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.ServicioDAO;
import dao.ServicioDAOMySQL;
import modelo.Provincia;
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
	Blob foto;
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
				+ " <link rel='stylesheet' type='text/css' href='estilo.css'>"
				+ "</head>\r\n"
				+ "<body>");
		
		out.println("<div class='titulo'>");

		out.println("<h1>Actualice Servicio</h1>");
		out.println("</div>");
		out.println("<div class='formu'>");
		out.println("<form action=\"ServiciosModificarServlet\" method=\"post\">");
		out.println("<table>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"id\">id:</label></td><td>\n"
				+ "            <input type=\"text\" name=\"id\" id=\"id\" "+id+"></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"nombre\">Nombre:</label></td><td>\n"
				+ "            <input type=\"text\" name=\"nombre\" id=\"nombre\" "+nombre+"></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"foto\">Foto:</label></td><td>\n"
				+ "            <input type=\"file\" name=\"foto\" id=\"foto\" "+foto+"></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"precio\">Precio:</label></td><td>\n"
				+ "            <input type=\"text\" name=\"precio\" id=\"precio\" "+precio+"></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"puntos\">Puntos:</label></td><td>\n"
				+ "            <input type=\"text\" name=\"puntos\" id=\"puntos\" "+puntos+"></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"activo\">Activo:</label></td><td>\n"
				+ "            <input type=\"checkbox\" name=\"activo\" id=\"activo\" "+activoEstado+"></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <input type=\"submit\" class=\"boton\" value=\"Confirmar\"></td>\n"
				+ "        </tr>");
		out.println("</table>");

		out.println("</form>");
		out.println("</div>");

		out.println("<a href='index.jsp'>Volver</a>");
		
		out.println("</body>\r\n"
				+ "</html>");
		

		
		
		

	}
	}
