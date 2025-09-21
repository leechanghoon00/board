<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<table>
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
            num: "${baord.num}",
            name: "${baord.name}",
            subject: "${baord.subject}",
            category: "${baord.category}",
            views: "${baord.views}",
            created: "${baord.created}",
        }</c:forEach>

    ];
    console.log(list);

</script>
    <tbody>
    <c:forEach items="${boardlist}" var="board">

        <tr>
            <td><c:out value="${board.num}"/></td>
            <td><c:out value="${board.name}"/></td>
            <td><c:out value="${board.subject}"/></td>
            <td><c:out value="${board.category}"/></td>
            <td><c:out value="${board.views}"/></td>
            <td><c:out value="${board.created}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>