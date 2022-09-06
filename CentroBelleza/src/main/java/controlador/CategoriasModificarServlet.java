package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.MultipartConfig;

import dao.CategoriaDAO;
import dao.CategoriaDAOMySQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Categoria;


/**
 * 
 * @author Andrés Pino Gallardo
 * 
 * Implementación del Servlet CategoriasModificarServlet que recibe del formulario de CategoriasEditarServlet los
 * datos de la categoría para modificarla.
 *
 */
@MultipartConfig
@WebServlet(
	    name = "CategoriasModificarServlet", 
	    urlPatterns = {"/CategoriasModificarServlet"}
	)
public class CategoriasModificarServlet extends HttpServlet {
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
    public CategoriasModificarServlet() {
        super();
     
    }

    /**
	 * doPost recibe del formulario los datos y los guarda en variables que se muestran posteriormente
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		id= request.getParameter("id");
		nombre = request.getParameter("nombre");
		tipoCategoriaId = request.getParameter("tipoCategoriaId");
		foto = request.getParameter("foto");
		padre = Boolean.parseBoolean(request.getParameter("activo"));
		activo = Boolean.parseBoolean(request.getParameter("activo"));
		
		boolean activo=false;
		boolean padre=false;
		System.out.println(id);
		System.out.println(nombre);
		if(request.getParameter("activo") != null) {
			activo=true;
		}
		if(request.getParameter("padre") != null) {
			padre=true;
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
				+ "    <title>CRUD de Categoría - Categoría Insertada</title>\r\n"
				+ "</head>\r\n"
				+ "<body>");
		
		out.println("<h1>Categoría modificada Correctamente</h1>");
		out.println("<h2>Datos de la Categoría</h2>");
		out.println("<ul>");
		out.println("<li>Id: "+id+"</li>");
		out.println("<li>Nombre: "+nombre+"</li>");
		out.println("<li>Foto: "+foto+"</li>");
		out.println("<li>Tipo Categoría: "+tipoCategoriaId+"</li>");
		out.println("<li>activo: "+padre+"</li>");	
		out.println("<li>activo: "+activo+"</li>");
		out.println("</ul>");
		out.println("<a href='index.jsp'>Volver</a>");
		
		out.println("</body>\r\n"
				+ "</html>");
		foto = "\\imagenes\\"+foto;
		Categoria p = new Categoria(id, nombre, foto, tipoCategoriaId, padre,activo);
		
		/**
		 * Enviamos el objeto persona p al método modificarPersona() que se encuentra en PersonaDAOMySQL
		 */
		CategoriaDAO actualizarDAO = new CategoriaDAOMySQL();
		actualizarDAO.modificarCategoria(p);
		
		

	}

}
