package org.example.board.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.board.DTO.BoardDTO;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardMapper {


    //1 게시글 등록
    public void insertData(BoardDTO dto) throws Exception;
    //2 게시글 수정
    public void updateData(BoardDTO dto) throws Exception;
    //3 게시글 삭제
    public void deleteData(int num) throws Exception;
    //4 게시글 상세 조회
    public BoardDTO getReadData(int num) throws Exception;
    //5 최대 글 번호 구하기
    public int countBoard() throws Exception;
    //6 검색된 게시글 개수
    public int getDataCount(Map<String,Object> params) throws Exception;
    //7 게시글 목록
    public List<BoardDTO> getLists(Map<String, Object> params) throws Exception;

    //8 조회수 증가
    public void updateViews(int num) throws Exception;



}
