package com.sds;

public class UserBiz implements Biz{
	
	private Biz biz;
	private Dao dao1;
	private Dao dao2;

	public UserBiz() {
	
		System.out.println("UserBiz construct");
	}
	
	
//	public UserBiz(Biz biz) {
//		this.biz = biz;
//	}
//	
	@Override
	public void register() {
		System.out.println("register ok");
		dao1.insert();
		dao2.insert();
	}
	
	public Biz getBiz() {
		return biz;
	}


	public Dao getDao1() {
		return dao1;
	}


	public void setDao1(Dao dao1) {
		this.dao1 = dao1;
	}


	public Dao getDao2() {
		return dao2;
	}


	public void setDao2(Dao dao2) {
		this.dao2 = dao2;
	}

	

//	public void setBiz(Biz biz) {
//		this.biz = biz;
//	}


//	@Override
//	public String toString() {
//		return "UserBiz [biz=" + biz + "]";
//	}

}
