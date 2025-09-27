package org.example.board.Controller;


import jakarta.servlet.http.HttpServlet;

import org.example.board.DTO.BoardDTO;
import org.example.board.DTO.CommentDTO;
import org.example.board.Service.BoardService;
import org.example.board.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.List;


@Controller
public class BoardController extends HttpServlet {

    private BoardService boardService;
    private CommentService commentService;
    public BoardController(BoardService boardService,CommentService commentService) {
        this.commentService = commentService;
        this.boardService = boardService;
    }

    @GetMapping("/board/list")
    public String list(@RequestParam("keyword") String keyword,
                       @RequestParam("category") String category,
                       @RequestParam("page") int page,
                       Model model) throws Exception {
//        int pageSize = 10; // 한 페이지당 게시글 수
//        int totalCount = boardService.getDataCount(keyword, category); // 전체 게시글 수
//        int totalPages = (int) Math.ceil((double) totalCount / pageSize); // 전체 페이지 수
        System.out.println("받은 파라미터 - keyword: " + keyword + ", category: " + category + ", page: " + page);

        List<BoardDTO> boardlist = boardService.getLists(keyword, category, page);
        System.out.println("조회된 리스트 크기: " + boardlist.size());

        model.addAttribute("boardlist", boardlist);

        return "board/list";
    }

    // 게시글 작성 폼 이동
    @GetMapping("/insert")
    public String insertForm() {
        return "board/insert";
    }

    // 게시글 등록 처리
    @PostMapping("/insert.do")
    public String insert(BoardDTO dto) {
        System.out.println("받은 데이터: " + dto);

        try {
            // 게시글 등록 처리
            boardService.insertData(dto);
            System.out.println("게시글 등록 완료");
            return "redirect:/board/list?keyword=&category=&page=1";
        } catch (Exception e) {
            System.out.println("게시글 등록 실패: " + e.getMessage());
            e.printStackTrace();
            // 등록 실패 시 다시 등록 폼으로 이동
            return "redirect:/insert";
        }
    }

    // 게시글 상세보기
    @GetMapping("/board/detail")
    public String detail(@RequestParam("num") int num, Model model) throws Exception {
        System.out.println("상세보기 게시글 번호: " + num);
        try {
            // 누르면 조회수 증가해줌
            boardService.updateViews(num);
            BoardDTO board = boardService.getReadData(num);
            System.out.println("조회된 게시글 번호 : " + board);

            List<CommentDTO> comments = commentService.getCommentByBoardId(num);
            System.out.println("조회된 댓글 수: " + comments.size());


            model.addAttribute("board", board);
            model.addAttribute("comments",comments);
            return "board/detail";
        } catch (Exception e) {
            System.out.println("실패 : " + e.getMessage());
            e.printStackTrace();
            return "redirect:/board/list?keyword=&category=&page=1";
        }
    }


    // 게시글 수정 폼
    @GetMapping("/board/updateForm")
    public String updateForm(@RequestParam("num") int num, Model model) throws Exception {
        BoardDTO board = boardService.getReadData(num);
        model.addAttribute("board", board);
        return "board/update";
    }

    // 게시글 수정
    @PostMapping("/board/update")
    public String update(BoardDTO dto) throws Exception {
        boardService.updateData(dto);
        return "redirect:/board/detail?num=" + dto.getNum();
    }

    // 게시글 삭제
    @PostMapping("/board/delete")
    public String delete(@RequestParam("num") int num) throws Exception {
        boardService.deleteData(num);
        return "redirect:/board/list?keyword=&category=&page=1";
    }


}
