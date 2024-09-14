<%@page pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring MVC Seminar 2014</title>
</head>
<body>
<h2>Hello Form</h2>
<form:form action="hello.html"
           method="post" modelAttribute="user">
    <div>ID:</div>
    <form:input path="id"/>
    <div>Name:</div>
    <form:input path="name"/>
    <hr>
    <input type="submit" value="Say Hello">
</form:form>
</body>
</html>