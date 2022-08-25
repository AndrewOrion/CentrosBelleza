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
 
    
    <title>Alta</title>
</head>
<body>
    <h1>Alta de Persona</h1>
    <%
		ProvinciaDAO listaProvinciaDAO = new ProvinciaDAOMySQL();
		List<Provincia> listaProvincia = listaProvinciaDAO.getListaProvincias();
	%>
        <form action="PersonasServlet" method="post">
        <div>
        <input type="hidden" name="opcion" value="insertar"/>
            <label for="nombre">Nombre Completo*:</label>
            <input type="text" name="nombre" id="nombre" required>
        </div>
        <div>
            <label for="documento">DNI*:</label>
            <input type="text" name="documento" id="documento"  pattern="[0-9]{8}[A-Za-z]{1}" required>
        </div>
        <div>
            <label for="fechaNacimiento">Fecha de Nacimiento:</label>
            <input type="text" name="fechaNacimiento" id="fechaNacimiento" required>
        </div>
        <div>
            <label for="direccion">Dirección:</label>
            <input type="text" name="direccion" id="direccion" required>
        </div>
        <div>
            <label for="localidad">Localidad:</label>
            <input type="text" name="localidad" id="localidad" required>
        </div>
        <div>
            <label for="cp">CP:</label>
            <input type="text" name="cp" id="cp" required>
        </div>
         <div>
            <label for="provinciaId">Provincia:</label>
            <select name=provinciaId id="provinciaId">
            <% 
				for (Provincia p:listaProvincia) {
			%>
                	<option value="<%= p.getId() %>"><%= p.getNombre() %></option>
            <%
				}
			%>
            </select>
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="email" name="email" id="email">
        </div>
        <div>
            <label for="telefono">Teléfono:</label>
            <input type="text" name="telefono" id="telefono">
        </div>
        <div>
            <label for="comunicaciones">Comunicaciones:</label>
            <input type="text" name="comunicaciones" id="comunicaciones">
        </div>
        <div>
            <label for="fechaAlta">Fecha Alta:</label>
            <input type="text" name="fechaAlta" id="fechaAlta">
        </div>
        <div>
            <label for="ip">IP:</label>
            <input type="text" name="ip" id="ip">
        </div>
        <div>
            <label for="activo">Activo:</label>
            <input type="checkbox" name="activo" id="activo">
          </div>
        <div>
            <input type="submit" value="Confirmar">
        </div>
    </form>
	
</body>
</html>