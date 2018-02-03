<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New/Edit todo</title>
    <link href="/resources/css/style.css" type="text/css" rel="stylesheet">
    <style>

    </style>
</head>
<body>
<div class="list">
<header>
    <p>New/Edit Todo</p>
</header>

<form:form action="saveTodo" method="post" modelAttribute="Todo">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Todo:</td>
                <td><form:input path="todo" /></td>
            </tr>
            <tr>
                <td>Todo by date:</td>
                <td><form:input path="todoD" /></td>
                <td align="left" class = "pattern">pattern: "dd.MM.yyyy"</td>
            </tr>
            <tr>
                <td>Done:</td>
                <td><form:checkbox path="done" /></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form:form>
</div>
</body>
</html>
