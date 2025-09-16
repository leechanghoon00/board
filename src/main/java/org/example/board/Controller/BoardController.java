package org.example.board.Controller;

import org.example.board.Service.BoardService;
import org.example.board.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    @Autowired
    private MyUtil myUtil;
}
