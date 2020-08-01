package test;

import com.UserBiz;

import frame.Biz;
import vo.User;

public class UserGet {

	public static void main(String[] args) {
		Biz<String,User> biz=new UserBiz();
		
		try {
			biz.get("id02");
			System.out.println("User Get");
		}catch(Exception e) {
			e.printStackTrace();
		}

	}



}
