package org.example.board.Controller;

import org.example.board.DTO.CommentDTO;
import org.example.board.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;


    @PostMapping("/comment/insert")
    public String insertComment(CommentDTO dto) throws Exception{
        commentService.insertComment(dto);
        return "redirect:/board/detail?num="+dto.getBoardId();
    }

    @PostMapping("/comment/delete")
    public String deleteComment(@RequestParam("commentId") int commentId,
                                @RequestParam("boardId") int boardId) throws Exception {
        commentService.deleteComment(commentId);
        return "redirect:/board/detail?num=" + boardId;
    }
}
