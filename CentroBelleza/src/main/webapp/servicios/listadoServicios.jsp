<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dao.ServicioDAOMySQL"%>
<%@page import="dao.ServicioDAO"%>
<%@page import="modelo.Servicio"%>
<%@page import="java.util.List" %>


<!DOCTYPE html>
<html>
<head>


<link rel="stylesheet" type="text/css" href="estilo.css">

</head>
<body>
<h1>Listado de Servicios</h1>
<%
ServicioDAO pDAO = new ServicioDAOMySQL();
List<Servicio> lista = pDAO.getListaServicios();

   if (lista==null || lista.size()==0) {
%>
<h2>No hay datos de servicios registrados</h2>
<%
} else {
%>
<table class="estilo-tabla">
	<tr>
		<th>ID</th>
		<th>Nombre</th>
		<th>Foto</th>
		<th>Precio</th>
		<th>Puntos</th>		
		<th>Activo</th>
		<th>Editar</th>
		<th>Eliminar</th>
	</tr>
	<%
	for (Servicio a:lista) {
		System.out.println(a);
	%>
			<tr>
				<td><%=a.getId() %></td>
				<td><%=a.getNombre() %></td>
				<td><%=a.getFoto() %></td>
				<td><%=a.getPrecio() %></td>
				<td><%=a.getPuntos() %></td>
				<td><%=a.isActivo() %></td>
				<td><form action="ServiciosEditarServlet" method="post"><button type="submit" name="id" value='<%=a.getId() %>'>Actualizar</button></form></td>
				<td><a href="?opcion=eliminar&ID=<%=a.getId()%>"><img class="img1" src="https://us.123rf.com/450wm/vectora/vectora1704/vectora170401047/75817847-s%C3%ADmbolo-de-la-cruz-roja-icono-como-eliminar-eliminar-error-o-icono-de-respuesta-incorrecta.jpg" alt="X"/></a></td>		
	
			</tr>
		
			<%
			}
}
	%>
	</table>
	

<a href="?opcion=nuevo">Nuevo Servicio</a><br>
<a href="index.jsp">Menú Principal</a>
</body>
</html>