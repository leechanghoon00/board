<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
<c:if test="${param.error == 'password_mismatch'}">
    <p>비밀번호가 일치하지 않습니다.</p>
</c:if>
<c:if test="${param.success == 'comment_deleted'}">
    <script>
        alert('댓글이 삭제되었습니다.');
    </script>
</c:if>
<h2>게시글 상세보기</h2>
<table border="1">
    <tr>
        <th>번호</th>
        <td><c:out value="${board.num}"/></td>
    </tr>
    <tr>
        <th>작성자</th>
        <td><c:out value="${board.name}"/></td>
    </tr>
    <tr>
        <th>제목</th>
        <td><c:out value="${board.subject}"/></td>
    </tr>
    <tr>
        <th>카테고리</th>
        <td><c:out value="${board.category}"/></td>
    </tr>
    <tr>
        <th>조회수</th>
        <td><c:out value="${board.views}"/></td>
    </tr>
    <tr>
        <th>작성일</th>
        <td><c:out value="${board.created}"/></td>
    </tr>
    <tr>
        <th>내용</th>
        <td style="white-space: pre-wrap;">
            <c:out value="${board.content}"/></td>
    </tr>
</table>

<button type="button" onclick="location.href='/board/list?keyword=&category=&page=1'">목록</button>
<button type="button" onclick="location.href='/board/updateForm?num=${board.num}'">수정</button>
<form action="/board/delete" method="post" style="display:inline;">
    <input type="hidden" name="num" value="${board.num}">
    비밀번호: <input type="password" name="password" required>
    <input type="submit" value="삭제">
</form>

<h3>댓글</h3>


<form action="/comment/insert" method="post">
    <input type="hidden" name="boardId" value="${board.num}">
    이름: <input type="text" name="userName" required><br>
    내용: <textarea name="content" required></textarea><br>
    비밀번호: <input type="password" name="password" required><br>
    <input type="submit" value="댓글 등록">
</form>


<c:forEach var="comment" items="${comments}">
    <div>
        <b>${comment.userName}</b> (${comment.created})<br>
            ${comment.content}
        <form action="/comment/delete" method="post" style="display:inline;">
            <input type="hidden" name="commentId" value="${comment.commentId}">
            <input type="hidden" name="boardId" value="${board.num}">
            비밀번호: <input type="password" name="password" required>
            <input type="submit" value="삭제">
        </form>
    </div>
</c:forEach>