<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="initial-scale=1, maximum-scale=1">
</head>
<body>
<div class="container">
    <div style="margin: auto; width: 50%">
        <h1 class="text-center">Release</h1>
        <div class="alert alert-success" role="alert">
            <c:out value="${message}" />
        </div>
        <a href="/mumScrum/addRelease" class="btn btn-success">Add</a>
        <table class="table table-striped table-condensed">
            <thead>
            <tr>
                <!-- <th>#</th> -->
                <th>Release</th>
                <th>Release Date</th>
                <th>Actions</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${releases}" var="release">
            
                <tr>
                    <td><b><c:out value="${release.name}" /></b></td>
                    <td><c:out value="${release.releaseDate}" /></td>
                    <td style="min-width: 140px;"><a
                            href="editRelease/${release.id}"><button type="button"
                                  class="btn btn-primary">Edit</button></a> <a
                            href="deleteRelease/${release.id}"><button
                            type="button" class="btn btn-danger">Delete</button></a></td>
                    </tr>
                    <c:if test="${release.sprintSet.size()>0}">
                    <tr>
                    <td><b>List of Sprint</b></td>
                    <td></td>
                    <td></td>
                    </tr>
	                    <c:forEach items="${release.sprintSet}" var="sprint">
	                    <tr>	                    	
	                    			<td align="center"><c:out value="${sprint.name}"/></td>
	                    			<td></td>
	                    			<td></td>
	                    </tr>	                    	
	                    </c:forEach>
	                    <tr style="height:40px;"><td></td><td></td><td></td></tr>
	                    </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<!-- /.container -->
</body>
</html>