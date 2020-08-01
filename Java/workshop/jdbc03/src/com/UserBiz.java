package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import frame.Biz;
import frame.Dao;
import frame.Sql;
import vo.User;

public class UserBiz extends Biz<String, User> {
	Dao<String,User> dao;
	public UserBiz() {
		dao=new UserDao();
	}
	@Override
	public void register(User v) throws Exception {
		Connection con =null;
		try {
		con=getCon();
		dao.insert(v, con);  // 원복되지않음 WHY 트랜잭션 추가되지않음  ex) 사용자정보
		//dao.insert(v, con);  // error 트랜잭션이 추가되지 않음   ex) 사용자 추가정보
		con.commit();		// dao.insert가 정상이면 commit 하고
		}catch(Exception e) {
			con.rollback();  //(insert 오류이면) 이전에 했던것 원상복귀
			throw e;
		}finally {
			close(con);
		}
		
		
	}

	@Override
	public void remove(String k) throws Exception {
		Connection con =null;
		try {
		con=getCon();
		dao.delete(k,con); 
		con.commit();		
		}catch(Exception e) {
			con.rollback(); 
			throw e;
		}finally {
			close(con);
		}
		
	}

	@Override
	public void modify(User v) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User get(String k) throws Exception {
		Connection con =null;
		User u =null;
		try {
		con=getCon();
		u=dao.select(k, con);  // User객체를 받아서 던져주기
		}catch(Exception e) {
			
			throw e;
		}finally {
			close(con);
		}
		return u;
	}

	@Override
	public ArrayList<User> get() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
