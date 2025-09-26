package org.example.board.Service.ServiceImpl;

import org.example.board.DTO.CommentDTO;
import org.example.board.Mapper.CommentMapper;
import org.example.board.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void insertComment(CommentDTO dto) throws Exception {
        commentMapper.insertComment(dto);
    }

    @Override
    public void deleteComment(int commentId) throws Exception {
        commentMapper.deleteComment(commentId);
    }
}
