package com.ssafy.mvc.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.mvc.model.dto.Board;


public interface BoardDao {
	
	public List<Board> selectAll();
	
	public BoardDao selectOne(int id);
	
	public void insertBoard(BoardDao board);
	
	public void deleteBoard(int id);
	
	
}
