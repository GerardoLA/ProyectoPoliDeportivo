<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" >
</head>
<body>

<form action="" method="post">
<table class="table">
  <thead>
    <tr>
      <th scope="col">ID__EMPLEADO</th>
      <th scope="col">NOMBRE</th>
      <th scope="col">APELLIDO</th>
      <th scope="col">DNI</th>
      <th scope="col">EDAD</th>
     <th scope="col">ANTIG�EDAD</th>
     <th scope="col">ID_JEFE</th>
     <th scope="col">ID_USUARIO</th>
     <th scope="col">NOMBRE_TRABAJO</th>
     
     
      <th scope="col"></th>
      
    </tr>
  </thead>
   <tbody>
  <c:forEach items="${empleados}" var="empleado">
  
   <tr>
      	<th scope="row">${empleado.id_empleado}</th>
      	<th scope="row">${empleado.nombre}</th>
      	<th scope="row">${empleado.apellido}</th>
      	<th scope="row">${empleado.dni}</th>
      	<th scope="row">${empleado.edad}</th>
      	<th scope="row">${empleado.antiguedad}</th>
      	<th scope="row">${empleado.usuario.id_usuario}</th>
      	<th scope="row">${empleado.trabajo.nombre}</th>
    	
    	
   
    	<td><a href="ModificarUsuarioVent?id=${empleado.id_empleado}" class="btn btn-secondary ">Modificar</a></td>
    	<td><a href="BajaEmpleado?id=${empleado.id_empleado}" class="btn btn-primary ">Eliminar</a></td>  
    </tr>
  
 </c:forEach>
   
	
	    
  </tbody>
      

    	

</table>
	<a href="VerUsuario?id=${empleado.id_empleado}" class="btn btn-primary ">Ver</a>  <a href="AltaEmpleado" class="btn btn-dark">Registrar Empleado nuevo</a>
</form>
	
	<form action="VerEmpleado">
		<input type="text" name="idEmpleado" placeholder="id">
		<input type="submit" value="Ver" class="btn btn-secondary">
	</form>

</body>
</html>