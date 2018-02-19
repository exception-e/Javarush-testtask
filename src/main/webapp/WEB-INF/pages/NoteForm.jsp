<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New/Edit note</title>
    <link href="/resources/css/style.css" type="text/css" rel="stylesheet">
    <style>

    </style>
</head>
<body>
<div class="list">
<header>
    <p>New/Edit Note</p>
</header>

<form:form action="saveNote" method="post" modelAttribute="Note">
        <table>
            <form:hidden path="id"/>
            <tr>
                <td>Text:</td>
                <td><form:input path="note" /></td>
            </tr>
            <tr>
                <td>Note by date:</td>
                <td><form:input path="noteD" /></td>
                <td align="left" class = "pattern">pattern: "dd.MM.yyyy"</td>
            </tr>
            <tr>
                <td>Done:</td>
                <td><form:checkbox path="done" /></td>
            </tr>
            <td>
                <td colspan="2" align="center"><input type="submit" value="Save"></td></form:form>
            </tr>
            <tr>
                <td colspan="3" align="center"><form:form action="cancel" method="post">
                    <input type="submit" value="Cancel">
            </form:form></td>
            </tr>
        </table>


</div>
</body>
</html>
