package com.mapper;

import java.util.ArrayList;

public interface ignoreMapper {
	public void insert(String User_id,String food_id);
	public void delete(String User_id);
	public void update(String User_id,String food_id);
	public ArrayList<String> select(String User_id);
	public ArrayList<String> selectall();
}



