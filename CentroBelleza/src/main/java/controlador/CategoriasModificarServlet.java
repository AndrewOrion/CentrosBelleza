package controlador;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.SQLException;

import org.apache.tomcat.jakartaee.commons.io.IOUtils;

import dao.CategoriaDAO;
import dao.CategoriaDAOMySQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Categoria;


/**
 * Servlet implementation class ModificarSalon
 */
@WebServlet(
	    name = "CategoriasModificarServlet", 
	    urlPatterns = {"/CategoriasModificarServlet"}
	)
public class CategoriasModificarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String id;
	String nombre;
	Blob foto;
	String tipoCategoriaId;
	boolean padre;
	boolean activo;
	String opcion;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriasModificarServlet() {
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
		id= request.getParameter("id");
		nombre = request.getParameter("nombre");
		  java.sql.Blob foto=null;
			
				FileInputStream myStream = new FileInputStream("C:\\Users\\Andrew\\git\\CentrosBelleza\\CentroBelleza\\src\\main\\webapp\\imagenes\\"+request.getParameter("foto"));
				byte[] imageInBytes = IOUtils.toByteArray(myStream);

				try {
					foto = new javax.sql.rowset.serial.SerialBlob(imageInBytes);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		padre = Boolean.parseBoolean(request.getParameter("activo"));
		activo = Boolean.parseBoolean(request.getParameter("activo"));
		
		boolean activo=false;
		boolean padre=false;
		
		if(request.getParameter("activo") != null) {
			activo=true;
		}
		if(request.getParameter("padre") != null) {
			padre=true;
		}
		
		String img = org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(imageInBytes);

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
		out.println("<li>Foto: <img width=\"100px\" src=\'data:image/jpg;base64,"+img+"' /></li>");
		out.println("<li>activo: "+padre+"</li>");	
		out.println("<li>activo: "+activo+"</li>");
		out.println("</ul>");
		out.println("<a href='index.jsp'>Volver</a>");
		
		out.println("</body>\r\n"
				+ "</html>");
		
		Categoria p = new Categoria(id, nombre, foto, tipoCategoriaId, padre,activo);
		
		CategoriaDAO actualizarDAO = new CategoriaDAOMySQL();
		actualizarDAO.modificarCategoria(p);
		
		System.out.println(p);
		

	}

}