<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="/resources/css/style.css" type="text/css" rel="stylesheet">
    <title>Todo List</title>
</head>
<body>
<div class="list">
    <div>
        <header>
         <p> Todo list</p>
        </header>
        <div class = "newTodo">
        <a href="/mytodoapp/newTodo"> + Create new TODO</a>
        </div>
        <div class="filter">

          <table class="filterTable">
              <tr>

          <td>Filter:</td>
             <td><c:set var="filterSt" value="Done"></c:set>
             <a href="/mytodoapp/filter?filter=${filterSt}">Done</a></td>

                  <td><c:set var="filterSt" value="NotDone"></c:set>
             <a href="/mytodoapp/filter?filter=${filterSt}">NotDone</a></td>

                  <td><c:set var="filterSt" value="All"></c:set>
             <a href="/mytodoapp/filter?filter=${filterSt}">All</a></td>
              </tr>
          </table>
    </div>

<table>
  <thead>
    <th>todo</th>
    <th>created at</th>
    <th>done</th>
    <th>by date</th>
    <th>actions</th>
  </thead>

    <c:forEach var="todo" items="${listTodo}">
        <tr>

            <td>${todo.todo}</td>
            <td>${todo.createdAt}</td>
            <td>${todo.done}</td>
            <td>${todo.todoD}</td>
            <td><a href="/mytodoapp/editTodo?id=${todo.id}">Edit</a>
                <a href="/mytodoapp/deleteTodo?id=${todo.id}">Delete</a>
            </td>

        </tr>
    </c:forEach>
</table>
<div class="pages">
    Page
    <c:set var="lastPage" value="${count%15}"/>
    <c:set var="pageNum" value="${count/15}"></c:set>
    <c:if test="${lastPage > 0}">
        <c:set var="pageNum" value="${pageNum + 1}"/>
    </c:if>

    <c:forEach begin="1" end="${pageNum}" varStatus="loop">
        <c:choose>
            <c:when test="${currentPage != loop.count}">
                <a href="/mytodoapp/paging?pageNum=${loop.count}">${loop.count}</a>
            </c:when>
            <c:otherwise>
                <c:out value="${loop.count}"/>
            </c:otherwise>
        </c:choose>
    </c:forEach>
    </div>
</div>
</div>
</div>
</body>
</html>
