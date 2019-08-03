package com.mapper;

import java.util.ArrayList;

public interface categoryMapper {
	public void insert(String id, String name);
	public void delete(String id);
	public void update(String id,String name);
	public ArrayList<String> select(String id);
	public ArrayList<String> selectall();
}



