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

	<table class="table">
  <thead>
    <tr>
      <th scope="col">ID__TRABAJO</th>
      <th scope="col">NOMBRE</th>
      <th scope="col"></th>
      
    </tr>
  </thead>
   <tbody>
  <c:forEach items="${ttrabajos}" var="trabajo">
 </c:forEach>
    <tr>
      	<th scope="row">${trabajo.id_trabajo}</th>
      	<th scope="row">${trabajo.nombre}</th>
      	
    	
 
    	<td><a href="EliminarUsuario?id=${empleado.id_empleado}" class="btn btn-primary ">Eliminar</a></td>  
    </tr>

	
	    
  </tbody>
      

    	

</table>

</body>
</html>