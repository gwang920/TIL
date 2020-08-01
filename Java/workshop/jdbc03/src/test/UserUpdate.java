package test;

import com.UserBiz;

import frame.Biz;
import vo.User;

public class UserUpdate {

	public static void main(String[] args) {
		Biz<String,User> biz = new UserBiz();
		User user = new User("id02", "asdf", "asdf"); //sql문의 순서가 아니라  User순서대로
		try {
			biz.modify(user);
			System.out.println("User Update");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
