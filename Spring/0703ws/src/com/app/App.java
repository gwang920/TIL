package com.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.frame.Biz;
import com.vo.Product;
import com.vo.User;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext factory
		=new GenericXmlApplicationContext("myspring.xml");
		
		System.out.println("Spring started");

		Biz<String , User> biz = 
				(Biz<String , User>) factory.getBean("us");
		
		Biz<Integer,Product> biz1=
				(Biz<Integer,Product>) factory.getBean("ps");
//		User user=null;
//		
//		try {
//			user=biz.select("id00");
//			System.out.println(user);
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
		

		
		User user =new User("id01","pwd01"," ÀÌ¸»ÀÚ");
		try {
			biz.select("id01");
			System.out.println("Inserted Ok From app.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		factory.close(); // End Biz
	}
}
