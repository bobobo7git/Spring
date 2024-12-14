package com.ssafy.mvc.model.service;

import java.util.List;

import com.ssafy.mvc.model.dto.Board;

public interface BoardService {
	
	public List<Board> getBoardList();
	
	public Board readBoard(int id);
	
	public void writeBoard(Board board);
	
	public void removeBoard(int id);
	
	public void modifyBoard(Board board);
}
