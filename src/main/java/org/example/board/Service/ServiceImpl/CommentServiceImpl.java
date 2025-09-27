package org.example.board.Service.ServiceImpl;

import org.example.board.DTO.CommentDTO;
import org.example.board.Mapper.CommentMapper;
import org.example.board.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private ResourceUrlProvider mvcResourceUrlProvider;

    @Override
    public void insertComment(CommentDTO dto) throws Exception {
        commentMapper.insertComment(dto);
    }

    @Override
    public void deleteComment(int commentId) throws Exception {
        commentMapper.deleteComment(commentId);
    }

    @Override
    public List<CommentDTO> getCommentByBoardId(int boardId) throws Exception {
        return commentMapper.getCommentByBoardId(boardId);
            }
}
