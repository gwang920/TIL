package db;

public class UserBiz extends Biz {
	
	Dao dao;
	
	public UserBiz(String ip) {
		dao = new UserDao(ip);
	}
	
	@Override
	public void register(Object obj) {
		// Transaction start ...
		// 보안 검증 걸쳐서 통과하면
		dao.insert(obj);  // 여기다 데이터를 넣어줄게
		// Transaction end ...
	}

	@Override
	public void remove(Object obj) {
		// Transaction start ...
		dao.delete(obj);
		// Transaction end ...
	}

	@Override
	public Object get(Object obj) {
		User user=null;
		// Transaction start ...
		user=(User)dao.select(obj);
		// Transaction end ...
		return user;
	}

}
