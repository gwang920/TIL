package db3;

public class App {

	public static void main(String[] args) {
//			DB db= new UserDB();
			DB<User,String> db= new UserDB();
			User user=new User("id01","james","pwd01");
			
			db.insert(user);			//user�� �ٷ� object�� ���� => Ÿ��ĳ���õǾ
			User userdb=db.select("");   //�ڵ����� Ÿ��ĳ������ �ȵǼ�
			
			
//			DB db2=new ProductDB(); //raw type 
			
			DB<Product,Integer> db2 = new ProductDB();
			db2.insert(new Product(190529,"T",10000));
			Product p = db2.select(200);
			p = new Product(190529,"pants",10000);
			System.out.println(p);
	}

}