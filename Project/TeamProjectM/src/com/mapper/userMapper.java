package com.mapper;

import java.util.ArrayList;
import com.vo.User;

public interface userMapper {
	public void insert(User obj);
	public void delete(String obj);
	public void update(User obj);
	public ArrayList<User> select(String obj);
	public ArrayList<User> selectall();
}



