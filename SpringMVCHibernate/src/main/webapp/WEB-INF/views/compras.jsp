<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<html>
<head>
	<title>Compras</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Adicionar Compra
</h1>

<c:url var="addAction" value="/compras/add" ></c:url>

<form:form action="${addAction}" commandName="compra">
<table>
	<tr>
		<td>
			<form:label path="mercado">
				<spring:message text="Mercado"/>
			</form:label>
		</td>
		<td>
			<form:input path="mercado" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="data">Data da compra:</form:label>
		</td>
		<td>
			<form:input type="date" path="data" value="${data}" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit"
				value="<spring:message text="Adicionar"/>" />
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Compras realizadas</h3>
<c:if test="${!empty listCompras}">
	<table class="tg">
	<tr>
		<th >ID</th>
		<th >Mercado</th>
		<th >Data da compra</th>
		<th width="60">Apagar</th>
	</tr>
	<c:forEach items="${listCompras}" var="compra">
		<tr>
			<td>${compra.id}</td>
			<td>${compra.mercado}</td>
			<fmt:formatDate value="${compra.data}" type="date" pattern="yyyy-MM-dd" var="data" />
			<td>${data}</td>
			<td><a href="<c:url value='/compras/remove/${compra.id}' />" >Apagar</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>