<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<html>
<head>
	<title>Produtos</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Adicionar Produto
</h1>

<c:url var="addAction" value="/produtos/add" ></c:url>

<form:form action="${addAction}" commandName="produto">
<table>
	<c:if test="${!empty produto.nome}">
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
			<form:label path="nome">
				<spring:message text="Nome"/>
			</form:label>
		</td>
		<td>
			<form:input path="nome" />
		</td> 
	</tr>
	<tr>
		<td>
			<label>
				<spring:message text="Tipo"/>
			</label>
		</td>
		<td>
			<select name="tipoId">    
			  <c:forEach var="tipo" items="${listTipos}">    
			    <option value="${tipo.id}" ${!empty produto.nome && produto.tipo.id == tipo.id ? 'selected' : ''} >${tipo.descricao}</option>    
			  </c:forEach>    
			</select> 
		</td>
	</tr>
	<tr>
		<td>
			<label >
				<spring:message text="Marca"/>
			</label>
		</td>
		<td>
			<select name="marcaId">    
			  <c:forEach var="marca" items="${listMarcas}">
			  	<option value="${marca.id}" ${!empty produto.nome && produto.marca.id == marca.id ? 'selected' : ''} >${marca.descricao}</option>    
			  </c:forEach>    
			</select> 
		</td>
		<td><a href="<c:url value='/marcas/' />" >nova marca</a></td>
	</tr>
	<tr>
		<td>
			<form:label path="valor">
				<spring:message text="Valor"/>
			</form:label>
		</td>
		<td>
			<form:input type="number" path="valor" step="1" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty produto.nome}">
				<input type="submit"
					value="<spring:message text="Alterar"/>" />
			</c:if>
			<c:if test="${empty produto.nome}">
				<input type="submit"
					value="<spring:message text="Adicionar"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<button><a href="<c:url value='/compras' />" >Voltar as compras</a></button>
<br>
<h3>Lista de produtos</h3>
<c:if test="${!empty listProdutos}">
	<table class="tg">
	<tr>
		<th >ID</th>
		<th >Nome</th>
		<th >Valor</th>
		<th >Tipo</th>
		<th >Marca</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listProdutos}" var="produto">
		<tr>
			<td>${produto.id}</td>
			<td>${produto.nome}</td>
			<td>${produto.valor}</td>
			<td>${produto.tipo.descricao}</td>
			<td>${produto.marca.descricao}</td>
			<td><a href="<c:url value='/produtos/edit/${produto.id}' />" >Alterar</a></td>
			<td><a href="<c:url value='/produtos/remove/${produto.id}' />" >Apagar</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
