package com.Preference;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frame.StringDao;
import com.mapper.preferenceMapper;

@Component("PreferenceDao")
public class preferenceDao implements StringDao<String, String> {

	@Autowired
	preferenceMapper pm;
	
	@Override
	public void insert(String user_id,String food_id) {
		// TODO Auto-generated method stub
		pm.insert(user_id, food_id);
	}

	@Override
	public void delete(String user_id) {
		// TODO Auto-generated method stub
		pm.delete(user_id);
	}

	@Override
	public void update(String user_id,String food_id) {
		// TODO Auto-generated method stub
		pm.update(user_id, food_id);
	}

	@Override
	public ArrayList<String> select(String user_id) {
		// TODO Auto-generated method stub
		return pm.select(user_id);
	}

	@Override
	public ArrayList<String> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
