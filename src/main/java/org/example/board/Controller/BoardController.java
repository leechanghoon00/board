package org.example.board.Controller;




import jakarta.servlet.http.HttpServlet;

import org.example.board.DAO.BoardDAO;
import org.example.board.DAO.BoardDAOImpl;
import org.example.board.DTO.BoardDTO;
import org.example.board.Mapper.BoardMapper;
import org.example.board.Service.BoardService;
import org.example.board.Service.ServiceImpl.BoardServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BoardController extends HttpServlet {

    private BoardDAO DAO = new BoardDAOImpl();
    private BoardService boardService;
    public BoardController(BoardService boardService){
        this.boardService=boardService;
    }

    @GetMapping("/board/list")
public String list (@RequestParam("keyword") String keyword,
                    @RequestParam("category") String category,
                    @RequestParam("page") int page,
                    Model model) throws Exception {
//        int pageSize = 10; // 한 페이지당 게시글 수
//        int totalCount = boardService.getDataCount(keyword, category); // 전체 게시글 수
//        int totalPages = (int) Math.ceil((double) totalCount / pageSize); // 전체 페이지 수


        System.out.println("받은 파라미터 - keyword: " + keyword + ", category: " + category + ", page: " + page);

        List<BoardDTO> boardlist = boardService.getLists(keyword,category,page);
        System.out.println("조회된 리스트 크기: " + boardlist.size());

        model.addAttribute("boardlist",boardlist);

        return "list";
    }


}
