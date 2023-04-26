<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
     <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<table class="table table-dark table-sm">
		<tr>
			<th scope="row">ID_EMPLEADO</th>
			<th scope="row">NOMBRE</th>
			<th scope="row">APELLIDO</th>
			<th scope="row">DNI</th>
			<th scope="row">EDAD</th>
			<th scope="row">ANTIGUEDAD</th>
			<th scope="row">ID_JEFE</th>
			<th scope="row">USUARIO</th>
			<th scope="row">PUESTO</th>
			
  
		<tr>
		<tr>
      	<th scope="row">${empleado.id_empleado}</th>
      	<th scope="row">${empleado.nombre}</th>
    	<th scope="row">${empleado.apellido}</th>
    	<th scope="row">${empleado.dni}</th>
    	<th scope="row">${empleado.edad}</th>
    	<th scope="row">${empleado.antiguedad}</th>
    	<th scope="row">${empleado.id_jefe}</th>
    	<th scope="row">${empleado.usuario}</th>  	
    	<th scope="row">${empleado.trabajo}</th>
    	
    	
		     
		     
		</tr>
	
</table>

<a href="Principal" class="btn btn-primary">Volver</a>


</body>
</html>