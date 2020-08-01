package com.sds;

public class UserOracleDao implements Dao {
		
	private Dao dao;

	public UserOracleDao() {
		System.out.println("UserOracleDao Construct");
	}
	
	
	@Override
	public void insert() {
		System.out.println("insert ok");
		
	}

	public Dao getDao() {
		return dao;
	}


//	@Override
//	public String toString() {
//		return "UserOracleDao [dao=" + dao + "]";
//	}
	
	
}
