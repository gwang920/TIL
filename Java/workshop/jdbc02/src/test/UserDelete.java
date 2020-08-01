package test;

import com.UserDao;

import frame.Dao;
import vo.User;

public class UserDelete {

	public static void main(String[] args) {
		Dao<String,User> dao = new UserDao();
		
		try {
			dao.delete("id67");
			System.out.println("User Deleted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				

	}

}
