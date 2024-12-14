package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssafy.mvc.model.dto.Board;
import com.ssafy.mvc.model.service.BoardService;

@Controller
public class BoardController {
	private BoardService boardService;
	
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	
	@GetMapping("/list")
	public String list(Model model) {
		// service -> 게시글들 가져오기
		List<Board> boards = boardService.getBoardList();
		model.addAttribute("boards", boards);
		return "/board/list";
	}
}
