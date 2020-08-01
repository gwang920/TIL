package test;

import com.FactoryBiz;

import frame.Biz;
import vo.Factory;

public class FactoryInsert {

	public static void main(String[] args) {
		Factory f = new Factory("4","JHCAFE","Hongdae");
		
		Biz biz = new FactoryBiz();
		
		try {
			biz.insert(f);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}
