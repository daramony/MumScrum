<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="initial-scale=1, maximum-scale=1">
<link rel='stylesheet'
	href='/mumScrum/webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
</head>
<body>
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Tango MumScrum</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="addUserStory">Add User Story</a></li>
					<li><a href="listUserStory">List user Story</a></li>
					<!-- <li><a href="#contact">Contact</a></li> -->
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<div class="container">
		<div style="margin-top: 120px;" class="header-gap"></div>

		<div style="margin: auto; width: 40%">
			<h1 class="text-center">Add User Story</h1>
			<form:form modelAttribute="userStory" action="/mumScrum/addUserStory">

				
				<div class="alert alert-danger" role="alert">
					<form:errors path="*" Class="error" />
				</div>
				<div class="form-group">
					<label for="name">User Story Name</label>
					<form:input type="text" class="form-control" id="name"
						placeholder="User Story Name" path="name"
						value="${userStory.name}" />
					<form:hidden path="id" value="${userStory.id}" />
				</div>
				<div class="form-group">
					<label for="description">User Story Description</label>
					<form:textarea class="form-control" id="description"
						placeholder="User Story Description" path="description"
						value="${userStory.description}" />
				</div>
				<button type="submit" class="btn btn-default">Submit</button>
			</form:form>
		</div>
	</div>
	<!-- /.container -->




</body>
<script type="text/javascript"
	src="/mumScrum/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/mumScrum/webjars/jquery/2.1.1/jquery.min.js"></script>
</html>