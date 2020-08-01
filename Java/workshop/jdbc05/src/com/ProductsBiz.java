package com;

import java.sql.Connection;
import java.util.ArrayList;

import frame.Biz;
import frame.Dao;
import vo.Factory;
import vo.Products;

public class ProductsBiz extends Biz<String, Products> {
	
	Dao<String, Products> dao;
	
	public ProductsBiz() {
		
		dao=new ProductsDao();
	}

	@Override
	public void insert(Products v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String k) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Products v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Products select(String k) throws Exception {
		Connection con =getCon();
		Products p=null;
		
		try {
			p=dao.select(k,con);
			
		}catch(Exception e) {
			
		}finally {
			close(con);
		}
		return p;
	}

	@Override
	public ArrayList<Products> selectAll() throws Exception {
		Connection con = getCon();
		ArrayList<Products> ps=null;
		
		try {
			ps=dao.selectAll(con);
		}catch(Exception e) {
			
		}finally {
			close(con);
		}
		return null;
	}

}
