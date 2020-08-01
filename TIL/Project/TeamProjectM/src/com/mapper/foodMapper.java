package com.mapper;

import java.util.ArrayList;

import com.vo.Food;

public interface foodMapper {
	public void insert(Food v);
	public void delete(String k);
	public void update(Food v);
	public ArrayList<Food> select(String id);
//	public Food selectWithId(String id);
	public ArrayList<Food> selectall();
}



