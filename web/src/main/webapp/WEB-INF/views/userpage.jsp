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
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Classes list</span></div>
        <table class="table table-hover">
            <thead>
            <tr>
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
            <c:forEach items="${mondayClasses}" var="mondayClasses">
                <tr>
                    <td>${mondayClasses.day}</td>
                    <td>${mondayClasses.time}</td>
                    <td>${mondayClasses.aud}</td>
                    <td>${mondayClasses.disc}</td>
                    <td>${mondayClasses.profName}</td>
                    <td>${mondayClasses.groupName}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>

        <table class="table table-hover">
            <thead>
            <tr>
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
            <c:forEach items="${tuesdayClasses}" var="tuesdayClasses">
                <tr>
                    <td>${tuesdayClasses.day}</td>
                    <td>${tuesdayClasses.time}</td>
                    <td>${tuesdayClasses.aud}</td>
                    <td>${tuesdayClasses.disc}</td>
                    <td>${tuesdayClasses.profName}</td>
                    <td>${tuesdayClasses.groupName}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>

        <table class="table table-hover">
            <thead>
            <tr>
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
            <c:forEach items="${wednesdayClasses}" var="wednesdayClasses">
                <tr>
                    <td>${wednesdayClasses.day}</td>
                    <td>${wednesdayClasses.time}</td>
                    <td>${wednesdayClasses.aud}</td>
                    <td>${wednesdayClasses.disc}</td>
                    <td>${wednesdayClasses.profName}</td>
                    <td>${wednesdayClasses.groupName}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>

        <table class="table table-hover">
            <thead>
            <tr>
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
            <c:forEach items="${thursdayClasses}" var="thursdayClasses">
                <tr>
                    <td>${thursdayClasses.day}</td>
                    <td>${thursdayClasses.time}</td>
                    <td>${thursdayClasses.aud}</td>
                    <td>${thursdayClasses.disc}</td>
                    <td>${thursdayClasses.profName}</td>
                    <td>${thursdayClasses.groupName}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>

        <table class="table table-hover">
            <thead>
            <tr>
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
            <c:forEach items="${fridayClasses}" var="fridayClasses">
                <tr>
                    <td>${fridayClasses.day}</td>
                    <td>${fridayClasses.time}</td>
                    <td>${fridayClasses.aud}</td>
                    <td>${fridayClasses.disc}</td>
                    <td>${fridayClasses.profName}</td>
                    <td>${fridayClasses.groupName}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>

        <table class="table table-hover">
            <thead>
            <tr>
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
            <c:forEach items="${saturdayClasses}" var="saturdayClasses">
                <tr>
                    <td>${saturdayClasses.day}</td>
                    <td>${saturdayClasses.time}</td>
                    <td>${saturdayClasses.aud}</td>
                    <td>${saturdayClasses.disc}</td>
                    <td>${saturdayClasses.profName}</td>
                    <td>${saturdayClasses.groupName}</td>

                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    </h2>

</div>
<div class="container">

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2><a onclick="document.forms['logoutForm'].submit()">Logout</a>
        </h2>

    </c:if>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>