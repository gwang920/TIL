package test;

import com.ProductsBiz;

import frame.Biz;
import vo.Products;

public class ProductDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Biz<String, Products> biz = new ProductsBiz();
		
		try {
			biz.delete("5");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
