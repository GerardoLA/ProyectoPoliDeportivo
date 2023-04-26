<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table border=1>
			<tr>
				<th scope="row">ID</th>
				<th scope="row">DIAS</th>
				<th scope="row">HORARIOS</th>
				<th scope="row">MAXPARTIC</th>
				<th scope="row">NUMPARTIC</th>
				<th scope="row">MODIFICAR</th>
				<th scope="row">ELIMINAR</th>
			</tr>
			
			<tr>
				<td>${grupo.id_grupo}</td>
				<td>${grupo.dias }</td>
				<td>${grupo.horarios }</td>
				<td>${grupo.maxPartic }</td>
				<td>${grupo.numPartic }</td>
				<td ><a href="ModificarGrupo?id_grupo=${grupo.id_grupo}">Modificar</a></td>		
				<td><a href="EliminarGrupo?id_grupo=${grupo.id_grupo}">Eliminar</a></td>		
			</tr>
	</table>
</body>
</html>