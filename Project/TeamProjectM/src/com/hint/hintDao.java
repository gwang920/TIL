package com.hint;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frame.StringDao;
import com.mapper.hintMapper;


@Component("HintDao")
public class hintDao implements StringDao<String, String> {

	@Autowired
	hintMapper hm;
	
	@Override
	public void insert(String id,String name) {
		// TODO Auto-generated method stub
		hm.insert(id, name);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		hm.delete(id);
	}

	@Override
	public void update(String id,String name) {
		// TODO Auto-generated method stub
		hm.update(id, name);;
	}

	@Override
	public ArrayList<String> select(String id) {
		// TODO Auto-generated method stub
		return hm.select(id);
	}

	@Override
	public ArrayList<String> selectAll() {
		// TODO Auto-generated method stub
		return hm.selectall();
	}

}
