<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dao.ServicioDAOMySQL"%>
<%@page import="dao.ServicioDAO"%>
<%@page import="modelo.Servicio"%>
<%@page import="java.util.List"%>



<!DOCTYPE html>
<html>
<head>


<link rel="stylesheet" type="text/css" href="estilo.css">

</head>
<body>
<div class="titulo">
<h1>Listado de Servicios</h1>
</div>
<%
ServicioDAO pDAO = new ServicioDAOMySQL();
List<Servicio> lista = pDAO.getListaServicios();

   if (lista==null || lista.size()==0) {
%><div>
<h2>No hay datos de servicios registrados</h2></div>
<%
} else {
%>
<table class="estilo-tabla">
	<tr>
		<th>ID</th>
		<th>Nombre</th>
		<th>Ruta Foto</th>
		<th>Foto</th>
		<th>Precio</th>
		<th>Puntos</th>		
		<th>Activo</th>
		<th>Editar</th>
		<th>Eliminar</th>
	</tr>
	<%
	for (Servicio a:lista) {
		%>
	
			<tr>
				<td><%=a.getId() %></td>
				<td><%=a.getNombre() %></td>
			<!-- 	<td><img width="100px" src="data:image/jpg;base64,<%//=img %>" /></td>-->
				<td><%=a.getFoto() %></td>
				<td><img width="100px" src="/CentroBelleza/<%=a.getFoto() %>"/></td>				
				<td><%=a.getPrecio() %></td>
				<td><%=a.getPuntos() %></td>
				<td><%=a.isActivo() %></td>
				<td><form action="ServiciosEditarServlet" method="post"><button type="submit" name="id" value='<%=a.getId() %>'><img src="/CentroBelleza/iconos/editar.png" alt="Editar" /></button></form></td>
				<td>
				<a href="?opcion=eliminar&ID=<%=a.getId()%>"><img class="img1" src="/CentroBelleza/iconos/eliminar.png" alt="X"/></a></td>		
	
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