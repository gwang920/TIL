package db2;

public abstract class DB {

		String ip;
		public DB() {
			
		}
		public DB(String ip) {
			this.ip=ip;            //DB ����Ŭ�������� ����Ҳ��ϱ� ����
			
		}
		public void connection() {
			System.out.println(ip+"connect..");
		}
		public void close() {

			System.out.println(ip+"close..");
		}
		public abstract void insert(Object obj);    // ����� �� ���� �� �ְ�,, �ߺ��� �ּ�ȭ�Ѵ�
		public abstract Object select(Object obj); 	// User user �� �����ϸ� User�� ����
}
