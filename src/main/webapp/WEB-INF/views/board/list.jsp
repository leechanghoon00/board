<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:if test="${param.success == 'board_deleted'}">
    <script>
        alert('게시글이 삭제되었습니다.');
    </script>
</c:if>
<c:if test="${param.success == 'board_inserted'}">
    <script>
        alert('게시글이 등록되었습니다.');
    </script>
</c:if>
<c:if test="${param.success == 'comment_inserted'}">
    <script>
        alert('댓글이 등록되었습니다.');
    </script>
</c:if>
<table border="1">
    <thead>
    <tr>
        <th>-번호</th>
        <th>-작성자</th>
        <th>-제목</th>
        <th>-카테고리</th>
        <th>-조회수</th>
        <th>-작성일-</th>
    </tr>
    </thead>

<script>
    const list = [<c:forEach items="${boardlist}" var="board">
        {
            num: "${board.num}",
            name: "${board.name}",
            subject: "${board.subject}",
            category: "${board.category}",
            views: "${board.views}",
            created: "${board.created}"
        }
        </c:forEach>

    ];
    console.log(list);

</script>
    <tbody>
    <c:forEach items="${boardlist}" var="board">

        <tr>
            <td><c:out value="${board.num}"/></td>
            <td><c:out value="${board.name}"/></td>
            <td>
                <a href="/board/detail?num=${board.num}">
                    <c:out value="${board.subject}"/>
                </a>
            <td><c:out value="${board.category}"/></td>
            <td><c:out value="${board.views}"/></td>
            <td><c:out value="${board.created}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<div>
    <button type="button" onclick="location.href='/insert'">글쓰기</button>
</div>


<form action="${pageContext.request.contextPath}/board/list" method="get">
    <select name="category">
        <option value="전체" ${category == '전체' ? 'selected' : ''}>전체</option>
        <option value="롤" ${category == '롤' ? 'selected' : ''}>롤</option>
        <option value="롤토체스" ${category == '롤토체스' ? 'selected' : ''}>롤토체스</option>
        <option value="배틀그라운드" ${category == '배틀그라운드' ? 'selected' : ''}>배틀그라운드</option>

    </select>
    <input type="text" name="keyword" value="${keyword}" placeholder="제목 검색" />
    <input type="hidden" name="page" value="1" />
    <button type="submit">검색</button>
</form>



<div class="pagination">
    ${pageIndexList}
</div>