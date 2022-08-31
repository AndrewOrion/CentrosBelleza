<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.TipoCategoriaIdDAOMySQL"%>
<%@page import="dao.TipoCategoriaIdDAO"%>
<%@page import="modelo.TipoCategoriaId"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="estilo.css">

    
    <title>Alta</title>
</head>
<body>
   <div class="titulo">
    <h1>Alta de Categoria</h1>
</div>
<%
		TipoCategoriaIdDAO listaTipoCategoriaIdDAO = new TipoCategoriaIdDAOMySQL();
		List<TipoCategoriaId> listaTipoCategoriaId = listaTipoCategoriaIdDAO.getListaTipoCategoriaId();
	%>
 <div class="formu">
        <form action="CategoriasServlet" method="post">
        <input type="hidden" name="opcion" value="insertar"/>
        <table>
        <tr>
        <td>
            <label  class="text" for="nombre">Nombre de categoría:</label></td>
        <td><input type="text" name="nombre" id="nombre"></td></tr>
        <tr>
        <td>
            <label  class="text" for="foto">Foto:</label></td>
        <td><input type="file" name="foto" id="foto"></td></tr>
        <tr>
          <td>
            <label class="text" for="tipoCategoriaId">Tipo de Categoría:</label>
           </td>
           <td>
            <select name="tipoCategoriaId" id="tipoCategoriaId">
            <% 
				for (TipoCategoriaId p:listaTipoCategoriaId) {
			%>
                	<option value="<%= p.getId() %>"><%= p.getNombre() %></option>
            <%
				}
			%>
            </select>
     	</td>
     	</tr>
        <tr>
        <td>  
            <label  class="text" for="padre">Padre:</label></td>
        <td><input type="checkbox" name="padre" id="padre"></td></tr>
        <tr>
        <td>
            <label  class="text" for="activo">Activo:</label></td>
        <td><input type="checkbox" name="activo" id="activo" value="true"></td></tr>
        <tr>
        <td>
            <input type="submit"  class="boton"value="Confirmar"></td>
            <td><a href="index.jsp">Menú Principal</a></td></tr>     
    </table>
    </form>
    
</div>	
</body>
</html>