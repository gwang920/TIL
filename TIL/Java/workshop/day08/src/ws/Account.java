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
				throw new Exception("음수로 입력할 수 없습니다.");
			}
			if(this.balance < money) {
				throw new Exception("잔액이 부족합니다.");
			}this.balance-=money;
			
		}
		public void deposit(int money) 
				throws Exception {
			if(money<=0) {
				throw new Exception("음수로 입력할 수 없습니다.");
			}
			this.balance+=money;
		}

		@Override
		public String toString() {
			return "Account [이름=" + owner + ", 계좌번호=" + accNum + ", 잔액=" + balance + "]";
		}
}
