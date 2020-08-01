package com.app;

import java.util.ArrayList;
import java.util.Date;

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
		
	
		
		ArrayList<User> list = null;

		try {
		list = biz.select();
			for (User u : list) {
				System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		User user=null;
//		
//		try {
//			user=biz.select("id00");
//			System.out.println(user);
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}
		
		// biz.delete("id01");
		
//		ArrayList<Product> listp=null;
//		
//		try {
//			listp=biz1.select();
//			for(Product p:listp) {
//				System.out.println(p);
//			}
//		} catch (Exception e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		
//		
//		Date time = new Date();
//		
//		Product product=new Product(0, "headgear",10000,time,"img02");
//		try {
//			biz1.insert(product);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//		ArrayList<User> list=null;
//		
//		try {
//			list=biz.select();
//			for(User u: list) {
//				
//				System.out.println(u);
//			}
//			
//		} catch (Exception e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

//		try {
//			biz.delete("id01");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		User user=new User("id02","pwd02","박주한");
//		try {
//			biz.update(user);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
//		User user =new User("id05","pwd01"," 이말자");
//		try {
//			biz.insert(user);
//			System.out.println("Inserted Ok From app.");
//		} catch (Exception e) {
//
//			e.printStackTrace();
//		}

		factory.close(); // End Biz
	}
}
