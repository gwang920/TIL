package com.Ignore;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frame.StringDao;
import com.mapper.ignoreMapper;


@Component("IgnoreDao")
public class ignoreDao implements StringDao<String,String> {

	@Autowired
	ignoreMapper im;
	
	@Override
	public void insert(String user_id,String food_id) {
		// TODO Auto-generated method stub
		im.insert(user_id, food_id);
	}

	@Override
	public void delete(String user_id) {
		// TODO Auto-generated method stub
		im.delete(user_id);
	}

	@Override
	public void update(String user_id,String food_id) {
		// TODO Auto-generated method stub
		im.update(user_id, food_id);
	}

	@Override
	public ArrayList<String> select(String user_id) {
		// TODO Auto-generated method stub
		return im.select(user_id);
	}

	@Override
	public ArrayList<String> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}



}
