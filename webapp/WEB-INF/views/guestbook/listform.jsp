<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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

	<c:set var="count" value="${fn:length(list)}"></c:set>
	${count }
	
	<div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<div id="content">
			<div id="guestbook">
				<form action="${pageContext.request.contextPath}/guestbook/insert" method="post">
					<table>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name"></td>
							<td>비밀번호</td>
							<td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="message" id="content"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" 확인 "></td>
						</tr>
					</table>
				</form>
			
				<c:forEach items="${list }" var="vo" varStatus="status">	
				<ul>
					<li>
						<table>
							<tr>
								<td>${count-status.index }</td>
								<td>${vo.name }</td>
								<td>${vo.date }</td>
								<td><a href="${pageContext.request.contextPath}/guestbook/deleteform?no=${vo.no}">삭제</a></td>
							</tr>
							<tr>
								<td colspan=4>${vo.message }<br>
								</td>
							</tr>
						</table> <br>
					</li>
				</ul>
				</c:forEach>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/include/navigation.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	</div>
</body>
</html>