<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="student">
    <%--    <form:errors path="*" />--%>
    <form method="post">
        First name: <input type="text" name="firstName"><br>
        Last name: <input type="text" name="lastName"><br>
        <input type="submit" value="Submit">
    </form>
</form:form>


</body>
</html>
