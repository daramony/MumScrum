<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


	<div class="container">
		<div style="margin-top: 120px;" class="header-gap"></div>
		<div id="listEmployeeUserStory" style="width:60%; margin: auto;"></div>
		
		<div style="margin: auto; width: 50%">
			<h1 class="text-center">List of User Stories Assigned</h1>
			<div class="alert alert-success" role="alert">
				<c:out value="${message}" />
			</div>
			<table class="table table-striped table-condensed">
				<thead>
					<tr>
						<!-- <th>#</th> -->
						<th>UserStory</th>
						<th>Description</th>
						<th>Actions</th>

					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userStories}" var="userStory">

						<tr>
							<td><c:out value="${userStory.name}" /></td>
							<td><c:out value="${userStory.description}" /></td>
							<td>
							<security:authorize access="hasRole('ROLE_Developer')">
								<c:if test="${userStory.devEffort==null}">
									<a href="calculateEffort/${userStory.id}" class="btn btn-primary btn-sm">Estimate</a>
								</c:if>
								<c:if test="${userStory.devEffort!=null}">
									<a href="updateEffort/${userStory.id}" class="btn btn-danger btn-sm">Update</a>
								</c:if>
								</security:authorize>
								<security:authorize access="hasRole('ROLE_Tester')">
								<c:if test="${userStory.testEffort==null}">
									<a href="calculateEffort/${userStory.id}" class="btn btn-primary btn-sm">Estimate</a>
								</c:if>
								<c:if test="${userStory.testEffort!=null}">
									<a href="updateEffort/${userStory.id}" class="btn btn-danger btn-sm">Update</a>
								</c:if>
								</security:authorize>
							</td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
	
	<!-- /.container -->


</div>