package ws;

import java.util.Random;
import java.util.Scanner;

public class Prize {
	
	
	Account acc=new Account();
	
	int prizeNum[]=new int[6];
	int choiceNum[]=new int[6];
	int prize=0;
	
	public Prize(int number[], Account acc){
		
		
	int count=0;
	for(int i=0;i<prizeNum.length;i++) {
		choiceNum[i]=number[i];
	}
	
	Random r = new Random();
	
	// 로또 당첨번호 생성 6개
	for(int i=0; i<prizeNum.length; i++) {
		prizeNum[i] = r.nextInt(20)+1;
		for(int j=0; j<i; j++) {
			if(prizeNum[i] == prizeNum[j]) {
				i--;
				break;
			}
		}
	}
	//비교
	for(int i=0;i<prizeNum.length;i++) {
		for(int j=0;j<prizeNum.length;j++) {
			if(prizeNum[i]==choiceNum[j]) {
				count++;
			}
		}
	}
	//당첨금생성
	if(count==6) {
		prize=2000000000;
	}
	else if (count==5)
	{
		prize=100000000;
	}
	else if (count==4)
	{
		prize=10000000;
	}
	else if (count==3)
	{
		prize=5000000;
	}
	else if (count==2)
	{
		prize=5000;
	}
	
	System.out.print("당첨번호=");
	for(int i=0;i<prizeNum.length;i++) {
		
		System.out.print(prizeNum[i]+" ");
	}
	System.out.println();
	System.out.println("당첨금액 = "+prize);
	
	
	try {
		acc.deposit(prize);
	} catch (Exception e) {
	
	}
	this.acc = acc;
		System.out.println(acc);
	}
}
