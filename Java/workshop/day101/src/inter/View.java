package inter;

public class View {

	public static void main(String[] args) {
		Shop shop = new Gmarket(); // 옥션을 이용
		
		shop.register();
		shop.login();
		shop.order();
		shop.logout();
		
	}

}
