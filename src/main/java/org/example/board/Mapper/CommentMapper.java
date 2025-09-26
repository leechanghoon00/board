package org.example.board.Mapper;

import org.example.board.DTO.CommentDTO;

public interface CommentMapper {

    public void insertComment(CommentDTO dto);
    public void deleteComment(int commentId);


}
