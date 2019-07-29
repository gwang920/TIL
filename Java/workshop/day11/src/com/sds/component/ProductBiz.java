package com.sds.component;

import java.util.ArrayList;

import com.sds.frame.Biz;
import com.sds.frame.Dao;
import com.sds.vo.Product;

public class ProductBiz extends Biz<Integer, Product> {
   
	 Dao<Integer,Product> dao;
	 
	 public ProductBiz() {
		 dao = new ProductDao();
	 }

	@Override
	public void register(Product v) throws Exception {
		checkData(v);
		transactionStart();
		try {
			dao.insert(v);
		}catch(Exception e) {   //오류가 들어오면
			throw e;  //던지다
		}finally {		//finally (결국) 너 실행해라 (정상이든 비정상이든)
			transactionEnd();
		}
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		transactionStart();
		try {
			dao.delete(k);
		}catch(Exception e) {
			throw e;
		}finally {
			transactionEnd();
		}		
		
	}

	@Override
	public void modify(Product v) throws Exception {
		checkData(v);
		transactionStart();
		try {
			dao.update(v);
		}catch(Exception e) {
			throw e;
		}finally {
			transactionEnd();
		}
		
	}

	@Override
	public Product get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<Product> get() throws Exception {
		return dao.select();
	}
 		
	

	

}
