package org.example.board.Service;

import org.example.board.DTO.BoardDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface BoardService {


    public int maxNum() throws Exception;

    public void insertData(BoardDTO dto) throws Exception;

    public int getDataCount(String searchKey, String searchValue) throws Exception;

    public List<BoardDTO> getLists(int start, int end,
                                   String searchKey, String searchValue) throws Exception;

    public BoardDTO getReadData(int num) throws Exception;

    public void updateHitCount(int num) throws Exception;

    public void updateData(BoardDTO dto) throws Exception;

    public void deleteData(int num) throws Exception;

}
