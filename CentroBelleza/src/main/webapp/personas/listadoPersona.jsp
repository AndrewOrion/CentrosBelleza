<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dao.PersonaDAOMySQL"%>
<%@page import="dao.PersonaDAO"%>
<%@page import="modelo.Persona"%>
<%@page import="dao.ProvinciaDAOMySQL"%>
<%@page import="dao.ProvinciaDAO"%>
<%@page import="modelo.Provincia"%>
<%@page import="java.util.List" %>
<%@page import="java.io.File" %>
<%@page import="java.io.FileWriter" %>
<%@page import="java.time.LocalDateTime" %>
<%@page import="java.time.format.DateTimeFormatter" %>
<%@page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>

 <link rel="stylesheet" type="text/css" href="estilo.css">


</head>
<body>
<div class="titulo">
<h1>Listado de Personas</h1>
</div>
<%
PersonaDAO pDAO = new PersonaDAOMySQL();
List<Persona> lista = pDAO.getListaPersonas();

   if (lista==null || lista.size()==0) {
%><div>
<h2>No hay datos de personas registrados</h2></div>
<%
} else {
%>
<div>
<table class="estilo-tabla">
	<tr>
		<th>ID</th>
		<th>Nombre</th>
		<th>Documento</th>
		<th>Fecha Nacimiento</th>
		<th>Dirección</th>
		<th>Localidad</th>
		<th>CP</th>
		<th>Provincia</th>
		<th>Email</th>
		<th>Telefono</th>
		<th>Comunicaciones</th>
		<th>Fecha alta</th>
		<th>IP</th>
		<th>Activo</th>
		<th>Editar</th>
		<th>Eliminar</th>
	</tr>
	<%
	for (Persona a:lista) {
		System.out.println(a);
	%>
			<tr>
				<td><%=a.getId() %></td>
				<td><%=a.getNombre() %></td>
				<td><%=a.getDocumento() %></td>
				<td><%=a.getFechaNacimiento() %></td>
				<td><%=a.getDireccion() %></td>
				<td><%=a.getLocalidad() %></td>
				<td><%=a.getCp() %></td>
				<td><%=a.getProvinciaId() %></td>
				<td><%=a.getEmail() %></td>
				<td><%=a.getTelefono() %></td>
				<td><%=a.getComunicaciones() %></td>
				<td><%=a.getFechaAlta() %></td>
				<td><%=a.getIp() %></td>
				<td><%=a.isActivo() %></td>
				<td><form action="PersonasEditarServlet" method="post"><button type="submit" name="id" value='<%=a.getId() %>'><img src="/CentroBelleza/iconos/editar.png" alt="Editar" /></button></form></td>
				<td><a href="?opcion=eliminar&ID=<%=a.getId()%>"><img class="img1" src="/CentroBelleza/iconos/eliminar.png" alt="X"/></a></td>		
	
			</tr>
	<%	}
			
 }			

  
   	
	%>
	</table>
</div>

<a href="?opcion=nuevo">Nueva Persona</a><br>
<a href="index.jsp">Menú principal</a>
</body>
</html>