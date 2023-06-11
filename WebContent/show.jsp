<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>Pizza Order Basket Page</h3>
<c:if test="${not empty sessionScope.frmBasketList}">
	<a href="showPath">Basket</a>
</c:if>	
<hr>
<c:if test="${empty requestScope.frmForm.frmProductList}">
NO PRODUCT
</c:if>
<c:if test="${not empty requestScope.frmForm.frmProductList}">
	<c:set var="gtotal" value="0"/>
	<table border="1" width="100%">
		<tr>
			<th>Product Name</th>
			<th>Product Price</th>
		</tr>
		<c:forEach var="p" items="${requestScope.frmForm.frmProductList}">
			<tr>
				<td>${p.prodName}</td>
				<td>${p.prodPrice}</td>
			</tr>
			<c:set var="gtotal" value="${gtotal+p.prodPrice}"/>
		</c:forEach>
		<tr>
			<td colspan="2" align="right">${gtotal}</td>
		</tr>		
	</table>	
</c:if>	
<form action="orderPath" method="post">
	Enter customer name:<input type="text" name="frmCname"/><br>
	Enter customer phone:<input type="text" name="frmCph"/><br>
	<input type="hidden" name="frmGtotal" value="${gtotal}"/>
	<input type="submit" value="Order"/>
</form>