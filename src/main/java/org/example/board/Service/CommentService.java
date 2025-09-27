package org.example.board.Service;

import org.example.board.DTO.CommentDTO;

import java.util.List;

public interface CommentService {
    public void insertComment(CommentDTO dto) throws Exception;
    public    void deleteComment(int commentId) throws Exception;
    List<CommentDTO> getCommentByBoardId(int boardId) throws Exception;


}
