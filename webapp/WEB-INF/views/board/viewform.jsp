<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/include/header.jsp"></jsp:include>
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td>${v.title }</td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>
							<div class="view-content">
								${v.content }<br>
							</div>
						</td>
					</tr>
				</table>
				<div class="bottom">
					<a href="${pageContext.request.contextPath}/board/listform">글목록</a>
					<a href="${pageContext.request.contextPath}/board/modifyform?no=${v.no}">글수정</a>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/include/navigation.jsp"></jsp:include>
		<jsp:include page="/WEB-INF/views/include/footer.jsp"></jsp:include>
	</div>
</body>
</html>