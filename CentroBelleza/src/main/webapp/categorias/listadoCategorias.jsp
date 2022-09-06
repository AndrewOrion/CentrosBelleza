<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="dao.CategoriaDAOMySQL"%>
<%@page import="dao.CategoriaDAO"%>
<%@page import="modelo.Categoria"%>
<%@page import="java.util.List"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.sql.Blob"%>


<!DOCTYPE html>
<html>
<head>


<link rel="stylesheet" type="text/css" href="estilo.css">

</head>
<body>
<div class="titulo">
<h1>Listado de Categorías</h1>
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
		<th>Ruta Foto</th>
		<th>Foto</th>
		<th>Tipo Categoría ID</th>
		<th>Padre</th>		
		<th>Activo</th>
		<th>Editar</th>
		<th>Eliminar</th>
	</tr>
	<%
	for (Categoria a:lista) {
		java.sql.Blob rs=null;
		System.out.println(a);
		
		%>
	
			<tr>
				<td><%=a.getId() %></td>
				<td><%=a.getNombre() %></td>
				<td><%=a.getFoto() %></td>
				<td><img width="100px" src="/CentroBelleza/<%=a.getFoto() %>"/></td>				
				<td><%=a.getTipoCategoriaId() %></td>
				<td><%=a.isPadre() %></td>
				<td><%=a.isActivo() %></td>
				<td><form action="CategoriasEditarServlet" method="post"><button type="submit" name="id" value='<%=a.getId() %>'><img src="/CentroBelleza/iconos/editar.png" alt="Editar" /></button></form></td>
				<td>
				<a href="?opcion=eliminar&ID=<%=a.getId()%>"><img class="img1" src="/CentroBelleza/iconos/eliminar.png" alt="X"/></a></td>		
	
			</tr>
		
			<%
			}
}
	%>
	</table>
<a href="?opcion=nuevo">Nueva Categoría</a><br>
<a href="index.jsp">Menú Principal</a>
</body>
</html>