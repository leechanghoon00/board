<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<body>
<h2>게시글 수정</h2>

<form action="/board/update" method="post">
    <input type="hidden" name="num" value="${board.num}">

    <table border="1">
        <tr>
            <th>작성자</th>
            <td><input type="text" name="name" value="${board.name}" readonly></td>
        </tr>
        <tr>
            <th>제목</th>
            <td><input type="text" name="subject" value="${board.subject}" required></td>
        </tr>
        <tr>
            <th>카테고리</th>
            <td>
                <select name="category" required>
                    <option value="전체">전체</option>
                    <option value="롤">롤</option>
                    <option value="배틀그라운드">배틀그라운드</option>
                    <option value="롤토체스">롤토체스</option>
                </select>
            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td><textarea name="content" rows="5" cols="40" required>${board.content}</textarea></td>
        </tr>
    </table>

    <div>
        <input type="submit" value="수정완료">
        <input type="button" value="취소" onclick="history.back();">
    </div>
</form>
</body>
</html>
