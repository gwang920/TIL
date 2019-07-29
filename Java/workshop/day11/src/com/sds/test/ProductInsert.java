package com.sds.test;

import com.sds.component.ProductBiz;
import com.sds.frame.Biz;
import com.sds.vo.Product;

public class ProductInsert {

	public static void main(String[] args) {
		Biz<Integer,Product> biz = new ProductBiz();
		
		Product p1 = new Product(100, "jame",100);
		
		
		try {
			biz.register(p1);
		} catch (Exception e) {
			System.out.println("Insert Error");
			System.out.println(e.getMessage());
		}
	}

}
