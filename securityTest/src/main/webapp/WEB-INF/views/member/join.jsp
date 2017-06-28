<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 페이지</h1>
	
	<form action='<c:url value="/member/join"></c:url>' name="fr" method="POST">
		<label id="id">아이디</label>
		<input type="text" name="id" id="id"><br>
		<label id="pass">비밀번호</label>
		<input type="password" name="pass" id="pass"><br>
		<label id="name">이름</label>
		<input type="text" name="name" id="name"><br>
		<label id="age">나이</label>
		<input type="text" name="age" id="age"><br>
		
		<label id="auth">권한설정</label>
		USER<input type="radio" name="auth" id="auth" value="USER" checked="checked">
		ADMIN<input type="radio" name="auth" id="auth" value="ADMIN"><br><br>
		
		<!-- POST방식일때 csrf 토큰 필요 -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		
		<input type="submit" value="가입">
	</form>
	
</body>
</html>