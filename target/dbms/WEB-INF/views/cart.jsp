<%@page import="org.springframework.ui.Model"%>
<%@page import="com.ayushi.model.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="/dbms/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" />
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Items</title>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top"
		style="background: #ffcccc !important">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">RANJAN DECORATORS</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="/dbms/user"><span class="glyphicon glyphicon-home"></span>HOME</a></li>
				<li><a href="/dbms/allcat">CATEGORIES</a></li>
			</ul>
			
			<ul class="nav navbar-nav navbar-right">
			<li><a href="/dbms/buyitem/cart"><span class="glyphicon glyphicon-shopping-cart"></span>CART</a></li>
				<li><c:if test="${pageContext.request.userPrincipal.name != null}">
					 <a href="<c:url value="/j_spring_security_logout" />"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a>
				</c:if></li>
			</ul>
		</div>
	</nav>
	<br>
	<br>
	<br>
	<div class="container">
	<table class="table table-striped">
	<thead>
      <tr>
        <th>ITEM</th>
        <th>PRICE</th>
        <th>QUANTITY</th>
        <th>UPDATE</th>
        <th>SUB-TOTAL</th>
        <th>REMOVE</th>
      </tr>
    </thead>
    <tbody>

<c:forEach items="${list }" var="item">
<tr>
<td>${item.name }</td>
<td>${item.price }</td>
<td>${item.quantity }</td>
<td>
<form method ="post" action="update/${item.iid }" modelAttribute="cart" >
<input type="int" name="quantity" value="${item.quantity }" />
<input type ="submit" value="update" />
</form>
</td>
<td>${item.tprice }</td>

<td><a href="deleteitems/${item.iid }">DELETE ITEM</a></td>
</tr>

</c:forEach> 
</tbody>
</table>
<h2>TOTAL : ${total }</h2>
<form method="post" action ="place">
<input type="submit" value="place order" />
</form>
</div>
<script src="/dbms/webjars/jquery/1.11.1/jquery.min.js"></script>
<script src="/dbms/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>