<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
		<div style="margin: auto; width: 50%">
			<h1 class="text-center">User Stories</h1>
			<div class="alert alert-success" role="alert">
				<c:out value="${message}" />
			</div>
			<a href="/mumScrum/addUserStory" class="btn btn-success">Add</a>
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