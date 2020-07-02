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
		<form:form method="post" modelAttribute="employee"
			action="addemployee" class="form-inline">
						<h2>Add Employee</h2>	
				
			<div class="form-group">
				<label for="">EMPLOYEE Id</label> <br>
				<form:input type="number" class="form-control" path="empid"/>
				<form:errors path="empid" />
				<p><font color="red">Should be different from existing medid</font></p>
			</div>
			<br>
		
			<div class="form-group">
				<label for="">EMPLOYEE NAME</label> <br>
				<form:input type="text" class="form-control" path="empname"
					placeholder="name" />
				<form:errors path="empname" />
			</div>
			<br>
			<br>
			<div class="form-group">
				<label for="">DESIGNATION</label> <br>
				<form:input path="desig" type="text" class="form-control"
					placeholder="designation" />
				<form:errors path="desig" />
			</div>
			<br>
			<br>
			<div class="form-group">

				<label for="">Email</label> <br>
				<form:input path="email" type="text" class="form-control" placeholder="Email" />
				<!-- bind to user.name-->
				<form:errors path="email" />
			</div>
			<br>
			<br>
			<div class="form-group">
				<label for="">PHONE</label> <br>
				<form:input path="phone" type="text" class="form-control" />
				<!-- bind to user.name-->
				<form:errors path="phone" />
			</div>
			<br>
			<br>
			<div class="form-group">
				<label for="">SALARY</label> <br>
				<form:input path="salary" type="text" class="form-control"/>
				<form:errors path="salary" />
			</div>

			<button type="submit" class="btn btn-primary">Submit</button>


		</form:form>
	</div>

	<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>