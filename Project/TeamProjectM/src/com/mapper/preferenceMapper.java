package com.mapper;

import java.util.ArrayList;

import com.vo.Food;

public interface preferenceMapper {
	public void insert(String User_id,String food_id);
	public void delete(String User_id);
	public void update(String User_id,String food_id);
	public ArrayList<String> select(String User_id);
	public ArrayList<Food> selectById(String User_id);
	public ArrayList<String> selectall();
}



