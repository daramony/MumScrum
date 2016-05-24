<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="margin: auto; width: 60%;">
		<form:form class="form-horizontal" modelAttribute="employee"
			action="/mumScrum/employee/submitCreate">
			<input type="hidden" name="id" value="${employee.id}">
			<fieldset>

				<!-- Form Name -->
				<legend>Create Employee</legend>
				
				<form:errors path="*" cssClass="alert alert-danger" element="div" />

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="userId">UserID:</label>
					<div class="col-md-4">
						<input id="userId" name="userId" type="text" placeholder="UserID"
							class="form-control input-md" required=""
							value="${employee.userId}">
					</div>
				</div>

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
				<%-- <div class="form-group">
					<label class="col-md-4 control-label" for="middleName">Middle
						Name:</label>
					<div class="col-md-4">
						<input id="middleName" name="middleName" type="text"
							placeholder="Middle Name" class="form-control input-md"
							value="${employee.middleName}">

					</div>
				</div> --%>

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
							placeholder="Email" class="form-control input-md"
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

				<!-- Multiple Radios -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="enabled">Enable</label>
					<div class="col-md-4">
						<div class="radio">
							<label for="enabled-0"> <input type="radio" name="enabled" id="enabled-0" value="1" ${employee.enabled ? "checked" : ""} >
								Yes
							</label>
						</div>
						<div class="radio">
							<label for="enabled-1"> <input type="radio" name="enabled" id="enabled-1" value="0" ${!employee.enabled ? "checked" : ""} >
								No
							</label>
						</div>
					</div>
				</div>

				

				<!-- Multiple Checkboxes -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="employeeRoles">Roles:</label>
					<div class="col-md-4">
						<div class="checkbox">
							<label for="employeeRoles-0"> <input type="checkbox"
								name="employeeRole" id="employeeRoles-0" value="1" ${isHR ? "checked": ""}> HR
								Admin
							</label>
						</div>
						<div class="checkbox">
							<label for="employeeRoles-1"> <input type="checkbox"
								name="employeeRole" id="employeeRoles-1" value="2" ${isSM ? "checked": ""}>
								Scrum Master
							</label>
						</div>
						<div class="checkbox">
							<label for="employeeRoles-2"> <input type="checkbox"
								name="employeeRole" id="employeeRoles-2" value="3" ${isDev ? "checked": ""}>
								Developer
							</label>
						</div>
						<div class="checkbox">
							<label for="employeeRoles-3"> <input type="checkbox"
								name="employeeRole" id="employeeRoles-3" value="4" ${isTest ? "checked": ""}>
								Tester
							</label>
						</div>
					</div>
				</div>

				<!-- Button (Double) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-8">
						<button id="submit" name="submit" class="btn btn-success">Save</button>
						<a href="/mumScrum/employee/list" class="btn btn-danger">Cancel</a>
					</div>
				</div>

			</fieldset>
		</form:form>

	</div>