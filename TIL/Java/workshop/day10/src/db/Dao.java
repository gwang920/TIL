package db;

public abstract class Dao {
	
	private String ip;

	
	
	//
	public Dao() {
	}

	public Dao(String ip) {
		this.ip = ip;
	}
	
	
	//
	public void connection() {
		System.out.println(ip+":connected..");
	}
	public void close() {
		System.out.println(ip+":closed..");
	}
	
	
	public abstract void insert(Object obj);     //Object 하위클래스는 '다들어간다' obj 
	public abstract Object select(Object obj);  // 모두 다 리턴,, product 객체를 만들어서 product 객체를 '리턴'한다
	public abstract void delete(Object obj);
	
}
