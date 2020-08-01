package com.product;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.mapper.ProductMapper;
import com.vo.Product;
@Repository("pd")
public class ProductDao implements Dao<Integer, Product> {
	
	@Autowired
	ProductMapper pm;
	
	@Override
	public void insert(Product v) throws Exception {
		pm.insert(v);
		System.out.println(v + " Inserted ...");
	}

	@Override
	public void update(Product v) throws Exception {
		pm.update(v);
		System.out.println(v + " updated ...");
		
	}

	@Override
	public void delete(Integer K) throws Exception {
		pm.delete(K);
		System.out.println(K + " deleted ...");
		
	}

	@Override
	public Product select(Integer K) throws Exception {
		System.out.println(K + " selected ...");
		return pm.select(K);
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		System.out.println(" ALL Selected ...");
		return pm.selectall();
	}

}
