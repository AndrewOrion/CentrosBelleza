<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dao.PersonaDAOMySQL"%>
<%@page import="dao.PersonaDAO"%>
<%@page import="modelo.Persona"%>
<%@page import="java.util.List" %>
<link rel="stylesheet" type="text/css" href="estilo.css">


<h1>Listado de Personas</h1>
<%
PersonaDAO bellezaDAO = new PersonaDAOMySQL();
List<Persona> lista = bellezaDAO.getListaPersonas();

   if (lista==null || lista.size()==0) {
%>
<h2>No hay datos de personas registrados</h2>
<%
} else {
%>
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
	</tr>
	<%
	for (Persona a:lista) {
	%>
			<tr>
				<td><%=a.getID() %></td>
				<td><%=a.getNombre() %></td>
				<td><%=a.getDocumento() %></td>
				<td><%=a.getFechaNacimiento() %></td>
				<td><%=a.getDireccion() %></td>
				<td><%=a.getLocalidad() %></td>
				<td><%=a.getCp() %></td>
				<td><%=a.getProvinciaID() %></td>
				<td><%=a.getEmail() %></td>
				<td><%=a.getTelefono() %></td>
				<td><%=a.getComunicaciones() %></td>
				<td><%=a.getFechaAlta() %></td>
				<td><%=a.getIP() %></td>
				<td><%=a.isActivo() %></td>
				<td><a href="?opcion=eliminar&ID=<%=a.getID()%>">X</a></td>	
				<td><a href="?opcion=editar&ID=<%=a.getID()%>">Editar</a></td>	
			</tr>
			<%
		}
}
	%>
	
</table>
<a href="?opcion=nuevo">Insertar Persona</a>