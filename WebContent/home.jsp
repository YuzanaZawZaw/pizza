<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>Pizza Order Page</h3>
<c:if test="${not empty sessionScope.frmBasketList}">
	<a href="showPath">Basket</a>
</c:if>	
<hr>
<form action="homePath" method="post">
	Select Type:
		<select name="frmTypeId">
			<option value="0">SELECT</option>
			<c:forEach var="t" items="${requestScope.frmForm.frmTypeList}">
				<option value="${t.typeId}">${t.typeName}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Search"/>
</form>
<c:if test="${empty requestScope.frmForm.frmProductList}">
NO PRODUCT
</c:if>
<c:if test="${not empty requestScope.frmForm.frmProductList}">
	<table border="1" width="100%">
		<tr>
			<th>Product Name</th>
			<th>Product Price</th>
			<th></th>
		</tr>
		<c:forEach var="p" items="${requestScope.frmForm.frmProductList}">
			<tr>
				<td>${p.prodName}</td>
				<td>${p.prodPrice}</td>
				<td><a href="basketPath?frmOrderProdId=${p.prodId}">Order</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>	