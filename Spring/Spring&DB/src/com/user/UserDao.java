package com.user;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;

import com.mapper.UserMapper;
import com.vo.User;

@Repository("ud")
public class UserDao implements Dao<String, User> {
	
	@Autowired
	UserMapper um; // 통로역할
	
	
	
	@Override
	public void insert(User v) throws Exception {
		um.insert(v);
		System.out.println(v + " Inserted ...");
	}

	@Override
	public void update(User v) throws Exception {
		um.update(v);
		System.out.println(v + " updated ...");
	}

	@Override
	public void delete(String K) throws Exception {
		um.delete(K);
		System.out.println(K + " deleted ...");
	}

	@Override
	public User select(String K) throws Exception {

		return um.select(K);
	}

	@Override
	public ArrayList<User> select() throws Exception {
		
	
		return um.selectall();
	}
	


}
