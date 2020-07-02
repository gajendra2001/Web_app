<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<title>register</title>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" />
<meta http-equiv="X-UA-Compatible" content="ie=edge">
</head>
<body style="background: #ffe6e6">

	<div class="container">
		<form:form method="post"  modelAttribute="medicine"
			action="addmedicines" class="form-inline">
			<h2>Add Medicine</h2>	
			<div class="form-group">
			<br>
				<label for="">Medicine Id</label><br>
				<form:input type="number" class="form-control" min="0" path="medid"/>
				<form:errors path="medid" />
				 <p><font color="red">Should be different from existing medid</font></p>
			</div>

			<br>
			<div class="form-group">
				<label for="">Medicine Name</label> <br>
				<form:input type="text" class="form-control" path="name"
					placeholder="medicine name" />
				<form:errors path="name" />
			</div>
			<br>
			<br>
			<div class="form-group">
				<label for="">Price</label> <br>
				<form:input path="price" type="number" min="0" class="form-control" />
				<form:errors path="price" />
			</div>
			<br>
			<br>
			<div class="form-group">

				<label for="">Available Quantity</label> <br>
				<form:input path="qnt" type="number" min="0" class="form-control"/>
				<form:errors path="qnt" />
			</div>
			<br>
			<br>
		
			<button type="submit" class="btn btn-primary">Submit</button>


		</form:form>
	</div>

	<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>