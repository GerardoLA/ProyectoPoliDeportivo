<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscribir cliente</title>
</head>
<body>
	<form  method="post">
		<input type="text" value="${dni}" name="dni" placeholder="dni cliente">
		<select name="actividad">
			<option></option>
			<c:forEach items="${actividades}" var="actividad">
				<optgroup label="${actividad.nombreActividad}">
    				<c:forEach items="${grupos}" var="grupo">
    					<c:if test="${fn:contains(grupo.id_grupo,actividad.id_actividad)}">
    						<option value="${grupo.id_grupo}">${grupo.id_grupo}</option>
    					</c:if>	
					</c:forEach>
  				</optgroup>	
			</c:forEach>
		</select>
	
		<input type="submit" value="Inscribir">
	</form>
	
</body>
</html>