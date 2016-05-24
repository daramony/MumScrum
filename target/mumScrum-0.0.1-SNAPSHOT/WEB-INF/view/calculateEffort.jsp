<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


	<div class="container">
		<div style="margin-top: 120px;" class="header-gap"></div>

		<div style="margin: auto; width: 40%">
			<h1 class="text-center">Estimate Effort</h1>
			<form:form modelAttribute="userStory" action="/mumScrum/calculateEffort">				
				<div class="alert alert-danger" role="alert">
					<form:errors path="*" Class="error" />
				</div>
					
				<div class="form-group">
						<form:hidden path="id"/>
		
				  <div class="form-group">
				    <label for="exampleInputEmail1">Required Working Hour</label>
					   <security:authorize access="hasRole('ROLE_Developer')">
					        <form:input type="text" id="estimateEffort_Dev" name="estimateEffort_Dev"
											class="form-control" path="devEffort" placeholder="Estimate Effort" required="required"/>
					  </security:authorize>
					  <security:authorize access="hasRole('ROLE_Tester')">
					        <form:input type="text" id="estimateEffort_Test" name="estimateEffort_Test"
											class="form-control" path="testEffort" placeholder="Estimate Effort" required="required"/>
					   </security:authorize>
				  </div>
			
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-8">
						<button id="submit" name="submit" class="btn btn-success">Save</button>
					</div>
				</div>
			</form:form>
		</div>
	</div>`
	<!-- /.container -->



