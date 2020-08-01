package com.Preference;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.frame.StringBiz;
import com.frame.StringDao;

@Component("PreferenceBiz")
public class preferenceBiz implements StringBiz<String, String> {

	
	@Resource(name="PreferenceDao")
	StringDao<String, String> dao;
	
	
	@Override
	public void insert(String user_id,String food_id) {
		// TODO Auto-generated method stub
		dao.insert(user_id, food_id);
	}

	@Override
	public void delete(String user_id) {
		// TODO Auto-generated method stub
		dao.delete(user_id);
	}

	@Override
	public void update(String user_id,String food_id) {
		// TODO Auto-generated method stub
		dao.update(user_id, food_id);
	}

	@Override
	public ArrayList<String> select(String user_id) {
		// TODO Auto-generated method stub
		return dao.select(user_id);
	}

	@Override
	public ArrayList<String> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	

}
