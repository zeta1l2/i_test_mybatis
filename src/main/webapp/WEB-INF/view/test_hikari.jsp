<%@include file="incs/top.jspf" %>

<div class="container" style="margin-top:30px">
test_hikari<br>
<c:forEach var="i" items="${list}">
ID : ${i.Z_ID }<br>
PW : ${i.Z_PW }<br>
</c:forEach>
</div>
<%@include file="incs/bottom.jspf" %>