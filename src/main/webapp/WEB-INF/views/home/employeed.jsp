<%@page import="org.springframework.ui.Model"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>all users</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="/dbms/webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" />
<%@ page isELIgnored="false"%>
</head>

<body>
	<nav class="navbar navbar-inverse navbar-fixed-top" style="background: #3366cc !important">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">RANJAN DECORATORS</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a href="/dbms/admin">Home</a></li>
				
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
	<center><h3>******Welcome******	</h3></center>
	<br>
	<br>
	<div class="container">
	<table class="table table-striped">
	<thead>
      <tr>
        <th>Employee Name</th>
        <th>Designation</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Salary</th>
      </tr>
    </thead>
    <tbody>
    
    <c:forEach items="${list }" var="item">
    <tr>
    <td>${item.empname }</td>
    <td>${item.desig }</td>
    <td>${item.email }</td>
    <td>${item.phone }</td>
    <td>${item.salary }</td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</div>
<br>
<br>
<center>
<h3><a href="/dbms/">Go Back</a></h3>
</center>
	<script src="/dbms/webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="/dbms/webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>