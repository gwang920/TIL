package db3ex;



public class ProductDB extends DB<Product, Integer> {

	@Override
	public void insert(Product obj) {
	System.out.println(obj.getId()+ " "
			+obj.getName()+" "+
			obj.getPrice() + " Inserted");
		
	}

	@Override
	public Product select(Integer obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
