package test;

import com.UserDao;

import frame.Dao;
import vo.User;

public class UserUpdate {

	public static void main(String[] args) {
		Dao<String,User> dao = new UserDao();
		User user = new User("id02", "asdf", "asdf"); //sql���� ������ �ƴ϶�  User�������
		try {
			dao.update(user);
			System.out.println("User Update");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
