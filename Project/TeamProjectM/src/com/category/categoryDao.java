package com.category;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frame.StringDao;
import com.mapper.categoryMapper;


@Component("CategoryDao")
public class categoryDao implements StringDao<String, String> {

	@Autowired
	categoryMapper cm;
	
	@Override
	public void insert(String id,String name) {
		// TODO Auto-generated method stub
		cm.insert(id, name);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		cm.delete(id);
	}

	@Override
	public void update(String id,String name) {
		// TODO Auto-generated method stub
		cm.update(id, name);;
	}

	@Override
	public ArrayList<String> select(String id) {
		// TODO Auto-generated method stub
		return cm.select(id);
	}

	@Override
	public ArrayList<String> selectAll() {
		// TODO Auto-generated method stub
		return cm.selectall();
	}

}
