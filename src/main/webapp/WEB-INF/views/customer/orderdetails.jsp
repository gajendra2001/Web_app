<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<style>
table, th, td {
  border: 1px solid black;
  text-align:center
}
button {
  width: 15%;
  background-color: #00cc66;
  color: none;
  padding: 14px 20px;
  margin: 8px 10px;
  border: double;
  border-radius: 4px;
  cursor: pointer;
}
</style>
<head>
<title>all users</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="/dbms/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" />
<%@ page isELIgnored="false"%>
</head>

<body style="background: #ffff99">
	<nav class="navbar navbar-inverse navbar-fixed-top" style="background: #33001a !important">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">SBL Pharmaceuticals</a>
			</div>
			<ul class="nav navbar-nav">
				<li style="background: #33001a"><a href="/dbms/user"><span class="glyphicon glyphicon-home"></span>Home</a></li>
				</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value="/j_spring_security_logout" />"><span class="glyphicon glyphicon-log-out"></span>
						Logout</a></li>
			</ul>
		</div>
	</nav>
	<br>
	<br>
	<br>
	<div class="container">
	<table class="table table-striped">
	<thead class="thead-dark">
      <tr>
        <th>Med ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Qnt</th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach items="${list }" var="item">
    <tr>
    <td>${item.medid }</td>
    <td>${item.name }</td>
    <td>${item.price }</td>
    <td>${item.qnt }</td>
    
    </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<br>
<a href="/dbms/user/order" class="button" style="color:black"><button> Go Back</button></a>
</div>
	<script src="/dbms/webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="/dbms/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>