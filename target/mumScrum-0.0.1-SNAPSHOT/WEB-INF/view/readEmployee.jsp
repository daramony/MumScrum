<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div style="margin: auto; width: 60%;">
		<form:form class="form-horizontal" modelAttribute="employee"
			action="">
			<fieldset>

				<!-- Form Name -->
				<legend>Detail Employee</legend>
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="userId">UserID:</label>
					<div class="col-md-4">
						<input id="userId" name="userId" type="text"
							class="form-control input-md" required=""
							value="${employee.userId}" readonly>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="firstName">First
						Name:</label>
					<div class="col-md-4">
						<input id="firstName" name="firstName" type="text"
							class="form-control input-md" required=""
							value="${employee.firstName}" readonly>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="lastName">Last
						Name:</label>
					<div class="col-md-4">
						<input id="lastName" name="lastName" type="text"
							class="form-control input-md" required=""
							value="${employee.lastName}" readonly>

					</div>
				</div>
				
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="email">Email:</label>
					<div class="col-md-4">
						<input id="email" name="email" type="text"
							class="form-control input-md"
							value="${employee.email}" readonly>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="address">Address:</label>
					<div class="col-md-4">
						<input id="address" name="address" type="text"
							class="form-control input-md"
							value="${employee.address}" readonly>

					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label" for="phoneNumber">Phone
						Number:</label>
					<div class="col-md-4">
						<input id="phoneNumber" name="phoneNumber" type="text"
							class="form-control input-md"
							value="${employee.phoneNumber}" readonly>

					</div>
				</div>

				<!-- Multiple Radios -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="enabled">Enable</label>
					<div class="col-md-4">
						<div class="radio">
							<label for="enabled-0"> <input type="radio" name="enabled" id="enabled-0" value="1" disabled checked >
								${employee.enabled ? "Yes" : "No"}
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
								name="employeeRole" id="employeeRoles-0" value="1" disabled ${isHR ? "checked": ""}> HR
								Admin
							</label>
						</div>
						<div class="checkbox">
							<label for="employeeRoles-1"> <input type="checkbox"
								name="employeeRole" id="employeeRoles-1" value="2" disabled ${isSM ? "checked": ""}>
								Scrum Master
							</label>
						</div>
						<div class="checkbox">
							<label for="employeeRoles-2"> <input type="checkbox"
								name="employeeRole" id="employeeRoles-2" value="3" disabled ${isDev ? "checked": ""}>
								Developer
							</label>
						</div>
						<div class="checkbox">
							<label for="employeeRoles-3"> <input type="checkbox"
								name="employeeRole" id="employeeRoles-3" value="4" disabled ${isTest ? "checked": ""}>
								Tester
							</label>
						</div>
					</div>
				</div>

				<!-- Button (Double) -->
				<div class="form-group">
					<label class="col-md-4 control-label" for="submit"></label>
					<div class="col-md-8">
						<a href="/mumScrum/employee/list" class="btn btn-primary">Back</a>
					</div>
				</div>

			</fieldset>
		</form:form>

	</div>