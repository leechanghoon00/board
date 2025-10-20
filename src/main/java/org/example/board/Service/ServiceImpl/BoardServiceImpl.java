package org.example.board.Service.ServiceImpl;

import org.example.board.DTO.BoardDTO;
import org.example.board.Mapper.BoardMapper;
import org.example.board.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;



    @Override
    public int countBoard() throws Exception {
        return boardMapper.countBoard();
    }

    @Override
    public void insertData(BoardDTO dto) throws Exception {

        boardMapper.insertData(dto);
    }

    @Override
    public int getDataCount(String searchKey, String searchValue) throws Exception {
        Map<String,Object> a = new HashMap<>();
        a.put("searchKey", searchKey);
        a.put("searchValue", searchValue);
        return boardMapper.getDataCount(a);        }

    @Override
    public List<BoardDTO> getLists(String keyword, String category, int page) throws Exception {
        Map<String, Object> parms= new HashMap<>();
        parms.put("keyword",keyword);
        parms.put("category",category);
        parms.put("page",page);

        return boardMapper.getLists(parms);
    }

    @Override
    public BoardDTO getReadData(int num) throws Exception {
        return boardMapper.getReadData(num);

    }

    @Override
    public void updateViews(int num) throws Exception {
        boardMapper.updateViews(num);
    }

    @Override
    public void updateData(BoardDTO dto) throws Exception {
        boardMapper.updateData(dto);
    }

    @Override
    public void deleteData(BoardDTO dto) throws Exception {
        boardMapper.deleteData(dto);
    }
}
