package com.category;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.frame.StringBiz;
import com.frame.StringDao;

@Component("CategoryBiz")
public class categoryBiz implements StringBiz<String, String> {

	@Resource(name="CategoryDao")
	StringDao<String,String> dao;
	
	@Override
	public void insert(String id,String name) {
		// TODO Auto-generated method stub
		dao.insert(id, name);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public void update(String id,String name) {
		// TODO Auto-generated method stub
		dao.update(id, name);
	}

	@Override
	public ArrayList<String> select(String id) {
		// TODO Auto-generated method stub
		return dao.select(id);
	}

	@Override
	public ArrayList<String> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	

}
