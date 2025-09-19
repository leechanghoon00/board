<!DOCTYPE html>
<body>
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