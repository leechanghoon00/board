package org.example.board.Mapper;


import org.example.board.DTO.BoardDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
 class BoardMapperTest {
 @Autowired
 BoardMapper boardMapper;

 @Test
 void 게시글_등록_테스트() throws Exception{

  BoardDTO dto = new BoardDTO();
  dto.setName("해미");
  dto.setSubject("테스트 제목2");
  dto.setContent("테스트 내용2");
  // INSERT실행
  boardMapper.insertData(dto);
  System.out.println("저장된 num = " + dto.getNum());
  BoardDTO saved = boardMapper.getReadData(dto.getNum());

  assertThat(saved).isNotNull();
  assertThat(saved.getName()).isEqualTo("해미");
  assertThat(saved.getSubject()).isEqualTo("테스트 제목2");
  assertThat(saved.getContent()).isEqualTo("테스트 내용2");

 }

 @Test
 void 게시글최대글번호조회테스트()throws Exception{
  int maxNum = boardMapper.countBoard();
  System.out.println("최대 글번호 = " + maxNum);
  assertThat(maxNum);
 }

 @Test
 void 목록조회테스트()throws Exception{
  BoardDTO dto1 = new BoardDTO();
  dto1.setName("해미");
  dto1.setPwd("1234");
  dto1.setEmail("ddd@df.com");
  dto1.setContent("테스트 내용33");
  dto1.setSubject("테스트 제목33");
  dto1.setIpAddr("123.2232.2");

  BoardDTO dto2 = new BoardDTO();
  dto2.setName("해미");
  dto2.setPwd("1234");
  dto2.setEmail("ddd@df.com");
  dto2.setContent("테스트 내용41");
  dto2.setSubject("테스트 제목41");
  dto2.setIpAddr("123.2232.2");

  boardMapper.insertData(dto1);
  boardMapper.insertData(dto2);

  List<BoardDTO> list = boardMapper.getLists(1,10,"","");

  assertNotNull(list);
  assertThat(list.size() >=2);

 }

 @Test
 void 게시글상세조회테스트() throws Exception{
  BoardDTO dto = new BoardDTO();
  dto.setName("해미");
  dto.setPwd("1234");
  dto.setEmail("ddd@df.com");
  dto.setSubject("테스트 제목2");
  dto.setContent("테스트 내용2");
  dto.setIpAddr("123.2232.2");

  boardMapper.insertData(dto);

  int saveNum = dto.getNum();
  System.out.println("저장된글번호 : "+saveNum);


  BoardDTO saved = boardMapper.getReadData(saveNum);
  assertNotNull(saved);
  assertThat(saved.getNum()).isEqualTo(saveNum);
  assertThat(saved.getName()).isEqualTo("해미");
  assertThat(saved.getSubject()).isEqualTo("테스트 제목2");
  assertThat(saved.getContent()).isEqualTo("테스트 내용2");

 }
 @Test
 void 게시글개수조회() throws Exception{
  BoardDTO dto1 = new BoardDTO();
  dto1.setName("해미");
  dto1.setPwd("1234");
  dto1.setEmail("ddd@df.com");
  dto1.setContent("테스트 내용33");
  dto1.setSubject("테스트 제목33");
  dto1.setIpAddr("123.2232.2");

  BoardDTO dto2 = new BoardDTO();
  dto2.setName("해미");
  dto2.setPwd("1234");
  dto2.setEmail("ddd@df.com");
  dto2.setContent("테스트 내용41");
  dto2.setSubject("테스트 제목41");
  dto2.setIpAddr("123.2232.2");

  boardMapper.insertData(dto1);
  boardMapper.insertData(dto2);

  int count = boardMapper.getDataCount(Map.of("searchKey","","searchValue",""));
  assertThat(count).isGreaterThanOrEqualTo(2);

 }

@Test
 void 조회수증가테스트() throws Exception{
 BoardDTO dto1 = new BoardDTO();
 dto1.setName("해미");
 dto1.setPwd("1234");
 dto1.setEmail("ddd@df.com");
 dto1.setContent("테스트 내용33");
 dto1.setSubject("테스트 제목33");
 dto1.setIpAddr("123.2232.2");

 boardMapper.insertData(dto1);
 // 저장된 글 번호
 int num = dto1.getNum();

 // 초기 조회수 확인
 BoardDTO before = boardMapper.getReadData(num);
 int beforeHit = before.getHitCount();

 // 조회수 증가
 boardMapper.updateViews(num);

 BoardDTO after = boardMapper.getReadData(num);
 int afterHit = after.getHitCount();

 assertThat(afterHit).isEqualTo(beforeHit + 1);

}

@Test
 void  게시글수정() throws Exception{
 BoardDTO dto1 = new BoardDTO();
 dto1.setName("해미");
 dto1.setPwd("1234");
 dto1.setEmail("ddd@df.com");
 dto1.setContent("테스트 내용33");
 dto1.setSubject("테스트 제목33");
 dto1.setIpAddr("123.2232.2");

 boardMapper.insertData(dto1);
 int num = dto1.getNum();

 dto1.setNum(num);
 dto1.setSubject("수정할 제목");
 dto1.setContent("수정할 내용");

 boardMapper.updateData(dto1);

 BoardDTO update = boardMapper.getReadData(num);
 assertThat(update.getSubject()).isEqualTo("수정할 제목");
 assertThat(update.getContent()).isEqualTo("수정할 내용");
}


 @Test
 void 게시글삭() throws Exception {
  BoardDTO dto1 = new BoardDTO();
  dto1.setName("해미");
  dto1.setPwd("1234");
  dto1.setEmail("ddd@df.com");
  dto1.setContent("테스트 내용33");
  dto1.setSubject("테스트 제목33");
  dto1.setIpAddr("123.2232.2");

  boardMapper.insertData(dto1);
  int num = dto1.getNum();

  // 삭제 실행
  boardMapper.deleteData(num);

  BoardDTO deleted = boardMapper.getReadData(num);
  assertThat(deleted).isNull();
 }


}


