<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<html>
<head>
	<title>Login Geladeira</title>
</head>
<body>
<h1>
	Login
</h1>

<c:url var="addAction" value="/compras/add" ></c:url>
<c:if test="${sessionScope.usuario_id == -1}">
	<h1><font color="red">Login ou senha inválido</font></h1>
</c:if>
<form action="./login" method="get" >
<table>
	<tr>
		<td>
			<label>Login</label>
		</td>
		<td>
			<input type="text" name="login" />
		</td> 
	</tr>
	<tr>
		<td>
			<label>Senha</label>
		</td>
		<td>
			<input  type="password" name="senha" />
		</td> 
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit"
				value="<spring:message text="Entrar"/>" />
		</td>
	</tr>
</table>	
</form>
<br>

</body>
</html>