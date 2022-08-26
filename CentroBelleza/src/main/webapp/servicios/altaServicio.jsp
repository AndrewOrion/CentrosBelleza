<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <h1>Alta de Servicio</h1>
 
        <form action="ServiciosServlet" method="post">
        <div>
        <input type="hidden" name="opcion" value="insertar"/>
            <label for="nombre">Nombre del servicio:</label>
            <input type="text" name="nombre" id="nombre">
        </div>
         <div>
            <label for="foto">Foto:</label>
            <input type="text" name="foto" id="foto">
         </div>
          <div>
            <label for="precio">Precio:</label>
            <input type="number" name="precio" id="precio">
          </div>
        <div>
            <label for="puntos">Puntos:</label>
            <input type="number" name="puntos" id="puntos">
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