package db3;

public class App {

	public static void main(String[] args) {
//			DB db= new UserDB();
			DB<User,String> db= new UserDB();
			User user=new User("id01","james","pwd01");
			
			db.insert(user);			//user가 바로 object로 들어간다 => 타입캐스팅되어서
			User userdb=db.select("");   //자동으로 타입캐스팅이 안되서
			
			
//			DB db2=new ProductDB(); //raw type 
			
			DB<Product,Integer> db2 = new ProductDB();
			db2.insert(new Product(190529,"T",10000));
			Product p = db2.select(200);
			p = new Product(190529,"pants",10000);
			System.out.println(p);
	}

}