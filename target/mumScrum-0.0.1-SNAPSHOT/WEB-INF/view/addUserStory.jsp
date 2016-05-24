<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
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

				<div class="form-group">
					<label for="sprint">Assign to Sprint</label>
					<div>
						<form:select class="form-control" id="sprint" path="sprint.id">
							<form:option value="0">Select Sprint</form:option>
							<form:options items="${sprintList }" itemLabel="name" itemValue="id"/>
						</form:select>
					</div>
				</div>

				<div class="form-group">
					<label for="developer">Assign to Developer</label>
					<div>
						<form:select class="form-control" id="developer" path="developer_id">
							<form:option value="0">Select Developer</form:option>
							<form:options items="${developerList }" itemLabel="firstName" itemValue="id"/>
						</form:select>
					</div>
				</div>

				<div class="form-group">
					<label for="tester">Assign to Tester</label>
					<div>
						<form:select class="form-control" id="tester" path="tester_id">
							<form:option value="0">Select Tester</form:option>
							<form:options items="${testerList }" itemLabel="firstName" itemValue="id"/>
						</form:select>
					</div>
				</div>

				<button type="submit" class="btn btn-default">Submit</button>
			</form:form>
		</div>
	</div>
	<!-- /.container -->