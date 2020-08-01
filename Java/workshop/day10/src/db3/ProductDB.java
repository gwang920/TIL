package db3;

public class ProductDB extends DB<Product, Integer> {

	@Override
	public void insert(Product obj) {
		System.out.println(obj.getId()+" "
				+obj.getName()+ " "+
				obj.getPrice()+" Inserted");
	}

	@Override
	public Product select(Integer obj) {
		Product p =null;
		System.out.println("Search:"+obj);
		p = new Product(1,"pants",10000);
		return p;
	}  //primary key를 참조한다

}