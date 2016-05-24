<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div id="list-employee" style="width:60%; margin: auto;">
		<h1>List Employee</h1>
		<c:if test="${not empty message}">
		    <div class="alert alert-success" role="alert">${message}</div>
		</c:if>
		<a href="/mumScrum/employee/create" class="btn btn-success">Add</a>
		<table class="table table-striped table-condensed">
			<thead>
				<tr>
					<th>ID</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${employees}" var="employee">
					<tr>
						<td>${employee.id}</td>
						<td>${employee.firstName}</td>
						<td>${employee.lastName}</td>
						<td>${employee.email}</td>
						<td>
							<a href="/mumScrum/employee/read/${employee.id}" class="btn btn-default btn-sm">Detail</a>
							<a href="/mumScrum/employee/edit/${employee.id}" class="btn btn-info btn-sm">Edit</a>
							<a href="/mumScrum/employee/delete/${employee.id}" class="btn btn-danger btn-sm">Delete</a>
						</td>
					</tr>
				</c:forEach>	
			</tbody>
		</table>
	</div>
</body>
</html>