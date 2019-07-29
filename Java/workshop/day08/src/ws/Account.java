package ws;

import java.util.Scanner;

public class Account {
	
		
		private String owner;
		private String accNum;
		private double balance;
			
		public Account(String owner,String accNum) {
			
			this.owner=owner;
			this.accNum=accNum;	
		}
		public Account() {
			
		}
		public void withdraw(int money) 
				throws Exception {
			if(money<=0) {
				throw new Exception("������ �Է��� �� �����ϴ�.");
			}
			if(this.balance < money) {
				throw new Exception("�ܾ��� �����մϴ�.");
			}this.balance-=money;
			
		}
		public void deposit(int money) 
				throws Exception {
			if(money<=0) {
				throw new Exception("������ �Է��� �� �����ϴ�.");
			}
			this.balance+=money;
		}

		@Override
		public String toString() {
			return "Account [�̸�=" + owner + ", ���¹�ȣ=" + accNum + ", �ܾ�=" + balance + "]";
		}
}
