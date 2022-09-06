package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import dao.ServicioDAO;
import dao.ServicioDAOMySQL;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Servicio;


/**
 * @author Andrés Pino Gallardo
 * 
 * Implementación del Servlet ServiciosModificarServlet que recibe del formulario de ServiciosEditarServlet los
 * datos del servicio para modificarlo.
 */
@MultipartConfig
@WebServlet(
	    name = "ServiciosModificarServlet", 
	    urlPatterns = {"/ServiciosModificarServlet"}
	)
public class ServiciosModificarServlet extends HttpServlet {
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
    public ServiciosModificarServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 * doPost recibe del formulario los datos y los guarda en variables que se muestran posteriormente
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		PrintWriter out = response.getWriter();
		id= request.getParameter("id");
		nombre = request.getParameter("nombre");
		precio = Double.parseDouble(request.getParameter("precio")); 
		puntos = Integer.parseInt(request.getParameter("puntos")); 
		activo = Boolean.parseBoolean(request.getParameter("activo"));
		foto = request.getParameter("foto");
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
				+ "    <title>CRUD de Servicio - Servicio</title>\r\n"
				+ "</head>\r\n"
				+ "<body>");
		
		out.println("<h1>Servicio modificado Correctamente</h1>");
		out.println("<h2>Datos de servicio</h2>");
		out.println("<ul>");
		out.println("<li>Id: "+id+"</li>");
		out.println("<li>Nombre: "+nombre+"</li>");
		out.println("<li>Foto: "+foto+"</li>");		
		out.println("<li>Precio: "+precio+"</li>");
		out.println("<li>Puntos: "+puntos+"</li>");
		out.println("<li>activo: "+activo+"</li>");
		out.println("</ul>");
		out.println("<a href='index.jsp'>Volver</a>");
		
		out.println("</body>\r\n"
				+ "</html>");
		foto = "\\imagenes\\"+foto;

		Servicio s = new Servicio (id, nombre, foto, precio, puntos, activo);
		/**
		 * Enviamos el objeto servicio s al método modificarServicio() que se encuentra en ServicioDAOMySQL
		 */
		ServicioDAO actualizarDAO = new ServicioDAOMySQL();
		actualizarDAO.modificarServicio(s);
		
	}

}
