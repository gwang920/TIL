package db2;

public abstract class DB {

		String ip;
		public DB() {
			
		}
		public DB(String ip) {
			this.ip=ip;            //DB 하위클래스들이 사용할꺼니까 선언
			
		}
		public void connection() {
			System.out.println(ip+"connect..");
		}
		public void close() {

			System.out.println(ip+"close..");
		}
		public abstract void insert(Object obj);    // 모든지 다 넣을 수 있게,, 중복을 최소화한다
		public abstract Object select(Object obj); 	// User user 만 선언하면 User만 들어간다
}
