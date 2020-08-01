package test;

import com.FactoryBiz;

import frame.Biz;
import vo.Factory;

public class FactoryUpdate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Factory f = new Factory("4","GGCAFE","Hongdae");
		
		Biz biz = new FactoryBiz();
		
		try {
			biz.update(f);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}

}
