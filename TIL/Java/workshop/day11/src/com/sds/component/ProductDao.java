package com.sds.component;

import java.util.ArrayList;

import com.sds.frame.Dao;
import com.sds.vo.Product;
import com.sds.vo.User;

public class ProductDao extends Dao<Integer, Product> {

	@Override
	public void insert(Product v) throws Exception {
		if(v.getId()==1000) {
			throw new Exception("E0001");
		}
		System.out.println(v+" Inserted.");
		
	}

	@Override
	public void delete(Integer k) throws Exception {
		if(k==1000) {
			throw new Exception("E0002");
		}
		System.out.println(k+" Deleted.");		
		
	}

	@Override
	public void update(Product v) throws Exception {
		if(v.getId()==1000) {
			throw new Exception("E0003");
		}
		System.out.println(v+" Updated.");
		
	}

	@Override
	public Product select(Integer k) throws Exception {
		Product p = new Product(k,"gwang",100);
		return p;
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		ArrayList<Product> list = new ArrayList<>();
		list.add(new Product(1, "t1", 11));
		list.add(new Product(2, "t2", 12));
		list.add(new Product(3, "t3", 13));
		list.add(new Product(4, "t4", 14));
		list.add(new Product(5, "t5", 15));
		return list;
	}

	
	
}
