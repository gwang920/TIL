package db;

public class ProductBiz extends Biz {

	Dao dao;
	
	
	public ProductBiz(String ip) {
		dao = new ProductDao(ip);
	}
	@Override
	public void register(Object obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Object obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object get(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

}
