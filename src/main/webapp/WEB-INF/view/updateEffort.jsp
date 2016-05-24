<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
		<div style="margin: auto; width: 40%">
			<h1 class="text-center">Update Effort</h1>
			<form:form modelAttribute="workLog" action="/mumScrum/updateEffort/${userStoryId}">
				<div class="alert alert-danger" role="alert">
					<form:errors path="*" Class="error" />
				</div>
				<div class="form-group">
				<form:hidden path="userStory.id" />
				   <label for="name">Total Hour Worked</label>
							<security:authorize access="hasRole('ROLE_Developer')">
						<form:input type="text" id="devWorkHour" name="workHourdev" path="TotalDevEffort"
								class="form-control" placeholder="Worked Hour"/>
						</security:authorize>
						<security:authorize access="hasRole('ROLE_Tester')">
						<form:input type="text" id="testWorkHour" name="workHourtest" path="TotalTestEffort"
								class="form-control" placeholder="Worked Hour"/>
						</security:authorize>

				</div>
				<div class="form-group">
					<label for="name">Remaining Working Hours</label>
					<security:authorize access="hasRole('ROLE_Developer')">
						<form:input type="text" id="devRemHour" name="devRemHour" path="remainingDevEffort"
							class="form-control" placeholder="Remaining Work Hour"/>
						</security:authorize>
						<security:authorize access="hasRole('ROLE_Tester')">
						<form:input type="text" id="testRemHour" name="testRemHour" path="remainingTestEffort"
							class="form-control" placeholder="Remaining Work Hour"/>
						</security:authorize>

				</div>

				<button type="submit" class="btn btn-default">Submit</button>
			</form:form>
		</div>
	</div>
	<!-- /.container -->