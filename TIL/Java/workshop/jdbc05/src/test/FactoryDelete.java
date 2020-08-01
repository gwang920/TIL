package test;

import com.FactoryBiz;

import frame.Biz;
import vo.Factory;

public class FactoryDelete {

	public static void main(String[] args) {
		
		Biz<String,Factory> biz=new FactoryBiz();
		
		try {
			biz.delete("3");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
