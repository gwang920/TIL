package ws;

import java.util.Scanner;

public class Lotto {

	public static void main(String[] args) {
		
		Account acc=null;     //-----1)
		Prize prize=null;
		
		System.out.println("���� ? (yes/no)");
		
		Scanner sc=new Scanner(System.in);
		String att=sc.next();
		
		if(att.equals("yes")) {   // ���ڿ� �񱳽� equals�� ����.
			
			System.out.println("���� ���� : ���¸� ���¹�ȣ");
			String owner=sc.nextLine();
			String accNum=sc.nextLine();
			
			try {
				acc=
				new Account(owner,accNum); // 1)null => �Ҵ��� �������ذ� 
				System.out.println(acc);
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
			//withdraw
			boolean flag=true;
			while(flag) {
				System.out.println("�Աݾ��� �Է��Ͻÿ� : ex)100000");
				Scanner in=new Scanner(System.in);
				int inp=in.nextInt();
				try {
					flag=false;
					acc.deposit(inp);
				} catch (Exception e) {
					flag=true;
					System.out.println("������ �Է��� �� �����ϴ�.");
				}
				System.out.println(acc);
			}
			
			
			    //Lotto
				System.out.println("��ȣ�� �Է��ϼ���");
				Scanner sc1=new Scanner(System.in);
				int number[]=new int[6];
				for(int i=0;i<6;i++) {
						number[i]=sc1.nextInt();
				}
				prize = new Prize(number, acc);
				
				
				
				//deposit
				
				System.out.println("����Ͻðڽ��ϱ�? (yes/no)");
				String wit=sc.nextLine();
				if(wit.equals("yes")) {
					System.out.println("��ݾ��� �Է��Ͻÿ� : ex)100000");
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
					System.out.println("����");
					return;
				}
				
		}
		else { System.out.println("����");
				return;
		}
		
	}
}
