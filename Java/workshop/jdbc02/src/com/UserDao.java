package com;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.User;

public class UserDao extends Dao<String, User> {

	@Override
	public void insert(User v) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;


//		pstmt=con.prepareStatement(Sql.insertUser);
//		pstmt.setString(1, v.getId());
//		pstmt.setString(2, v.getPwd());
//		pstmt.setString(3, v.getName());  // 여기서 Exception이 나면 close가 안된다 그래서 try catch
//		pstmt.executeUpdate();
//		close(pstmt);
//		close(con);
		try {
			con = getCon();
			pstmt = con.prepareStatement(Sql.insertUser);
			pstmt.setString(1,v.getId());
			pstmt.setString(2,v.getPwd());
			pstmt.setString(3,v.getName());
			int result = pstmt.executeUpdate(); //넣어줘야 삭제 된다
			System.out.println(result);
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}
	}

	@Override
	public void delete(String k) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		
		try {
			con = getCon();
			pstmt = con.prepareStatement(Sql.DeleteUser);
			pstmt.setString(1,k);
			int result = pstmt.executeUpdate(); //넣어줘야 삭제 된다
			System.out.println(result);
			
			
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}
	}

	@Override
	public void update(User v) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;

		try {
			con = getCon();
			pstmt = con.prepareStatement(Sql.UpdateUser);
			pstmt.setString(1,v.getPwd());
			pstmt.setString(2,v.getName());
			pstmt.setString(3,v.getId());
			int result = pstmt.executeUpdate(); //넣어줘야 삭제 된다
			System.out.println(result);
			
			
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}
		
	}

	@Override
	public User select(String k) throws Exception {
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rset = null;
		
		try {
			con = getCon();
			pstmt = con.prepareStatement(Sql.SelectUser);
			pstmt.setString(1,k);
			rset = pstmt.executeQuery();
			rset.next();
			
			
			String uid = rset.getString("ID");   //column 명칭
			String upwd = rset.getString("PWD");   //column 명칭
			String uname = rset.getString("NAME");   //column 명칭
			System.out.println(uid + " "+upwd+" "+uname);
			
			
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}
		
		return null;
	}

	@Override
	public ArrayList<User> select() throws Exception {
		
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rset = null;
		ArrayList<User> list = new ArrayList<User>();
	
		try {
			con = getCon();  //연결?
			pstmt = con.prepareStatement(Sql.SelectAllUser);
			rset = pstmt.executeQuery();  //rest에 테이블 정보(테이블째로 들어오는 느낌)가 들어간다

			while(rset.next()) {
				String uid = rset.getString("ID");  //( ) == column 명
				String upwd = rset.getString("PWD");
				String uname = rset.getString("NAME");
				
				System.out.println(uid+" "+upwd+" "+uname);
			}
			return list;
		}catch(Exception e) {
			throw e;
		}finally {
			close(pstmt);
			close(con);
		}
		
		
	}

}
