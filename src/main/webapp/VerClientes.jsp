<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clientes</title>
</head>
<body>
	<table border=1>
		<tr>
			<th scope="row">DNI</th>
			<th scope="row">NOMBRE</th>
			<th scope="row">APELLIDO</th>
			<th scope="row">TELEFONO</th>
			<th scope="row">MAIL</th>
			<th scope="row">ANTIGUEDAD</th>
			<th scope="row">INSCRIBIR</th>
			<th scope="row">MODIFICAR</th>
			<th scope="row">ELIMINAR</th>
		</tr>
		<c:forEach items="${clientes}" var="cliente">
			<tr>
				<td>${cliente.dni}</td>
				<td>${cliente.nombre}</td>
				<td>${cliente.apellido}</td>
				<td>${cliente.telefono}</td>
				<td>${cliente.mail}</td>
				<td>${cliente.antiguedad}</td>
				
				<td><a href="InscribirEnActividad?dni=${cliente.dni}"></a></td>
				<td><a href="ReservarPista?dni=${cliente.dni}"></a></td>
				<td ><a href="ModificarClienteForm?dni=${cliente.dni}"> <img alt="" src="https://static.vecteezy.com/system/resources/previews/019/896/650/non_2x/pencil-drawing-doodle-sketch-line-png.png" width="50"> </a></td>		
				<td><a href="EliminarCliente?dni=${cliente.dni}"> <img alt="" src="https://cdn.pixabay.com/photo/2023/03/12/10/36/forbidden-7846398_640.png" width="50"> </a></td>	
			</tr>			
		</c:forEach>
	</table>
	
	<form action="VerCliente">
		<input type="text" name="dniCliente" placeholder="dni">
		<input type="submit" value="Ver" class="btn btn-secondary">
	</form>
</body>
</html>