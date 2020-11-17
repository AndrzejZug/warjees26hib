<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    <form:input path="title" />
    <form:input path="description"/>
    <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/>
    <input type="submit"/>
</form:form>
</body>
</html>
