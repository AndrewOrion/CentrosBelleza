<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<head>
<style>
div{
display:inline;

}
img {
width:20%;
border:20px solid grey;
border-radius:10px;
}
.titulo {
	text-align: center;
	margin:auto;
	margin-top:20px;
	margin-bottom:20px;
	display: block;
	background-color:black;
	color: white;
}
.op{
width:500px;
}
body{
background-color:#F4FEFE;
}

</style>
</head>
<html>
<body>
<div class="titulo">
<h1>Salones de Belleza</h1>
</div>
<div class="op">
	<a href="PersonasServlet"><img class="a" src="personas.png" alt="Personas" /></a>
</div>
<div class="op">
	<a href="Salones"><img class="b" src="salones.webp" alt="Salones" /></a>
</div>
<div class="op">
	<a href="ServiciosServlet"><img class="c" src="servicios.jpg" alt="Servicios" /></a>
</div>

</body>
</html>