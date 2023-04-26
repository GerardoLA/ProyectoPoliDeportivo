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
			<th scope="row">ID_USUARIO</th>
			<th scope="row">NOMBRE</th>
			<th scope="row">CONTRASENA</th>
			
  
		<tr>
		<tr>
      	<th scope="row">${usuario.id_usuario}</th>
      	<th scope="row">${usuario.nombre}</th>
    	<th scope="row">${usuario.contrasena}</th>
    	
		     
		     
		</tr>
	
</table>

<a href="Principal" class="btn btn-primary">Volver</a>


</body>
</html>