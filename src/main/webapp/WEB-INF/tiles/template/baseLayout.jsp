<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title><tiles:insertAttribute name="title" /></title>

<spring:url value="/resources/css/style.css" var="mainCss" />

<link rel='stylesheet' href='/mumScrum/webjars/bootstrap/3.2.0/css/bootstrap.min.css'>
<script type="text/javascript" src="/mumScrum/webjars/jquery/2.1.1/jquery.min.js"></script>
<script type="text/javascript" src="/mumScrum/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
	<!-- <script src="//code.jquery.com/jquery-1.10.2.js"></script> -->
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
	<script>
	$(function() {
		$( ".date" ).datepicker();
		$( ".date" ).datepicker( "option", "dateFormat", "yy-mm-dd" );
	});
	</script>

</head>

<body>

	<nav class="navbar navbar-default navbar-fixed-top">
		<tiles:insertAttribute name="header" />
		<!-- /.container-fluid -->
	</nav>

	<div class="container">
		<div style="margin-top: 60px;" class="header-gap"></div>
		<tiles:insertAttribute name="body" />
	</div>
	
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
	
</body>
</html>
