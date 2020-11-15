package com.user;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.frame.Dao;
import com.vo.User;

@Repository("ud")
public class UserDao implements Dao<String, User> {

	@Override
	public void insert(User v) throws Exception {

		System.out.println(v + " Inserted ...");
	}

	@Override
	public void update(User v) throws Exception {
		System.out.println(v + " updated ...");
	}

	@Override
	public void delete(User v) throws Exception {
		System.out.println(v + " deleted ...");
	}

	@Override
	public User select(String K) throws Exception {

		return new User("id01", "pwd01", "ÀÌ¸»¼÷");
	}

	@Override
	public ArrayList<User> select() throws Exception {
		ArrayList<User> list = new ArrayList<>();
		list.add(new User("id01", "pwd01", "ÀÌ¸»¼÷"));
		list.add(new User("id02", "pwd02", "±è¸»¼÷"));
		list.add(new User("id03", "pwd03", "Á¤¸»¼÷"));
		list.add(new User("id04", "pwd04", "Àå¸»¼÷"));
		return list;
	}

}
