<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<a class="navbar-brand" href="#"><strong>MUMScrum</strong></a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="/mumScrum/welcome">Dashboard</a></li>

					<security:authorize access="hasRole('ROLE_HRAdmin')">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">HRAdmin<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="<c:url value="/employee/list"/>">Employee</a></li>
							</ul>
						</li>
					</security:authorize>
					
					<security:authorize access="hasRole('ROLE_ScrumMaster')">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">ScrumMaster<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="<c:url value="/listRelease" />">Release</a></li>
								<li><a href="<c:url value="/listSprint" />">Sprint</a></li>
								<li><a href="<c:url value="/listUserStory" />">UserStory</a></li>
								<li><a href="<c:url value="/generateBD" />">Burndown Chart</a></li>
							</ul>
						</li>
					</security:authorize>
						
					<security:authorize access="hasRole('ROLE_Developer')">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Developer<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="<c:url value="/estimateEffort" />">Estimate Effort</a></li>
							</ul>
						</li>
					</security:authorize>
					
					<security:authorize access="hasRole('ROLE_Tester')">
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Tester<span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="<c:url value="/estimateEffort" />">Estimate Effort</a></li>
							</ul>
						</li>
					</security:authorize>
					

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/mumScrum/update-profile"> <span
							class="glyphicon glyphicon-user" aria-hidden="true"></span> <%= request.getUserPrincipal().getName() %>
					</a>
				</li>
				<li>
					<a href="<c:url value="/doLogout" />">
						<span class="glyphicon glyphicon-off text-danger" aria-hidden="true"></span>
						<span class="text-danger">Logout</span>
					</a>
				</li>
				
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
