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
        return "redirect:/board/detail?num="+dto.getBoardId()+"&success=comment_inserted";
    }

    @PostMapping("/comment/delete")
    public String deleteComment(@RequestParam("commentId") int commentId,
                                @RequestParam("boardId") int boardId,
                                @RequestParam("password") String password) throws Exception {
        try {
            CommentDTO dto = new CommentDTO();
            dto.setCommentId(commentId);
            dto.setPassword(password);

            commentService.deleteComment(dto);
            return "redirect:/board/detail?num=" + boardId + "&success=comment_deleted";
        } catch (Exception e) {
            // 비밀번호 불일치 시 에러 처리
            return "redirect:/board/detail?num=" + boardId + "&error=password_mismatch";
        }
    }

}
