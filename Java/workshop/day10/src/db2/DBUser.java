package db2;

public class DBUser extends DB {

	

	public DBUser(String ip) {
		super(ip);
	}
	
	@Override
	public void insert(Object obj) {
		
		connection();   //DBuser�� ip�� Ŀ�ؼ�
		User user = (User)obj;
		System.out.println(user.getId()+"Inserted");
		close();
	}

	@Override
	public Object select(Object obj) {
		User user =null; // 
		String str = (String)obj;
		connection();
		user=new User("id02","tom","pwd02");
		close();
		return user;
	}

}
