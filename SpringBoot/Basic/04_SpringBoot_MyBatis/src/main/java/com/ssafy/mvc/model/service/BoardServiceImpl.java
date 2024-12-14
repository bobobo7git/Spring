package com.ssafy.mvc.model.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssafy.mvc.model.dao.BoardDao;
import com.ssafy.mvc.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService{
	
	
	private final BoardDao boardDao;
	
	public BoardServiceImpl(BoardDao boardDao) {
		this.boardDao = boardDao;
		}
	
	@Override
	public List<Board> getBoardList() {
		// TODO Auto-generated method stub
		return boardDao.selectAll();
	}

	@Override
	public Board readBoard(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void writeBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeBoard(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyBoard(Board board) {
		// TODO Auto-generated method stub
		
	}
	
}
