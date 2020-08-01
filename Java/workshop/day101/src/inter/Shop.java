package inter;

public interface Shop {
	// 인터페이스에서는 추상함수에 abstract를 쓰지않는다.
	public void register(); 
	public void login();
	public void logout();
	public void order();
	
}