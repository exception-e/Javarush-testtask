<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <link href="/resources/css/style.css" type="text/css" rel="stylesheet">
    <title>NotesList</title>
</head>
<body>
<div class="list">
    <div>
        <header>
         <p> Notes list</p>
        </header>
        <div class = "newNote">
        <a href="/mynotesapp/newNote"> + Create new Note</a>
        </div>
        <div class="filter">

          <table class="filterTable">
              <tr>
                  <td>Filter:</td>
                  <td><c:set var="filterSt" value="Done"></c:set>
                      <a href="/mynotesapp/filter?filter=${filterSt}">Done</a></td>
                  <td><c:set var="filterSt" value="NotDone"></c:set>
                      <a href="/mynotesapp/filter?filter=${filterSt}">NotDone</a></td>
                  <td><c:set var="filterSt" value="All"></c:set>
                      <a href="/mynotesapp/filter?filter=${filterSt}">All</a></td>
                  <td><c:set var="order" value="DESC"></c:set>
                      <a href="/mynotesapp/sort?order=${order}">Latest on top</a></td>
                  <td><c:set var="order" value="ASC"></c:set>
                      <a href="/mynotesapp/sort?order=${order}">Earliest on top</a></td>
              </tr>
          </table>
    </div>

<table>
  <thead>
    <th>Note</th>
    <th>created at</th>
    <th>done</th>
    <th>by date</th>
    <th>actions</th>
  </thead>

    <c:forEach var="note" items="${allNotes}">
        <tr>

            <td>${note.note}</td>
            <td>${note.createdAt}</td>
            <td>${note.done}</td>
            <td>${note.noteD}</td>
            <td><a href="/mynotesapp/editNote?id=${note.id}">Edit</a>
                <a href="/mynotesapp/deleteNote?id=${note.id}">Delete</a>
            </td>

        </tr>
    </c:forEach>
</table>
<div class="pages">
    Page
    <c:set var="lastPage" value="${count%10}"/>
    <c:set var="pageNum" value="${count/10}"></c:set>
    <c:if test="${lastPage > 0}">
        <c:set var="pageNum" value="${pageNum + 1}"/>
    </c:if>

    <c:forEach begin="1" end="${pageNum}" varStatus="loop">
        <c:choose>
            <c:when test="${currentPage != loop.count}">
                <a href="/mynotesapp/paging?pageNum=${loop.count}">${loop.count}</a>
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
