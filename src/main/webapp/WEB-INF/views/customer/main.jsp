	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@page session="true"%>
<html>
<head>
<style>
button {
  width: 15%;
  background-color: #00cc66;
  color: yellow;
  padding: 14px 20px;
  margin: 8px 10px;
  border: double;
  border-radius: 4px;
  cursor: pointer;
}
</style>
<title>user</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />
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
			<c:if test="${pageContext.request.userPrincipal.name != null}">
				<li><a href="<c:url value="/j_spring_security_logout" />"><span class="glyphicon glyphicon-log-out"></span>
						LOGOUT</a></li>
						</c:if>
						
			</ul>
		</div>
	</nav>
	<br>
	<br>
	<br>
	<div class="container"> 
	<c:if test="${pageContext.request.userPrincipal.name != null}">
        <h2>
            Welcome : ${user}
        </h2>
    </c:if>
    <br>
    <br>
   
  
    <a href="user/buy" class="button" style="color:black"><button>Buy Medicines</button></a>
    <br>
    <br>
    <br>
  <a href="user/order" class="button" style="color:black"><button> My Orders</button></a>
    
    </div>
    <script src="webjars/jquery/1.11.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>