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



        List<BoardDTO> boardlist = boardService.getLists(keyword,category,page);
        model.addAttribute("boardlist",boardlist);

        return "list";
    }


}
