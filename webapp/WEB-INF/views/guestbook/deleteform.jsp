<%@ page contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<div id="content">
			<div id="guestbook" class="delete-form">
				<form method="post" action="${pageContext.request.contextPath}/guestbook/delete">
				<input
						type='hidden' name="no" value="${param.no }"> <label>비밀번호</label> <input
						type="password" name="password"> <input type="submit"
						value="확인">
				</form>
				<a href="${pageContext.request.contextPath}/guestbook/listform">방명록 리스트</a>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/include/navigation.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	</div>
</body>
</html>