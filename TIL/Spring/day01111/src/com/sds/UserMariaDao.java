package com.sds;

public class UserMariaDao implements Dao{
	
		private Dao dao;

		public UserMariaDao() {
			System.out.println("UserMariaDao Construct");
		}
		
		@Override
		public void insert() {
			System.out.println("insert ok");
			
		}

		public Dao getDao() {
			return dao;
		}

//		@Override
//		public String toString() {
//			return "UserMariaDao [dao=" + dao + "]";
//		}

		
		
}
