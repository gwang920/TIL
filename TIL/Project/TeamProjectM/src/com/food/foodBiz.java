package com.food;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.frame.ObjectBiz;
import com.frame.ObjectDao;
import com.vo.Food;


@Component("FoodBiz")
public class foodBiz implements ObjectBiz<String, Food> {

	@Resource(name="FoodDao")
	ObjectDao<String, Food> dao;
	
	@Override
	public void insert(Food v) {
		// TODO Auto-generated method stub
		dao.insert(v);
	}

	@Override
	public void delete(String k) {
		// TODO Auto-generated method stub
		dao.delete(k);
	}

	@Override
	public void update(Food v) {
		// TODO Auto-generated method stub
		dao.update(v);
	}

	@Override
	public ArrayList<Food> select(String k) {
		// TODO Auto-generated method stub
		return dao.select(k);
	}

	
	@Override
	public ArrayList<Food> selectAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

}
