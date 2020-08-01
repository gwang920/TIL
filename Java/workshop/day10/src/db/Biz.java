package db;

public abstract class Biz {
	public abstract void register(Object obj); // obj가 들어오면 그 obj를 등록하겠다.
	public abstract void remove(Object obj);
	public abstract Object get(Object obj);  // ex) id를 넣어줄테니 로그인 이후 화면을 가져오라 
}