<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post"  modelAttribute="student">
    <form:select path="group.id" items="${groups}" itemLabel="name" itemValue="id"/>
    <form:input path="firstName" />
    <form:input path="lastName" />
    <form:input path="age" />
    <input type="submit" value="Save">
</form:form>

<h1>${sth}</h1>
<ul>
<c:forEach items="${sth}" var="str">

    <li>${str}</li>
</c:forEach>
</ul>
</body>
</html>
