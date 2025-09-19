<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<body>

<%
    // 컨트롤러에서 전달받은 데이터 꺼내오기
    List<HashMap<String,Object>> list = (List<HashMap<String,Object>>) request.getAttribute("list");
    Integer countBoard = (Integer) request.getcountBoard("countBoard");
%>
전체 글 수 : <%=countBoard%>/리스트 사이즈 : <%=list.size%>
<br/>

<a href="#" 게시글 입력></a>

<table board = "1">
    <thead>
        <tr>
            <th>순번</th>
            <th>제목</th>
            <th>작성자 이름</th>
            <th>조회수</th>
            <th>카테고리</th>
            <th>작성 일자</th>
        </tr>
    </thead>
    <tbody>
        <%
    if(list != null && list.size() >0){
        for(org.example.board.DTO.BoardDTO dto: list){
            %>
        <tr>
            <td><%= dto.getNum()%></td>
            <td><%= dto.getSubject()%></td>
            <td><%= dto.getName()%></td>
            <td><%= dto.getViews()%></td>
            <td><%= dto.getCategory()%></td>
            <td><%= dto.getCreated()%></td>

        </tr>
    <%
            }
        }
    %>

    </tbody>
</table>
</body>