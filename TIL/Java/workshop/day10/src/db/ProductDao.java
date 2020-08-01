package db;

public class ProductDao extends Dao {
	
	public ProductDao() {
		
	}
	public ProductDao(String ip) {
		super(ip);   // 상속받은 것 을 constructor를 통해 setting
	}
	
	
	
	@Override
	public void insert(Object obj) {
		connection();
		Product product=(Product)obj;
		System.out.println(product.getId()+
				" "+ product.getName()+ " "
				+ product.getPrice()
				+" Inserted...");
		close();

	}

	@Override
	public Object select(Object obj) {
		Product product=null;
		String str=(String)obj;
		connection();
		product=new Product("nike","gwang",10000);
		close();
		return product;
	}

	@Override
	public void delete(Object obj) {
		String str=(String)obj;
		connection();
		System.out.println(str+" Deleted...");
		close();
	}

}
