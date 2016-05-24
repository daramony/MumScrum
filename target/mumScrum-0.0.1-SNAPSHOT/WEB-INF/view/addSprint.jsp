<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="container">
    <div style="margin: auto; width: 40%">
        <h1 class="text-center">Add Sprint</h1>
        <form:form modelAttribute="Sprint" action="/mumScrum/addSprint">


            <div class="alert alert-danger" role="alert">
                <form:errors path="*" Class="error"/>
            </div>
            <div class="form-group">
                <label for="name">Sprint Name</label>
                <form:input type="text" class="form-control" id="name"
                            placeholder="Sprint Name" path="name"
                />
                <form:hidden path="id"/>
            </div>

            <div class="form-group">
                <label for="startDate">Sprint Start Date</label>
                <form:input class="form-control date" id="startDate"
                            placeholder="Sprint Start Date" path="startDate"
                />

            </div>

            <div class="form-group">
                <label for="endDate">Sprint End Date</label>
                <form:input class="form-control date" id="endDate"
                            placeholder="Sprint End Date" path="endDate"
                />

            </div>

            <div class="form-group">
                <label for="release_id">Assign to Release</label>
                <div>
                    <form:select class="form-control" id="release_id" path="release.id">
                        <form:option value="0">Select Release</form:option>
                        <form:options items="${releaseList }" itemLabel="name" itemValue="id"/>
                    </form:select>
                </div>
            </div>

            <button type="submit" class="btn btn-default">Submit</button>
        </form:form>
    </div>
</div>
<!-- /.container -->