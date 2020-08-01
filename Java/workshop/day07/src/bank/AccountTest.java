package bank;

public class AccountTest {

	public static void main(String[] args) {
//		Account acc1=
//		new Account("Kim","1234",10000);
		Account acc1 = null,acc2=null;   //레퍼런스타입의 초기값 null
		try {
			acc1=
			new Account("Kim","12345",10000);
			System.out.println(acc1);
			System.out.println(Account.cnt); // 클래스변수 접근법 Account.cnt
			acc2=
			new Account("Lee","12346",20000);
			System.out.println(acc2);
			System.out.println(Account.cnt);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println(acc1.getOwner());
	}

}