package org.example.board.DAO;

import org.example.board.DTO.BoardDTO;

import java.util.List;
import java.util.Map;

public interface BoardDAO {

    void insertData (BoardDTO dto);

    void updateData(BoardDTO dto);

    void deleteData(BoardDTO dto);

    BoardDTO getReadData(int num);

    List<BoardDTO> getList(Map<String,Object> params);

    void updateViews(int num);

}
