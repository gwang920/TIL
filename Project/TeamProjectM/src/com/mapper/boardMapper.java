package com.mapper;

import java.util.ArrayList;

import com.vo.Board;

public interface boardMapper {
	public void insert(Board board);
	public void delete(String id);
	public void update(Board board);
	public ArrayList<Board> select(String id);
	public ArrayList<Board> selectall();
}



