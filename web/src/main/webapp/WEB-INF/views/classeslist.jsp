<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Classes list</title>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>
<div class="generic-container">
    <a href="<c:url value='/admin' />">Back</a>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Classes list</span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>id</th>
                <th>day</th>
                <th>time</th>
                <th>aud</th>
                <th>disc</th>
                <th>profName</th>
                <th>groupName</th>
                <th width="100"></th>
                <th width="100"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${classes}" var="classes">
                <tr>
                    <td>${classes.id}</td>
                    <td>${classes.day}</td>
                    <td>${classes.time}</td>
                    <td>${classes.aud}</td>
                    <td>${classes.disc}</td>
                    <td>${classes.profName}</td>
                    <td>${classes.groupName}</td>

                    <td><a href="<c:url value='/edit-class-${classes.id}' />" class="btn btn-success

custom-width">edit</a></td>
                    <td><a href="<c:url value='/delete-class-${classes.id}' />" class="btn btn-danger

custom-width">delete</a></td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="well">
        <a href="<c:url value='/addclass' />">Add new class</a>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>