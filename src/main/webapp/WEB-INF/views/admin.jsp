<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>ADMIN</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">SBL Pharmaceuticals</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="/dbms/admin"><span
						class="glyphicon glyphicon-home"></span>Home</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="<c:url value="/j_spring_security_logout" />"><span
						class="glyphicon glyphicon-log-out"></span> Logout</a></li>
			</ul>
		</div>
	</nav>
<div class="container">
<div class="jumbotron">
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <center>
        <h2>
            Welcome to the admin page : ${user}
        </h2>
        </center>
    </c:if>
    </div>
    <h2> <a href="admin/alluser">All Clients</a></h2>
    <h2> <a href="admin/allmed">All Available Medicines</a></h2>
    <h2><a href="admin/order">All Orders</a></h2>
    <h2><a href="admin/employee">EMPLOYEES</a></h2>
    </div>
</body>
</html>
