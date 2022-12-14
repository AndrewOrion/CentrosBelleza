<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.ProvinciaDAOMySQL"%>
<%@page import="dao.ProvinciaDAO"%>
<%@page import="modelo.Provincia"%>
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
    <h1>Alta de Persona</h1>
</div>
    <%
		ProvinciaDAO listaProvinciaDAO = new ProvinciaDAOMySQL();
		List<Provincia> listaProvincia = listaProvinciaDAO.getListaProvincias();
	%>
<div class="formu">
      <form action="PersonasServlet" method="post" >
      <!--   <input type="hidden" name="opcion" value="insertar"/> -->
      <table class="table table-striped">
      <tr>
      	<td>
            <label class="text" for="nombre">Nombre Completo*:</label>
        </td>
        <td>
            <input type="text" class="form-control" name="nombre" id="nombre" required>
      	</td>
      </tr>
      <tr>
      	<td> 
            <label class="text" for="documento">DNI*:</label>
        </td>
        <td>
            <input type="text" class="form-control" name="documento" id="documento"  pattern="[0-9]{8}[A-Za-z]{1}" required>
        </td>
        </tr>
        <tr>
         <td>
            <label class="text" for="fechaNacimiento">Fecha de Nacimiento:</label>
         </td>
         <td>
            <input type="date" class="form-control" name="fechaNacimiento" id="fechaNacimiento" >
      	</td>
      	</tr>
      	<tr>
      	 <td> 
            <label class="text"for="direccion">Dirección:</label>
         </td>
         <td>  
            <input type="text" class="form-control" name="direccion" id="direccion" required>
        </td>
        </tr>
        <tr>
         <td>
            <label class="text" for="localidad">Localidad:</label>
         </td>
         <td>   
            <input type="text" class="form-control" name="localidad" id="localidad" required>
        </td>
        </tr>
         <tr>
         <td>
            <label class="text" for="cp">CP:</label>
          </td>
         <td>    
            <input type="text" class="form-control" name="cp" id="cp" required>
         </td>
         </tr>
         <tr>
          <td>
            <label class="text" for="provinciaId">Provincia:</label>
           </td>
           <td>
            <select name=provinciaId id="provinciaId">
            <% 
				for (Provincia p:listaProvincia) {
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
            <label class="text" for="email">Email:</label>
        </td>
        <td>
            <input type="email" class="form-control" name="email" id="email">
       </td>
       </tr>
       <tr>
       <td>
            <label class="text" for="telefono">Teléfono:</label>
       </td>
       <td>    
            <input type="text" class="form-control" name="telefono" id="telefono">
       </td>
       </tr>
       <tr>
       <td>
            <label class="text" for="comunicaciones">Comunicaciones:</label>
       </td>
       <td>    
            <input type="text" class="form-control" name="comunicaciones" id="comunicaciones">
        </td>
        </tr>
       <tr>
       <td> 
            <label class="text" for="fechaAlta">Fecha Alta:</label>
         </td>
        <td>   
            <input type="date" class="form-control" name="fechaAlta" id="fechaAlta">
       </td>
       </tr>
       <tr>
       <td>
            <label class="text" for="ip">IP:</label>
       </td>
       <td>    
            <input type="text" class="form-control" name="ip" id="ip">
      </td>
      </tr>
      <tr>
      <td>
            <label class="text" for="activo">Activo:</label>
      </td>
      <td>
            <input type="checkbox" name="activo" id="activo" value="true">
      </td>
      <tr>
         <td>   <input type="submit" class="boton" value="Confirmar">
        </td>
        <td><a href="index.jsp">Menú Principal</a>
        </td>
      </tr>
    </table>
</form>  
</div>
</body>
</html>