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

		<div style="margin: auto; width: 50%">
			<h1 class="text-center">User Stories</h1>
			<div class="alert alert-success" role="alert">
				<c:out value="${message}" />
			</div>
			<table class="table">
				<thead>
					<tr>
						<!-- <th>#</th> -->
						<th>Name</th>
						<th>Description</th>
						<th>Actions</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userStories}" var="userStory">

						<tr>
							<td><c:out value="${userStory.name}" /></td>
							<td><c:out value="${userStory.description}" /></td>
							<td style="min-width: 140px;"><a
								href="editUserStory/${userStory.id}"><button type="button"
										class="btn btn-primary">Edit</button></a> <a
								href="deleteUserStory/${userStory.id}"><button
										type="button" class="btn btn-danger">Delete</button></a></td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- /.container -->




</body>
<script type="text/javascript"
	src="/mumScrum/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/mumScrum/webjars/jquery/2.1.1/jquery.min.js"></script>
</html>