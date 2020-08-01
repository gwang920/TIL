package com.sds.component;

import java.util.ArrayList;

import com.sds.frame.Biz;
import com.sds.frame.Dao;
import com.sds.vo.User;

public class UserBiz extends Biz<String, User> {

	Dao<String,User> dao; //biz는 Dao가 필요하다
	
	public UserBiz() {
		dao = new UserDao();
	}
	
	@Override
	public void register(User v) throws Exception {

		//비정상적 종료 코드
//		checkData(v);
//		transactionStart();
//		dao.insert(v);  //dao에게 insert를 요청.  dao에서 exception 이오면 resgister 함수도 exception됨 
//		transactionEnd(); //즉, transactionEnd(); 가 실행되지않는다. ==> database는 end가 됐는지 인식 X


		checkData(v);
		transactionStart();
		try {
			dao.insert(v);
		}catch(Exception e) {   //오류가 들어오면
			throw e;  //던지다
		}finally {		//finally (결국) 너 실행해라 (정상이든 비정상이든)
			transactionEnd();
		}
		
	}

	@Override
	public void remove(String k) throws Exception {
		transactionStart();
		try {
			dao.delete(k);
		}catch(Exception e) {
			throw e;
		}finally {
			transactionEnd();
		}		
	}

	@Override
	public void modify(User v) throws Exception {
		checkData(v);
		transactionStart();
		try {
			dao.update(v);
		}catch(Exception e) {
			throw e;
		}finally {
			transactionEnd();
		}
	}

	@Override
	public User get(String k) throws Exception {
		return dao.select(k);
	}

	@Override
	public ArrayList<User> get() throws Exception {
		return dao.select();
	}
}
