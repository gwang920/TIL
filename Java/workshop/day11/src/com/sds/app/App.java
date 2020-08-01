package com.sds.app;

import java.util.ArrayList;
import java.util.Scanner;

import com.sds.component.UserBiz;
import com.sds.frame.Biz;
import com.sds.vo.User;


public class App {

	public static void main(String[] args) {
		
		Biz<String,User> ubiz = new UserBiz();
		
		
		
		Scanner sc = new Scanner(System.in);
	
		
		out:      //while문 빠져나오기
		while(true) {
			System.out.println("MENU:r,g,q..");
			String cmd = sc.next();
			switch(cmd) {
			case "r" :
				System.out.println("Input User Info");
				String id = sc.next();
				String pwd = sc.next();
				String name = sc.next();
				
				User u1=new User(id,name,pwd);  //User객체 생성
				try {
					ubiz.register(u1);
					
				} catch (Exception e) {
					System.out.println("Insert Error");
					System.out.println(e.getMessage());
					
				}
				
				
				break;
			case "g" :  //전체를 가져와라
				ArrayList<User> list = null;
				try {
					list = ubiz.get();
					for(User us:list) {
						System.out.println(us);
					}
				} catch (Exception e) {
					System.out.println("select Error");

				}
				
				break;
			case "q" :
				System.out.println("Bye..");
				break out;
				
			
			}
		}
		sc.close();
	}

}
