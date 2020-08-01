package com.sds;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext factory
		=new GenericXmlApplicationContext("myspring.xml");
		
		System.out.println("Spring started");
	
//		TV tv=(TV)factory.getBean("ltv");
//		tv.up();
//		
//		TV tv2=(TV)factory.getBean("ltv");
//		tv2.turnOn();
		
		
		Biz biz=(Biz)factory.getBean("UserBiz");
		biz.register();
		System.out.println(biz);
		
		
//		Dao dao1=(Dao)factory.getBean("UserMariaDao");
//		dao1.insert();
//		System.out.println(dao1);
//		
//		Dao dao2=(Dao)factory.getBean("UserOracleDao");
//		dao2.insert();
//		System.out.println(dao2);
		
		
//		Biz tv=(Biz)factory.getBean("stv");
//		tv.up();
//		System.out.println(tv);
//		
//		Biz tv2=(Biz)factory.getBean("ltv");
//		tv2.up();
//		System.out.println(tv2);
//	
		
		
//		
//		if(tv==tv2) {
//			
//			System.out.println("ok");
//		}
	}

}
