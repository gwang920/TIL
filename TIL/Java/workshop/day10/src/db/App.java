package db;

public class App {

	public static void main(String[] args) {
		User user = new User("id01","james","pwd01");  //user 객체 생성
		
		Biz biz= new UserBiz("192.168.11.100");
//		biz.register(user); // UserBiz가 아직 없어도 사용할 수 있게 (Biz만 보고 개발할 수 있게)
//		biz.remove("id01"); 
		
		User dbuser=null;
		dbuser=(User)biz.get("id01"); //(User) ==type캐스팅
		System.out.println(dbuser);
	}

}