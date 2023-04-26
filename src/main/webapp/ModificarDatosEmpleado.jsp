<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="">
		<input type="text" name="id_empleado" placeholder="id_empleado"/><br>
		<input type=submit value="Buscar"/>
	</form>
	<form Action ="ModificarEmpleado" >
		<input type = "hidden" name= "id" value="${empleado.id_empleado}" >${empleado.id_empledo} <br>
		<input type="text" name="nombre"  placeholder="nombre" value="${empleado.nombre}"/><br>
		<br>
		<input type="text" name="apellido"  placeholder="apellido" value="${empleado.apellido}"/><br>
		<br>
		<input type="text" name="dni"  placeholder="dni" value="${empleado.dni}"/><br>
		<br>
		<input type="text" name="edad"  placeholder="edad" value="${empleado.edad}"/><br>
		<br>
		<input type="text" name="fecha"  placeholder="fecha" value="${empleado.fecha}"/><br>
		<br>
		<input type="text" name="id_jefe"  placeholder="id_jefe" value="${empleado.id_jefe}"/><br>
		<br>
		<input type="text" name="id_usuario"  placeholder="id_usuario" value="${empleado.usuario.id_usuario}"/><br>
		<br>
		<input type="text" name="nombre_trabajo"  placeholder="nombre_trabajo" value="${empleado.trabajo.nombre}"/><br>
		<br>
		<input type=submit value="Modificar"/>
	</form>	

</body>
</html>