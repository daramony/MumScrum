<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
    <div style="margin: auto; width: 50%">
        <h1 class="text-center">Sprint</h1>
        <div class="alert alert-success" role="alert">
            <c:out value="${message}" />
        </div>
        <a href="/mumScrum/addSprint" class="btn btn-success">Add</a>
        <table class="table">
            <thead>
            <tr>
                <!-- <th>#</th> -->
                <th>Sprint Name</th>
                <th>Start Date</th>
                <th>End Date</th>
                <th>Actions</th>

            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sprints}" var="sprint">

                <tr>
                    <td><b><c:out value="${sprint.name}" /></b></td>
                    <td><c:out value="${sprint.startDate}" /></td>
                    <td><c:out value="${sprint.endDate}" /></td>
                    <td style="min-width: 140px;"><a
                            href="editSprint/${sprint.id}"><button type="button"
                                                                         class="btn btn-primary">Edit</button></a> <a
                            href="deleteSprint/${sprint.id}"><button
                            type="button" class="btn btn-danger">Delete</button></a></td>
                </tr>
                <c:if test="${sprint.userStorySet.size()>0}">
				<tr>
                    <td><b>List of UserStory</b></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    </tr>
	                    <c:forEach items="${sprint.userStorySet}" var="userStory">
	                    <tr>	                    	
	                    			<td align="center"><c:out value="${userStory.name}"/></td>
	                    			<td></td>
	                    			<td></td>
	                    			<td></td>
	                    </tr>	                    	
	                    </c:forEach>
	                    <tr><td></td><td></td><td></td><td></td></tr>
	          </c:if>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<!-- /.container -->