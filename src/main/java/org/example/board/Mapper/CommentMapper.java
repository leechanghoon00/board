package org.example.board.Mapper;

import org.example.board.DTO.CommentDTO;

import java.util.List;

public interface CommentMapper {

    public void insertComment(CommentDTO dto);
    public void deleteComment(org.example.board.DTO.CommentDTO dto);
    List<CommentDTO> getCommentByBoardId(int boardId) throws Exception;

}
