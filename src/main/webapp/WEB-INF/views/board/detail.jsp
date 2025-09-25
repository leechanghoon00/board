<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
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
    <input type="submit" value="삭제" onclick="return confirm('정말 삭제하시겠습니까?');">
</form>

