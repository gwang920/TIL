package test;

import com.UserDao;

import frame.Dao;
import vo.User;

public class UserUpdate {

	public static void main(String[] args) {
		Dao<String,User> dao = new UserDao();
		User user = new User("id02", "asdf", "asdf"); //sql문의 순서가 아니라  User순서대로
		try {
			dao.update(user);
			System.out.println("User Update");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
