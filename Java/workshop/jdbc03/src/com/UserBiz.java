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
		dao.insert(v, con);  // ������������ WHY Ʈ����� �߰���������  ex) ���������
		//dao.insert(v, con);  // error Ʈ������� �߰����� ����   ex) ����� �߰�����
		con.commit();		// dao.insert�� �����̸� commit �ϰ�
		}catch(Exception e) {
			con.rollback();  //(insert �����̸�) ������ �ߴ��� ���󺹱�
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
		u=dao.select(k, con);  // User��ü�� �޾Ƽ� �����ֱ�
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
