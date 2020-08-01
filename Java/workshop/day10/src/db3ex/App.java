package db3ex;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DB<Product, Integer> db = new ProductDB();
		
		db.insert(new Product(100,"T",1000));
		
	}

}
