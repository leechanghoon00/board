package org.example.board.Service;

import org.example.board.DTO.CommentDTO;

public interface CommentService {
    public void insertComment(CommentDTO dto) throws Exception;
    public    void deleteComment(int commentId) throws Exception;


}
