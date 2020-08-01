package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import frame.Dao;
import frame.Sql;
import vo.Products;

public class ProductsDao extends Dao<String, Products> {

	

	@Override
	public void insert(Products v, Connection con) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String k, Connection con) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Products v, Connection con) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Products select(String k, Connection con) throws Exception {
		PreparedStatement pstmt =null;
		ResultSet rs=null;
		Products p =null;
		
		try {
			pstmt=con.prepareStatement(Sql.selectProduct);
			pstmt.setString(1,k);
		}catch(Exception e) {
			throw e;
		}finally {
			close(rs);
			close(pstmt);
			
		}
		return p;
	}

	@Override
	public ArrayList<Products> selectAll(Connection con) throws Exception {
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		ArrayList<Products> ps=new ArrayList<Products>();
		try {
			pstmt=con.prepareStatement(Sql.selectAllProduct);
			
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Products p=new Products(rs.getInt("PD_NO"),rs.getString("pd_name"),rs.getString("Pd_sub_name"),rs.getString("fact_no"),
						rs.getDate("PD_DATE"),rs.getInt("PD_COST"),rs.getInt("PD_PRICE"),
						rs.getInt("PD_AMOUNT")); //INT형 EX) PD_NO에 있는 값을 INT형으로 가져온다
			}									 // "대문자" 형으로 맞춘다
		}catch(Exception e) {
			throw e;
		}finally {
			close(rs);
			close(pstmt);
		}
		return ps;
	}

}
