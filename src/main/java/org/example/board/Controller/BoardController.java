package org.example.board.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.example.board.Service.BoardService;
import org.example.board.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {


    @Autowired
    private BoardService boardService;

    @Autowired
    private MyUtil myUtil;

    @RequestMapping(value = "/list.action")
    public String list(HttpServletRequest request) throws Exception{
        return "list";
    }
}
