<%@include file="incs/top.jspf" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container" style="margin-top:30px">
test_my_batis<hr>
<button onclick="location.href='${context}board'">게시판 이동</button>
<hr>
<c:forEach var="i" items="${list}">
ID : ${i.T_ID }<br>
PW : ${i.T_PW }<br>
NAME : ${i.T_NAME }<br>
<button onclick="location.href='${context}delete?t_id=${i.T_ID}'">delete</button><br>
</c:forEach>
</div>
<%@include file="incs/bottom.jspf" %>