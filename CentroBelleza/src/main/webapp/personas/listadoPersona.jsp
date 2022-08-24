<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dao.PersonaDAOMySQL"%>
<%@page import="dao.PersonaDAO"%>
<%@page import="modelo.Persona"%>
<%@page import="java.util.List" %>
<link rel="stylesheet" type="text/css" href="estilo.css">


<h1>Listado de Personas</h1>
<%
PersonaDAO pDAO = new PersonaDAOMySQL();
List<Persona> lista = pDAO.getListaPersonas();

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
				<td class="circulo"><a href="?opcion=editar&ID=<%=a.getId()%>">Editar</a></td>		
				<td><a href="?opcion=eliminar&ID=<%=a.getId()%>">X</a></td>
				
	
			</tr>
		
			<%
		}
}
	%>
	</table>
	

<a href="?opcion=nuevo">Insertar Persona</a>