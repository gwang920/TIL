package db;

public class App {

	public static void main(String[] args) {
		User user = new User("id01","james","pwd01");  //user ��ü ����
		
		Biz biz= new UserBiz("192.168.11.100");
//		biz.register(user); // UserBiz�� ���� ��� ����� �� �ְ� (Biz�� ���� ������ �� �ְ�)
//		biz.remove("id01"); 
		
		User dbuser=null;
		dbuser=(User)biz.get("id01"); //(User) ==typeĳ����
		System.out.println(dbuser);
	}

}