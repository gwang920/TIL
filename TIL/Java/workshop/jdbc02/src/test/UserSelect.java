package test;

import com.UserDao;

import frame.Dao;
import vo.User;

public class UserSelect {

	public static void main(String[] args) {
		Dao<String,User> dao = new UserDao();
		
		try {
			dao.select("id22");
			System.out.println("User Select");
		} catch (Exception e) {
		
			e.printStackTrace();
		}

	}

}
