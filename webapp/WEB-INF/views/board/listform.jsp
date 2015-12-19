<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath}/assets/css/board.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<c:set var="count" value="${fn:length(list)}"></c:set>

	<div id="container">
		<c:import url="/WEB-INF/views/include/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form"
					action="${pageContext.request.contextPath}/board/listform"
					method="post">
					<input type="text" id="kwd" name="kwd" value=""> <input
						type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>

					<c:set var='count' value='${fn:length(listData.list)}' />
					<c:forEach items="${listData.list}" var="vo" varStatus="status">
						<tr>
							<td>${count-status.index }</td>
							<td><a
								href="${pageContext.request.contextPath}/board/viewform?no=${vo.no}">${vo.title}</a></td>
							<td>${vo.name }</td>
							<td>${vo.viewCnt }</td>
							<td>${vo.regDate }</td>
							<td><a
								href="${pageContext.request.contextPath}/board/delete?no=${vo.no}"
								class="del">삭제 </a></td>
						</tr>
					</c:forEach>
				</table>

				<div class="pager">
					<ul>
						<c:if test="${listData.prevPage > 0 }">
							<li class="pg-prev"><a
								href="${pageContext.request.contextPath }/board/listform?p=${listData.prevPage }">◀이전</a></li>
						</c:if>
						<c:forEach begin="${listData.startPage }"
							end="${listData.endPage }" var="pageIndex" step="1">
							<c:choose>
								<c:when test="${pageIndex > listData.pageCount }">
									<li class="disable">${pageIndex }</li>
								</c:when>
								<c:otherwise>
									<c:choose>
										<c:when test="${pageIndex == listData.currentPage }">
											<li>${pageIndex }</li>
										</c:when>
										<c:otherwise>
											<li><a
												href="${pageContext.request.contextPath }/board/listform?p=${pageIndex }">${pageIndex}</a></li>
										</c:otherwise>
									</c:choose>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<c:if test="${listData.nextPage > 0 }">
							<li class="pg-next"><a
								href="${pageContext.request.contextPath }/board/listform?p=${listData.nextPage }">다음▶</a></li>
						</c:if>
					</ul>
				</div>

				<c:choose>
					<c:when test="${!empty authUser }">
						<div class="bottom">
							<a href="${pageContext.request.contextPath}/board/writeform"
								id="new-book">글쓰기</a>
						</div>
					</c:when>
				</c:choose>

			</div>
		</div>
		<c:import url="/WEB-INF/views/include/navigation.jsp"></c:import>
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	</div>
</body>
</html>