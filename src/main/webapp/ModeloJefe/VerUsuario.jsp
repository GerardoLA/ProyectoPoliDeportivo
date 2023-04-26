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
      <th scope="col">ID__USUARIO</th>
      <th scope="col">NOMBRE</th>
      <th scope="col">CONTRASEÑA</th>
      
     
     
      <th scope="col"></th>
      
    </tr>
  </thead>
   <tbody>
    <tr>
      	<th scope="row">${usuario.id_usuario}</th>
      		<th scope="row">${usuario.nombre}</th>
      			<th scope="row">${usuario.contrasena}</th>
      	
      	
    	
    	
   
    	<td><a href="ModificarUsuarioVent?id=${empleado.id_empleado}" class="btn btn-secondary ">Modificar</a></td>
    	<td><a href="EliminarUsuario?id=${empleado.id_empleado}" class="btn btn-primary ">Eliminar</a></td>  
    </tr>

    
  </tbody>
      

    	

</table>
	<a href="VerUsuario?id=${usuario.id_usuario}" class="btn btn-primary ">Ver</a>  <a href="AltaUsuario" class="btn btn-dark">Registrar Usuario nuevo</a>
</form>


</body>
</html>