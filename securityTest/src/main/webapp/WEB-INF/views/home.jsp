<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Home!</h1>

	<!-- 로그인이 안된 상태 -->
	<sec:authorize access="isAnonymous()">
		<p>
			<a href="<c:url value="/login/loginForm.do" />">로그인</a>
		</p>
		<p>
			<a href="<c:url value="/member/join" />">회원가입</a>
		</p>
	</sec:authorize>

	<!-- 로그인이 된 상태 -->
	<sec:authorize access="isAuthenticated()">
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="로그아웃" />
		</form:form>
	</sec:authorize>

	<h3>
		[<a href="<c:url value="/intro/introduction.do" />">소개 페이지</a>] [<a
			href="<c:url value="/admin/adminHome.do" />">관리자 홈</a>]
	</h3>

</body>
</html>
