package org.example.board.Service.ServiceImpl;

import org.example.board.DTO.BoardDTO;
import org.example.board.Service.BoardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
@Transactional
class BoardServiceImplTest {

    @Autowired
    BoardService boardService;

    @Test
    void 게시글등록테스트() throws Exception{
        BoardDTO dto = new BoardDTO();
        dto.setName("해미");
        dto.setPwd("1234");
        dto.setEmail("11@naver.com");
        dto.setSubject("제목");
        dto.setContent("내용");
        dto.setIpAddr("123.223.2.2");

        boardService.insertData(dto);
        BoardDTO save = boardService.getReadData(dto.getNum());

        assertThat(save).isNotNull();
        assertThat(save.getName()).isEqualTo("해미");
        assertThat(save.getSubject()).isEqualTo("제목");
        assertThat(save.getContent()).isEqualTo("내용");
    }

    @Test
    void 최대글번호조회테스트()throws Exception{
        BoardDTO dto1 = new BoardDTO();
        dto1.setName("테스트1");
        dto1.setPwd("1234");
        dto1.setEmail("11@naver.com");
        dto1.setSubject("제목1");
        dto1.setContent("내용1");
        dto1.setIpAddr("127.0.0.1");
        boardService.insertData(dto1);

        BoardDTO dto2 = new BoardDTO();
        dto2.setName("테스트2");
        dto2.setPwd("1234");
        dto2.setEmail("11@naver.com");
        dto2.setSubject("제목2");
        dto2.setContent("내용2");
        dto2.setIpAddr("127.0.0.1");
        boardService.insertData(dto2);

        int maxNum = boardService.countBoard();

        assertThat(maxNum).isEqualTo(dto2.getNum());
    }

    @Test
    void 게시글개수조회테스트() throws Exception{
        BoardDTO dto1 = new BoardDTO();
        dto1.setName("해미");
        dto1.setPwd("1234");
        dto1.setEmail("11@naver.com");
        dto1.setSubject("제목1");
        dto1.setContent("내용1");
        dto1.setIpAddr("127.0.0.1");
        boardService.insertData(dto1);

        BoardDTO dto2 = new BoardDTO();
        dto2.setName("창훈");
        dto2.setPwd("1234");
        dto2.setEmail("11@naver.com");
        dto2.setSubject("제목2");
        dto2.setContent("내용2");
        dto2.setIpAddr("127.0.0.1");
        boardService.insertData(dto2);

        int total = boardService.getDataCount("","");
        int name = boardService.getDataCount("name","해");

        assertThat(total).isEqualTo(2);
        assertThat(name).isEqualTo(1);

    }

    @Test
    void 게시글목록조회() throws Exception {
        BoardDTO dto1 = new BoardDTO();
        dto1.setName("해미");
        dto1.setPwd("1234");
        dto1.setEmail("11@naver.com");
        dto1.setSubject("제목1");
        dto1.setContent("내용1");
        dto1.setIpAddr("127.0.0.1");
        boardService.insertData(dto1);

        BoardDTO dto2 = new BoardDTO();
        dto2.setName("창훈");
        dto2.setPwd("1234");
        dto2.setEmail("11@naver.com");
        dto2.setSubject("제목2");
        dto2.setContent("내용2");
        dto2.setIpAddr("127.0.0.1");
        boardService.insertData(dto2);

        List<BoardDTO> list = boardService.getLists(1,2,"","");

        assertThat(list).isNotNull();
        assertThat(list.size()).isEqualTo(2);
        assertThat(list.get(0).getSubject()).isEqualTo("제목2");
        assertThat(list.get(1).getSubject()).isEqualTo("제목1");
    }



@Test
    void 상세조회테스트() throws  Exception{
    BoardDTO dto1 = new BoardDTO();
    dto1.setName("해미");
    dto1.setPwd("1234");
    dto1.setEmail("11@naver.com");
    dto1.setSubject("제목1");
    dto1.setContent("내용1");
    dto1.setIpAddr("127.0.0.1");
    boardService.insertData(dto1);

    BoardDTO dto = boardService.getReadData(dto1.getNum());

    assertThat(dto).isNotNull();
    assertThat(dto.getName()).isEqualTo("해미");
    assertThat(dto.getSubject()).isEqualTo("제목1");
    assertThat(dto.getContent()).isEqualTo("내용1");
    assertThat(dto.getEmail()).isEqualTo("11@naver.com");
}

@Test
    void 조회수증가() throws Exception{
    BoardDTO dto1 = new BoardDTO();
    dto1.setName("해미");
    dto1.setPwd("1234");
    dto1.setEmail("11@naver.com");
    dto1.setSubject("제목1");
    dto1.setContent("내용1");
    dto1.setIpAddr("127.0.0.1");
    boardService.insertData(dto1);

    boardService.updateViews(dto1.getNum());

    BoardDTO result = boardService.getReadData(dto1.getNum());
    assertThat(result.getHitCount()).isEqualTo(1);
}

@Test
    void 수정테스트() throws Exception{
    BoardDTO dto1 = new BoardDTO();
    dto1.setName("해미");
    dto1.setPwd("1234");
    dto1.setEmail("11@naver.com");
    dto1.setSubject("제목1");
    dto1.setContent("내용1");
    dto1.setIpAddr("127.0.0.1");
    boardService.insertData(dto1);

    dto1.setName("수정후");
    dto1.setSubject("수정후 제목");
    dto1.setContent("수정후 내용");
    boardService.updateData(dto1);

    BoardDTO result = boardService.getReadData(dto1.getNum());
    assertThat(result.getName()).isEqualTo("수정후");
    assertThat(result.getSubject()).isEqualTo("수정후 제목");
    assertThat(result.getContent()).isEqualTo("수정후 내용");
}

@Test
    void 삭제테스트() throws Exception{
    BoardDTO dto1 = new BoardDTO();
    dto1.setName("해미");
    dto1.setPwd("1234");
    dto1.setEmail("11@naver.com");
    dto1.setSubject("제목1");
    dto1.setContent("내용1");
    dto1.setIpAddr("127.0.0.1");
    boardService.insertData(dto1);

    boardService.deleteData(dto1.getNum());
    BoardDTO result = boardService.getReadData(dto1.getNum());
    assertThat(result).isNull();
}

}