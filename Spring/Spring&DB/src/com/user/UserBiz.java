package com.user;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frame.Biz;
import com.frame.Dao;

import com.vo.User;

@Service("us")
public class UserBiz implements Biz<String, User> {
	
	@Resource(name="ud")
	Dao<String,User> dao;
	


	public void startBiz() {  // 객체가 생성되는 시점에 한번만 생성되게하고싶다
		
		System.out.println("Start Biz ...");
	}
	public void endBiz() {
		
		System.out.println("End Biz ...");
	}

	//set


	public void setDao(Dao<String, User> dao) {
		this.dao = dao;
	}

	
	@Transactional
	@Override
	public void insert(User v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void update(User v) throws Exception {
		dao.update(v);
	}

	@Override
	public void delete(String K) throws Exception {
		dao.delete(K);
	}

	@Override
	public User select(String k) throws Exception {
		System.out.println("----- UService Selected ------");
		Thread.sleep(2800);
//		if(k.equals("id00")) {
//			
//			throw new Exception("Not Found Exception..");
//		}

		return dao.select(k);
	}

	@Override
	public ArrayList<User> select() throws Exception {
		
		return dao.select();
	}
	
	


}
