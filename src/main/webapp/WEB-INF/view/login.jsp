<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel='stylesheet'
	href='/mumScrum/webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<script type="text/javascript"
	src="/mumScrum/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="/mumScrum/webjars/jquery/2.1.1/jquery.min.js"></script>
</head>
<body>
	<div class="container" style="width:50%;">
		<h3 style="text-align: center;"><strong>MUM Scrum</strong></h3>
		<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
			<div class="alert alert-danger alert-dismissible" role="alert" style="margin:auto; width:50%; margin-bottom: 10px;">
				Your login attempt was not successful due to <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
			</div>
		</c:if>
	
		<form class="form-horizontal"
				action="<c:url value="/j_spring_security_check"/>" method='POST'>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
					
					<!-- Text input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="userId">UserID</label>
						<div class="col-md-4">
							<input id="userId" name="userId" type="text" placeholder="UserID"
								class="form-control input-md" required="" />
						</div>
					</div>

					<!-- Password input-->
					<div class="form-group">
						<label class="col-md-4 control-label" for="password">Password</label>
						<div class="col-md-4">
							<input id="password" name="password" type="password"
								placeholder="Password" class="form-control input-md" required="" />
						</div>
					</div>

					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label" for="login"></label>
						<div class="col-md-4">
							<button id="login" name="login" class="btn btn-primary">LogIn</button>
						</div>
					</div>
			</form>

    </div> <!-- /container -->

</body>
</html>