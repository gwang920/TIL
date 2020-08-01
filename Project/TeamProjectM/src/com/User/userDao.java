package com.User;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frame.ObjectDao;
import com.mapper.userMapper;
import com.vo.User;

@Component("UserDao")

public class userDao implements ObjectDao<String, User> {

	@Autowired
	userMapper um;
	
	@Override
	public void insert(User v) {
		// TODO Auto-generated method stub
		um.insert(v);
	}

	@Override
	public void delete(String k) {
		// TODO Auto-generated method stub
		um.delete(k);
	}

	@Override
	public void update(User v) {
		// TODO Auto-generated method stub
		um.update(v);
	}

	@Override
	public ArrayList<User> select(String k) {
		// TODO Auto-generated method stub
		return um.select(k);
	}

	@Override
	public ArrayList<User> selectAll() {
		// TODO Auto-generated method stub
		return um.selectall();
	}

}
