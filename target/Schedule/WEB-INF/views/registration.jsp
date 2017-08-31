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

    <title>Add user</title>

<body>

<div class="container">


    <form:form method="POST" modelAttribute="userForm" class="form-signin">
        <h2 class="form-signin-heading">Create your account</h2>
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="username" class="form-control" placeholder="Username"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="confirmPassword">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="confirmPassword" class="form-control"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="confirmPassword"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="fName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="fName" class="form-control" placeholder="first_name"
                            autofocus="true"></form:input>
            </div>
        </spring:bind>

        <spring:bind path="lName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="lName" class="form-control" placeholder="last_name"
                            autofocus="true"></form:input>
            </div>
        </spring:bind>

        <spring:bind path="mail">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="mail" class="form-control" placeholder="mail"
                            autofocus="true"></form:input>
            </div>
        </spring:bind>

        <spring:bind path="phone">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="number" path="phone" class="form-control" placeholder="phone"
                            autofocus="true"></form:input>
            </div>
        </spring:bind>

        <spring:bind path="groupName">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="groupName" class="form-control"
                            placeholder="Set group"></form:input>
            </div>
        </spring:bind>



        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>

</div>
</body>
</html>