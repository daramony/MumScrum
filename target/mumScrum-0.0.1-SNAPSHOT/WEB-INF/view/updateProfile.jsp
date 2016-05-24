<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="margin: auto; width: 60%;">
		<form:form class="form-horizontal" modelAttribute="employee"
			action="/mumScrum/updateProfilePost">
			<input type="hidden" name="id" value="${employee.id}">
			<fieldset>

				<!-- Form Name -->
				<legend>Update Profile</legend>
				<form:errors path="*" cssClass="alert alert-danger" element="div" />
				<c:if test="${not empty message}">
				    <div class="alert alert-success" role="alert">${message}</div>
				</c:if>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="password">Password:</label>
					<div class="col-md-4">
						<input id="password" name="password" type="password"
							placeholder="Password" class="form-control input-md" required=""
							value="${employee.password}">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="firstName">First
						Name:</label>
					<div class="col-md-4">
						<input id="firstName" name="firstName" type="text"
							placeholder="FirstName" class="form-control input-md" required=""
							value="${employee.firstName}">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="lastName">Last
						Name:</label>
					<div class="col-md-4">
						<input id="lastName" name="lastName" type="text"
							placeholder="Last Name" class="form-control input-md" required=""
							value="${employee.lastName}">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="email">Email:</label>
					<div class="col-md-4">
						<input id="email" name="email" type="text"
							placeholder="Email" class="form-control input-md" required=""
							value="${employee.email}">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="address">Address:</label>
					<div class="col-md-4">
						<input id="address" name="address" type="text"
							placeholder="Address" class="form-control input-md"
							value="${employee.address}">

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="phoneNumber">Phone
						Number:</label>
					<div class="col-md-4">
						<input id="phoneNumber" name="phoneNumber" type="text"
							placeholder="Phone Number" class="form-control input-md"
							value="${employee.phoneNumber}">

					</div>
				</div>

				<!-- Button (Double) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-8">
						<button id="submit" name="submit" class="btn btn-success">Save</button>
						<a href="/mumScrum/welcome" class="btn btn-danger">Cancel</a>
					</div>
				</div>

			</fieldset>
		</form:form>

	</div>