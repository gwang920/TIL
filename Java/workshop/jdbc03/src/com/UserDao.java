package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.User;

public class UserDao extends Dao<String, User> {

	@Override
	public void insert(User v, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		try {
			pstmt = con.prepareStatement(Sql.insertUser);
			pstmt.setString(1, v.getId());
			pstmt.setString(2, v.getName());
			pstmt.setString(3, v.getPwd());
			pstmt.executeUpdate();
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);	
		}
		
	}

	@Override
	public void delete(String k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
	
		try {
			
			pstmt = con.prepareStatement(Sql.DeleteUser);
			pstmt.setString(1,k);
			int result = pstmt.executeUpdate(); //³Ö¾îÁà¾ß »èÁ¦ µÈ´Ù
			System.out.println(result);
			
			
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			
		}
	}

	@Override
	public void update(User v, Connection con) throws Exception {
		PreparedStatement pstmt = null;


		try {
			
			pstmt = con.prepareStatement(Sql.UpdateUser);
			pstmt.setString(1,v.getPwd());
			pstmt.setString(2,v.getName());
			pstmt.setString(3,v.getId());
			int result = pstmt.executeUpdate(); //³Ö¾îÁà¾ß »èÁ¦ µÈ´Ù
			System.out.println(result);
			
			
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			
		}
		
	}

	@Override
	public User select(String k, Connection con) throws Exception {
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		try {
			
			pstmt = con.prepareStatement(Sql.SelectUser);
			pstmt.setString(1,k);
			rset = pstmt.executeQuery();
			rset.next();
			
			
			String uid = rset.getString("ID");   //column ¸íÄª
			String upwd = rset.getString("PS");   //column ¸íÄª
			String uname = rset.getString("NAME");   //column ¸íÄª
			System.out.println(uid + " "+upwd+" "+uname);
			
			
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			
		}
		
		return null;
	
	}

	@Override
	public ArrayList<User> select(Connection con) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
