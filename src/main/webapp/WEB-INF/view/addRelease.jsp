<%--
  Created by IntelliJ IDEA.
  User: ishwor
  Date: 11/16/15
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="container">
    <div style="margin: auto; width: 40%">
        <h1 class="text-center">Add Release</h1>
        <form:form modelAttribute="release" action="/mumScrum/addRelease">


            <div class="alert alert-danger" role="alert">
                <form:errors path="*" Class="error"/>
            </div>
            <div class="form-group">
                <label for="name">Release name</label>
                <form:input type="text" class="form-control" id="name"
                            placeholder="Release Name" path="name"/>
                <form:hidden path="id"/>
            </div>
            <div class="form-group">
                <label for="releaseDate">Release Date</label>
                <form:input class="form-control date" id="releaseDate"
                            placeholder="Release Date" path="releaseDate"
                            />

            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form:form>
    </div>
</div>
<!-- /.container -->


