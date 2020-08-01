package ws;

import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		
		Account acc=null;     //-----1)
		Prize prize=null;
		
		System.out.println("도전 ? (yes/no)");
		
		Scanner sc=new Scanner(System.in);
		String att=sc.next();
		
		if(att.equals("yes")) {   // 문자열 비교시 equals를 쓴다.
			
			System.out.println("계좌 생성 : 계좌명 계좌번호");
			String owner=sc.nextLine();
			String accNum=sc.nextLine();
			
			try {
				acc=
				new Account(owner,accNum); // 1)null => 할당을 새로해준것 
				System.out.println(acc);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			//withdraw
			boolean flag=true;
			while(flag) {
				System.out.println("입금액을 입력하시오 : ex)100000");
				Scanner in=new Scanner(System.in);
				int inp=in.nextInt();
				try {
					flag=false;
					acc.deposit(inp);
				} catch (Exception e) {
					flag=true;
					System.out.println("음수로 입력할 수 없습니다.");
				}
				System.out.println(acc);
			}
			
			
			    //Lotto
				System.out.println("번호를 입력하세요");
				Scanner sc1=new Scanner(System.in);
				int number[]=new int[6];
				for(int i=0;i<6;i++) {
						number[i]=sc1.nextInt();
				}
				prize = new Prize(number, acc);
				
				
				
				//deposit
				
				System.out.println("출금하시겠습니까? (yes/no)");
				String wit=sc.nextLine();
				if(wit.equals("yes")) {
					System.out.println("출금액을 입력하시오 : ex)100000");
					Scanner out=new Scanner(System.in);
					int outp=out.nextInt();
					try {
						acc.withdraw(outp);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					System.out.println(acc);
				}
				else if(wit.equals("no")) {
					System.out.println("종료");
					return;
				}
				
		}
		else { System.out.println("종료");
				return;
		}
		
	}
}
