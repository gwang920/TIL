package com.product;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.frame.Biz;
import com.frame.Dao;
import com.vo.Product;
import com.vo.User;

@Service("ps")
public class ProductBiz implements Biz<Integer, Product> {
	
	@Resource(name="pd")
	Dao<Integer,Product> dao;
	

	public void startBiz() {  // 객체가 생성되는 시점에 한번만 생성되게하고싶다
		
		System.out.println("Start Biz ...");
	}
	public void endBiz() {
		
		System.out.println("End Biz ...");
	}

	//set


	public void setDao(Dao<Integer, Product> dao) {
		this.dao = dao;
	}

	
	
	@Override
	public void insert(Product v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void update(Product v) throws Exception {
		dao.update(v);
	}

	@Override
	public void delete(Integer K) throws Exception {
		dao.delete(K);
	}

	public Product select(Integer k) throws Exception {
	
		return dao.select(k);
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		
		return dao.select();
	}

}
