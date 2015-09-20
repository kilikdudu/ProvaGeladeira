<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="true" %>
<html>
<head>
	<title>Compras</title>
	<style type="text/css">
		#table-scroll {height:150px;overflow:auto;margin-top:20px;width:380}
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
<input type="hidden" name="geladeira_id" value="${geladeira_id}" />
<table>
	<tr>
		<td>
			<label >
				<spring:message text="Mercado"/>
			</label>
		</td>
		<td>
			<select name="mercado_id">    
			  <c:forEach var="mercado" items="${listMercados}">
			  	<option value="${mercado.id}" ${!empty compra.data && compra.mercado.id == mercado.id ? 'selected' : ''} >${mercado.descricao}</option>    
			  </c:forEach>    
			</select> 
		</td>
		<td><a href="<c:url value='/mercados/' />" >novo mercado</a></td>
	</tr>
	<tr>
		<td>
			<form:label path="data">Data da compra:</form:label>
		</td>
		<td>
			<c:if test="${!empty compra.data}">
				<fmt:formatDate value="${compra.data}" type="date" pattern="yyyy-MM-dd" var="dataCompra" />
			</c:if>
			<form:input type="date" path="data" value="${dataCompra}" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty compra.data}">
				<input type="submit"
					value="<spring:message text="Editar"/>" />
			</c:if>
			<c:if test="${empty compra.data}">
				<input type="submit"
					value="<spring:message text="Adicionar"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<button><a href="<c:url value='/geladeiras' />" >Voltar a geladeira</a></button>
<br>
<h3>Compras realizadas</h3>
<c:if test="${!empty listCompras}">
	<div id="table-scroll">
		<table class="tg">
		<tr>
			<th width="60">ID</th>
			<th width="120">Mercado</th>
			<th width="80">Data da compra</th>
			<th width="60">Ver</th>
			<th width="60">Apagar</th>
		</tr>
		<c:forEach items="${listCompras}" var="compra">
			<tr>
				<td>${compra.id}</td>
				<td>${compra.mercado.descricao}</td>
				<fmt:formatDate value="${compra.data}" type="date" pattern="yyyy-MM-dd" var="data" />
				<td>${data}</td>
				<td><a href="<c:url value='/compras/edit?id=${compra.id}&geladeira_id=${geladeira_id}' />" >Ver</a></td>
				<td><a href="<c:url value='/compras/remove?id=${compra.id}&geladeira_id=${geladeira_id}' />" >Apagar</a></td>
			</tr>
		</c:forEach>
		</table>
	</div>
</c:if>
<br>
<c:if test="${!empty compra.data}">

	<h1>
		Adicionar produto a compra ${compra.id}
	</h1>
	
	<c:url var="addAction" value="/compras/addProduto" ></c:url>

	<form:form action="${addAction}" commandName="produtocompra">
	<input type="hidden" name="geladeira_id" value="${geladeira_id}" />
	<input type="hidden" name="compra_id" value="${compra.id}" />
	<table>
		<tr>
			<td>
				<label >
					<spring:message text="Produto"/>
				</label>
			</td>
			<td>
				<select name="produto_id">    
				  <c:forEach var="produto" items="${listProdutos}">
				  	<option value="${produto.id}" >${produto.nome} - ${produto.marca.descricao}</option>    
				  </c:forEach>    
				</select> 
			</td>
			<td><a href="<c:url value='/produtos/' />" >novo produto</a></td>
		</tr>
		<tr>
			<td>
				<form:label path="datavalidade">Data de validade:</form:label>
			</td>
			<td>
				<form:input type="date" path="datavalidade" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="<spring:message text="Adicionar"/>" />
			</td>
		</tr>
	</table>	
	</form:form>
	<br>
	<h3>Produtos na compra</h3>
	<c:if test="${!empty listProdutoscompras}">
		<table class="tg">
		<tr>
			<th >Produto</th>
			<th >Marca</th>
			<th >Tipo</th>
			<th >Validade</th>
			<th width="60">Apagar</th>
		</tr>
		<c:forEach items="${listProdutoscompras}" var="produtocompra">
			<tr>
				<td>${produtocompra.produto.nome}</td>
				<td>${produtocompra.produto.marca.descricao}</td>
				<td>${produtocompra.produto.tipo.descricao}</td>
				<fmt:formatDate value="${produtocompra.datavalidade}" type="date" pattern="yyyy-MM-dd" var="datavalidade" />
				<td>${datavalidade}</td>
				<td><a href="<c:url value='/compras/removeProduto?id=${produtocompra.id}&geladeira_id=${geladeira_id}&compra_id=${compra.id}' />" >Apagar</a></td>
			</tr>
		</c:forEach>
		</table>
	</c:if>
</c:if>
</body>
</html>