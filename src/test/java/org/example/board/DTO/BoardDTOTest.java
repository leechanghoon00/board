package org.example.board.DTO;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BoardDTOTest {
    @Test
    void 게시글_번호_설정_테스트(){
        // given : 게시글 객체(BoardDTO)를 생성
        BoardDTO dto = new BoardDTO();
        // when : 게시글 번호를 1로 설정
        dto.setNum(2);
        // then : 게시글 번호가 정상적으로 1로 저장되었는지 검증
        assertThat(dto.getNum()).isEqualTo(2);
    }


}