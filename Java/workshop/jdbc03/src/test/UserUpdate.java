package test;

import com.UserBiz;

import frame.Biz;
import vo.User;

public class UserUpdate {

	public static void main(String[] args) {
		Biz<String,User> biz = new UserBiz();
		User user = new User("id02", "asdf", "asdf"); //sql���� ������ �ƴ϶�  User�������
		try {
			biz.modify(user);
			System.out.println("User Update");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
