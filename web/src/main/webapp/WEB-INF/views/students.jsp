<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Users List</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>

<div class="generic-container">
    <a href="<c:url value='/admin' />">Back</a>
    <div class="panel panel-default">

        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Users </span></div>

        <table class="table table-hover">
            <thead>
            <tr>
                <th>id</th>
                <th>username</th>
                <th>fName</th>
                <th>lName</th>
                <th>mail</th>
                <th>phone</th>
                <th>group</th>
                <th width="100"></th>
                <th width="100"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.username}</td>
                    <td>${user.fName}</td>
                    <td>${user.lName}</td>
                    <td>${user.mail}</td>
                    <td>${user.phone}</td>
                    <td>${user.groupName}</td>
                    <td><a href="<c:url value='/edit-user-${user.username}' />" class="btn btn-success

custom-width">edit</a></td>
                    <td><a href="<c:url value='/delete-user-${user.username}' />" class="btn btn-danger

custom-width">delete</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="well">
        <a href="<c:url value='/registration' />">Add New User  </a>
    </div>
</div>

</body>
</html>