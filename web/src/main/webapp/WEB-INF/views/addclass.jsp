<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Add class</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

<body>

<div class="container">


    <form:form method="POST" modelAttribute="classesForm" class="form-signin">
        <h2 class="form-signin-heading">Add class</h2>

        <input action="action" type="button" onclick="history.go(-1);" type="button" value="Back" />

        <spring:bind path="time">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <tr>
                    <td>Time :</td>
                    <td><form:select path="time">
                        <form:option value="" label="--- Select ---" />
                        <form:options items="${timeList}" />
                    </form:select>
                    </td>
                </tr>
            </div>
        </spring:bind>

        <spring:bind path="day">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <tr>
                    <td>Day :</td>
                    <td><form:select path="day">
                        <form:option value="" label="--- Select ---" />
                        <form:options items="${daysList}" />
                    </form:select>
                    </td>
                </tr>
            </div>
        </spring:bind>

        <spring:bind path="aud">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="aud" class="form-control" placeholder="aud"></form:input>
            </div>
        </spring:bind>

        <spring:bind path="disc">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="disc" class="form-control"
                            placeholder="disc"></form:input>

            </div>
        </spring:bind>

        <spring:bind path="groupName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="groupName" class="form-control" placeholder="groupName"
                            autofocus="true"></form:input>
                <form:errors path="groupName"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="profName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="profName" class="form-control" placeholder="profName"
                            autofocus="true"></form:input>
                <form:errors path="profName"></form:errors>
            </div>
        </spring:bind>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>