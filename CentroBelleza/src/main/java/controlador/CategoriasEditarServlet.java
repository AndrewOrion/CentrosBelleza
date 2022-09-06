package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import dao.CategoriaDAO;
import dao.CategoriaDAOMySQL;
import dao.TipoCategoriaIdDAO;
import dao.TipoCategoriaIdDAOMySQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Categoria;
import modelo.TipoCategoriaId;


/**
 * 
 * @author Andrés Pino Gallardo
 * 
 * Implementación del Servlet CategoriasEditarServlet que muestra un formulario con los datos de la categoría
 * a editar y se envían a CategoriasMoficarServlet para su actualización
 *
 */
@MultipartConfig
@WebServlet(
	    name = "CategoriasEditarServlet", 
	    urlPatterns = {"/CategoriasEditarServlet"}
	)
public class CategoriasEditarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String id;
	String nombre;
	String foto;
	String tipoCategoriaId;
	boolean padre;
	boolean activo;
	String opcion;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriasEditarServlet() {
        super();
     
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
		String activoEstado;
		String padreEstado;
		
		PrintWriter out = response.getWriter();
		
		CategoriaDAO pDAO = new CategoriaDAOMySQL();
		Categoria p = pDAO.getCategoria(id);
				
		nombre = p.getNombre();
		foto =p.getFoto();
		tipoCategoriaId=p.getTipoCategoriaId();
		padre = p.isPadre();
		activo = p.isActivo();
		
		/**
		 * Condicional para mostrar clicado o no el checkbox, según su estado
		 */
		if(activo==true) {
			activoEstado="checked";
		}else {
			activoEstado="";
		}
		if(padre==true) {
			padreEstado="checked";
		}else {
			padreEstado="";
		}
		String estado ="";
		
		
		
		TipoCategoriaIdDAO listaTipoCategoriaIdDAO = new TipoCategoriaIdDAOMySQL();
		List<TipoCategoriaId> listaTipoCategoriaId = listaTipoCategoriaIdDAO.getListaTipoCategoriaId();
		
		/**
		 * Formulario para actualizar categoría
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

		out.println("<form action=\"CategoriasModificarServlet\" method=\"post\" >");
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
				+ "            <label class=\"text\" for=\"foto\">Foto:</label></td><td>\n"
				+ "            <input type=\"file\" name=\"foto\" id=\"foto\" value='"+foto+"'></td>\n"
				+ "        </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"tipoCategoriaId\">Tipo Categoria ID:</label></td><td>\n"
				+ "            <select name=tipoCategoriaId id=\"tipoCategoriaId\">\n");
		
		/**
		 * 
		 * Bucle for para mostrar en el desplegable la lista de tipo de categoría 
		 */
				for (TipoCategoriaId p1:listaTipoCategoriaId) {
					if(p1.getId()==tipoCategoriaId) {
						estado="selected";
					}else {
						estado="";
					}
					out.println("<option value='"+p1.getId()+"' "+estado+">"+p1.getNombre()+"</option>");
				}
				out.println("</select>\n"
				+ "    </td>    </tr>");
		out.println("<tr><td>\n"
				+ "            <label class=\"text\" for=\"padre\">Padre:</label></td><td>\n"
				+ "            <input type=\"checkbox\" name=\"padre\" id=\"padre\" "+padreEstado+"></td>\n"
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

