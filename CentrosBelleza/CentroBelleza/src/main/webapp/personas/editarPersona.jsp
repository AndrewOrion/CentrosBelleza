<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ page import="modelo.Persona" %>
<%@ page import="java.util.List" %>  
	
	<div>
		<h2>Editar Persona</h2>
	</div>	
		
<%
	/*List<Persona> listaPersonas = (List<provincias>) request.getAttribute("listaProvinciass");*/
	Persona pi = (Persona)request.getAttribute("persona");
	
%>
		
	
	<form action="PersonasServlet" method="post">
			<input type="hidden" name="opcion" value="modificar"/>
	 	<div>
            <label for="id">ID:</label>
            <input type="text" name="id" id="id" value="<%= pi.getId() %>" readonly>
        </div>
        <div>
            <label for="nombre">Nombre Completo*:</label>
            <input type="text" name="nombre" id="nombre" value="<%= pi.getNombre() %>" required>
        </div>
        <div>
            <label for="documento">DNI*:</label>
            <input type="text" name="documento" id="documento"  pattern="[0-9]{8}[A-Za-z]{1}" 
            	value="<%= pi.getDocumento() %>" required>
        </div>
        <div>
            <label for="fechaNacimiento">Fecha de Nacimiento:</label>
            <input type="text" name="fechaNacimiento" id="fechaNacimiento" 
            	value="<%= pi.getFechaNacimiento() %>" required>
        </div>
        <div>
            <label for="direccion">Dirección:</label>
            <input type="text" name="direccion" id="direccion" value="<%= pi.getDireccion() %>" required>
        </div>
        <div>
            <label for="localidad">Localidad:</label>
            <input type="text" name="localidad" id="localidad" value="<%= pi.getLocalidad() %>" required>
        </div>
        <div>
            <label for="cp">CP:</label>
            <input type="text" name="cp" id="cp" value="<%= pi.getCp() %>" required>
        </div>
        <div>
            <label for="provincia">Provincia:</label>
            <select name="provincia" id="provincia">
                <option value="Cordoba">Córdoba</option>
            </select>
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="email" name="email" id="email" value="<%= pi.getEmail() %>">
        </div>
        <div>
            <label for="telefono">Teléfono:</label>
            <input type="text" name="telefono" id="telefono" value="<%= pi.getTelefono() %>">
        </div>
        <div>
            <label for="comunicaciones">Comunicaciones:</label>
            <input type="text" name="comunicaciones" id="comunicaciones" value="<%= pi.getComunicaciones() %>">
        </div>
        <div>
            <label for="fechaAlta">Fecha Alta:</label>
            <input type="text" name="fechaAlta" id="fechaAlta" value="<%= pi.getFechaAlta() %>" >
        </div>
        <div>
            <label for="ip">IP:</label>
            <input type="text" name="ip" id="ip" value="<%= pi.getIp() %>">
        </div>
        <div>
            <label for="activo">Activo:</label>
            <input type="checkbox" name="activo" id="activo">
          </div>

        <div>
            <input class="boton" type="submit" value="Editar">
        </div>
	</form>
	
	
</body>
</html>	