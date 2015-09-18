<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Marcas</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Adicionar Marca
</h1>

<c:url var="addAction" value="/marcas/add" ></c:url>

<form:form action="${addAction}" commandName="marca">
<table>
	<c:if test="${!empty marca.descricao}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="descricao">
				<spring:message text="Nome"/>
			</form:label>
		</td>
		<td>
			<form:input path="descricao" />
		</td> 
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty marca.descricao}">
				<input type="submit"
					value="<spring:message text="Alterar"/>" />
			</c:if>
			<c:if test="${empty marca.descricao}">
				<input type="submit"
					value="<spring:message text="Adicionar"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Lita de marcas</h3>
<c:if test="${!empty listMarcas}">
	<table class="tg">
	<tr>
		<th width="80">ID</th>
		<th width="120">Descricao</th>
		<th width="60">Alterar</th>
		<th width="60">Apagar</th>
	</tr>
	<c:forEach items="${listMarcas}" var="marca">
		<tr>
			<td>${marca.id}</td>
			<td>${marca.descricao}</td>
			<td><a href="<c:url value='/marcas/edit/${marca.id}' />" >Alterar</a></td>
			<td><a href="<c:url value='/marcas/remove/${marca.id}' />" >Apagar</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>