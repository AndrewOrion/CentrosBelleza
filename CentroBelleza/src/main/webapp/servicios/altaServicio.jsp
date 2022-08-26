<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <h1>Alta de Servicio</h1>
</div>
 <div class="formu">
        <form action="ServiciosServlet" method="post">
        <input type="hidden" name="opcion" value="insertar"/>
        <table>
        <tr>
        <td>
            <label  class="text" for="nombre">Nombre del servicio:</label></td>
        <td><input type="text" name="nombre" id="nombre"></td></tr>
        <tr>
        <td>
            <label  class="text" for="foto">Foto:</label></td>
        <td><input type="file" name="foto" id="foto"></td></tr>
        <tr>
        <td>
            <label  class="text" for="precio">Precio:</label></td>
        <td><input type="number" name="precio" id="precio"></td></tr>
        <tr>
        <td>  
            <label  class="text" for="puntos">Puntos:</label></td>
        <td><input type="number" name="puntos" id="puntos"></td></tr>
        <tr>
        <td>
            <label  class="text" for="activo">Activo:</label></td>
        <td><input type="checkbox" name="activo" id="activo"></td></tr>
        <tr>
        <td>
            <input type="submit"  class="boton"value="Confirmar"></td>
            <td><a href="index.jsp">Menú Principal</a></td></tr>
        
    </form>
    </table>
</div>	
</body>
</html>