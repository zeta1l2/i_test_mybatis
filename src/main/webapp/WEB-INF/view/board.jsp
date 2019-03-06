<%@include file="incs/top.jspf" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container" style="margin-top:30px">
로그인 성공<hr>
<ul type="none">
<c:forEach var="i" items="${list}">
<li>
<c:forEach begin="1" end="${i.Q_MARGIN }" varStatus="status">
&nbsp;&nbsp;
<c:if test="${status.last }">
▶&nbsp;
</c:if>
</c:forEach>
${i.Q_TITLE } ||
${i.Q_DATE } ||
${i.Q_IP} ||
<button onclick="location.href='${context}recomend?q_num=${i.Q_NUM }'">답글 작성</button>
</li>
</c:forEach>
</ul>
<c:forEach begin="1" end="${pages}" varStatus="status">
<a href="${context}page?page=${status.index}&page_proc=10">${status.index }</a> 
</c:forEach>
</div>
<%@include file="incs/bottom.jspf" %>