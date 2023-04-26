<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
	    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<table class="table table-dark table-sm">
		<tr>
			<th scope="row">ID_TRABAJO</th>
			<th scope="row">NOMBRE</th>
			
  
		<tr>
		<tr>
      	<th scope="row">${trabajo.id_trabajo}</th>
      	<th scope="row">${trabajo.nombre}</th>     
		     
		</tr>
	
</table>

<a href="Principal" class="btn btn-primary">Volver</a>


</body>
</html>