<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    <h3><form:errors path="*" /></h3>
    <form:input path="title" /><br/>
    <form:errors path="title" cssClass="error" element="p"/><br/>
    <form:input path="rating" /><br/>
    <form:input path="description"/><br/>
    <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id"/><br/>
    <input type="submit"/>
</form:form>
</body>
</html>
