<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<html>
<head>
	<title>Geladeiras</title>
	<style type="text/css">
		#table-scroll {height:150px;overflow:auto;margin-top:20px;width:320}
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Adicionar Geladeira
</h1>

<c:url var="addAction" value="/geladeiras/add" ></c:url>

<form:form action="${addAction}" commandName="geladeira">
<table>
	<c:if test="${!empty geladeira.descricao}">
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
			<c:if test="${!empty geladeira.descricao}">
				<input type="submit"
					value="<spring:message text="Alterar"/>" />
			</c:if>
			<c:if test="${empty geladeira.descricao}">
				<input type="submit"
					value="<spring:message text="Adicionar"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Lista de geladeiras</h3>
<c:if test="${!empty listGeladeiras}">
	<div id="table-scroll">
		<table class="tg">
		<tr>
			<th width="80">ID</th>
			<th width="120">Descricao</th>
			<th width="60">Ver</th>
			<th width="60">Apagar</th>
		</tr>
		<c:forEach items="${listGeladeiras}" var="geladeira">
			<tr>
				<td>${geladeira.id}</td>
				<td>${geladeira.descricao}</td>
				<td><a href="<c:url value='/geladeiras/edit/${geladeira.id}' />" >Ver</a></td>
				<td><a href="<c:url value='/geladeiras/remove/${geladeira.id}' />" >Apagar</a></td>
			</tr>
		</c:forEach>
		</table>
	</div>
</c:if>
<br>
<button><a href="<c:url value='/geladeiras/exportar' />" >Exportar geladeiras</a></button>
<br>
<h3>Produtos na geladeira</h3>
<c:if test="${!empty geladeira.descricao}">
	<button><a href="<c:url value='/geladeiras/redirect/${geladeira.id}' />" >Adicionar compra</a></button>
</c:if>
<c:if test="${!empty listProdutoCompra}">
	<table class="tg">
	<tr>
		<th >Produto</th>
		<th >Tipo</th>
		<th >Marca</th>
		<th >Vencimento</th>
		<th >Mercado</th>
		<th >Adquirido em</th>
		<th width="60">Consumir</th>
	</tr>
	<c:forEach items="${listProdutoCompra}" var="produtocompra">
		<tr>
			<td>${produtocompra.produto.nome}</td>
			<td>${produtocompra.produto.tipo.descricao}</td>
			<td>${produtocompra.produto.marca.descricao}</td>
			<fmt:formatDate value="${produtocompra.datavalidade}" type="date" pattern="yyyy-MM-dd" var="datavalidade" />
			<td>${datavalidade}</td>
			<td>${produtocompra.compra.mercado.descricao}</td>
			<fmt:formatDate value="${produtocompra.compra.data}" type="date" pattern="yyyy-MM-dd" var="data" />
			<td>${data}</td>
			<c:if test="${!produtocompra.consumido}">
				<td><a href="<c:url value='/geladeiras/consumir?id=${produtocompra.id}&geladeira_id=${produtocompra.geladeira.id}' />" >Consumir</a></td>
			</c:if>
			<c:if test="${produtocompra.consumido}">
				<td>Consumido</td>
			</c:if>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>