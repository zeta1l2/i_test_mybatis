<%@include file="../incs/top.jspf" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container" style="margin-top:30px">
  <h2>xml test page !!</h2>
  <hr noshade="noshade">
  <h3>일반 insert</h3>
  <form action="${context }xml/join" method="post">
  <label for="t_id">ID : </label>
  <input type="text" name="t_id" id="t_id"><br>
  <label for="t_name">NAME : </label>
  <input type="text" name="t_name" id="t_name"><br>
  <input type="submit" value="등록">
  </form>
  <hr>
  <h3>프로시져 insert</h3>
  <form action="${context }xml/join2" method="post">
  <label for="t_id">ID : </label>
  <input type="text" name="t_id" id="t_id"><br>
  <label for="t_name">NAME : </label>
  <input type="text" name="t_name" id="t_name"><br>
  <input type="submit" value="등록">
  </form>
  <hr>
  
  <c:forEach var="i" items="${list }">
  ${i.T_NAME } || ${i.T_ID } || 
  <button onclick="location.href='${context}xml/update?t_id=${i.T_ID }'">수정</button>
  <button onclick="location.href='${context}xml/delete?t_id=${i.T_ID }'">삭제</button>
  <hr>
  </c:forEach>
  
</div>
<%@include file="../incs/bottom.jspf" %>