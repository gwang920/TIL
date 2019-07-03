package com.product;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.vo.Product;

@Repository("pd")
public class ProductDao implements Dao<Integer, Product> {

	@Override
	public void insert(Product v) throws Exception {

		System.out.println(v + " Inserted ...");
	}

	@Override
	public void update(Product v) throws Exception {
		System.out.println(v + " updated ...");
	}

	@Override
	public void delete(Product v) throws Exception {
		System.out.println(v + " deleted ...");
	}

	@Override
	public Product select(Integer K) throws Exception {

		return new Product(01, "pwd01", "�̸���");
	}

	@Override
	public ArrayList<Product> select() throws Exception {
		ArrayList<Product> list = new ArrayList<>();
		list.add(new Product(01, "pwd01", "�̸���"));
		list.add(new Product(02, "pwd02", "�踻��"));
		list.add(new Product(03, "pwd03", "������"));
		list.add(new Product(04, "pwd04", "�帻��"));
		return list;
	}

}
