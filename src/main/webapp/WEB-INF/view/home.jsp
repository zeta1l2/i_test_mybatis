<%@include file="incs/top.jspf" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="container" style="margin-top:30px">
  <form action="${context}join" method="post" name="frm">
      <label for="t_id"><b>ID</b></label><br>
      <input name="t_id" type="text" maxlength="15" title="5~15자의 영문 소문자, 숫자만 사용 가능합니다." placeholder="Enter Username" name="z_id" required>
      <br>
      <label for="t_pw"><b>Password</b></label><br>
      <input name="t_pw" type="password" pattern="(?=.*\d)(?=.*[a-zA-Z])(?=.*[~!@#$%^&*()_|?:{}]).{8,16}" maxlength="16" title="8~16자 영문 대 소문자, 숫자, 특수문자(~,!,@,#,$,%,^,&,*)를 사용하세요." placeholder="Enter Password" name="z_pw" required>
      <br>
      <input type="submit" value="제출">
  </form>
</div>
<%@include file="incs/bottom.jspf" %>