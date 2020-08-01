package test;

import com.ProductsBiz;

import frame.Biz;
import vo.Products;

public class ProductSelect {

	public static void main(String[] args) {
		Biz<String, Products> biz = new ProductsBiz();

		try {
			Products p = biz.select("3");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}