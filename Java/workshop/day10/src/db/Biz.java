package db;

public abstract class Biz {
	public abstract void register(Object obj); // obj�� ������ �� obj�� ����ϰڴ�.
	public abstract void remove(Object obj);
	public abstract Object get(Object obj);  // ex) id�� �־����״� �α��� ���� ȭ���� �������� 
}