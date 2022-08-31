<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dao.CategoriaDAOMySQL"%>
<%@page import="dao.CategoriaDAO"%>
<%@page import="modelo.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="org.apache.tomcat.jakartaee.commons.io.IOUtils"%>
<%@page import="java.sql.Blob"%>


<!DOCTYPE html>
<html>
<head>


<link rel="stylesheet" type="text/css" href="estilo.css">

</head>
<body>
<div class="titulo">
<h1>Listado de Categor�as</h1>
</div>
<%
CategoriaDAO pDAO = new CategoriaDAOMySQL();
List<Categoria> lista = pDAO.getListaCategorias();

   if (lista==null || lista.size()==0) {
%><div>
<h2>No hay datos de categorias registrados</h2></div>
<%
} else {
%>
<table class="estilo-tabla">
	<tr>
		<th>ID</th>
		<th>Nombre</th>
		<th>Foto</th>
		<th>Tipo Categor�a ID</th>
		<th>Padre</th>		
		<th>Activo</th>
		<th>Editar</th>
		<th>Eliminar</th>
	</tr>
	<%
	for (Categoria a:lista) {
		java.sql.Blob rs=null;
		System.out.println(a);
		
		
		if(a.getFoto()!=null){
			rs=a.getFoto();
			
		} 
		byte[] imageInBytes = IOUtils.toByteArray(a.getFoto().getBinaryStream());
		String img = org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(imageInBytes);
		%>
	
			<tr>
				<td><%=a.getId() %></td>
				<td><%=a.getNombre() %></td>
				<td><img width="100px" src="data:image/jpg;base64,<%=img %>" /></td>
				<td><%=a.getTipoCategoriaId() %></td>
				<td><%=a.isPadre() %></td>
				<td><%=a.isActivo() %></td>
				<td><form action="CategoriasEditarServlet" method="post"><button type="submit" name="id" value='<%=a.getId() %>'><img src="editar.png" alt="Editar" /></button></form></td>
				<td>
				<a href="?opcion=eliminar&ID=<%=a.getId()%>"><img class="img1" src="eliminar.png" alt="X"/></a></td>		
	
			</tr>
		
			<%
			}
}
	%>
	</table>
	

<a href="?opcion=nuevo">Nueva Categor�a</a><br>
<a href="index.jsp">Men� Principal</a>
</body>
</html>