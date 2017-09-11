<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

    <title>Group list</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
</head>

<body>
<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Groups </span></div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>id</th>
                <th>name</th>
                <th width="100"></th>
                <th width="100"></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${groups}" var="group">
                <tr>
                    <td>${group.id}</td>
                    <td>${group.name}</td>

                    <td><a href="<c:url value='/edit-groupname-${group.id}' />" class="btn btn-success

custom-width">set name</a></td>

                    <td><a href="<c:url value='/classeslist-${group.name}' />" class="btn btn-success

custom-width">edit classes</a></td>
                    <td><a href="<c:url value='/delete-group-${group.name}' />" class="btn btn-danger

custom-width">delete group</a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="well">
        <a href="<c:url value='/addgroup' />">Add new group</a>
        <a href="<c:url value='/addprof' />">Add new professor</a>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>