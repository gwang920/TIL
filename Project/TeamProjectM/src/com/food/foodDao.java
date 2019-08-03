package com.food;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.frame.ObjectDao;
import com.mapper.foodMapper;
import com.vo.Food;


@Component("FoodDao")
public class foodDao implements ObjectDao<String, Food> {

	@Autowired
	foodMapper fm;
	
	@Override
	public void insert(Food v) {
		// TODO Auto-generated method stub
		fm.insert(v);
	}

	@Override
	public void delete(String k) {
		// TODO Auto-generated method stub
		fm.delete(k);
	}

	@Override
	public void update(Food v) {
		// TODO Auto-generated method stub
		fm.update(v);
	}

	@Override
	public ArrayList<Food> select(String k) {
		// TODO Auto-generated method stub
		System.out.println(k+" in food Dao");
		return fm.select(k);
	}

	
	
	@Override
	public ArrayList<Food> selectAll() {
		// TODO Auto-generated method stub
		
		return fm.selectall();
	}

}
