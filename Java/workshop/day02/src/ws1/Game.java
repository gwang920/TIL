package ws1;

import java.util.Scanner;
import java.util.Random;


public class Game {
	
public static void main(String[] args) {
	
	
	int com[]=new int[4];
	int user[]=new int[4];
	int check_u[]=new int[9];
	int check_overlap[]=new int[4];
	int input=0;
	int ball=0,strike=0;
	
	Random r=new Random();
	
	for(int i=0;i<user.length;i++) {
		com[i]=r.nextInt(10)+1;
		for(int j=0;j<i;j++) {
			if(com[i]==com[j]) {
				i--;
				break;
			}
		}
	}

	System.out.println("���ڸ� �Է��Ͻÿ�(0~9)");
	for(int i=0;i<com.length;i++) {
		
		Scanner io = new Scanner(System.in);
		input=io.nextInt();
		if(check_u[input]==0) {
			user[i] = input;
			check_u[input]=1;
		}
		else {
			i--;
			System.out.println("�ߺ��� ���ڴ� �Է��� �� �����ϴ�.");
		}
		
		}
		
	
	for(int i=0;i<com.length;i++) {
		System.out.printf("%d\t", com[i]);
		
		
	}
	System.out.println();
	for(int i=0;i<com.length;i++) {
		System.out.printf("%d\t", user[i]);
		
		
	}
	
	
	for(int i=0;i<com.length;i++) {
		for(int j=0;j<com.length;j++) {
			if(check_overlap[i]==0) {
				if(com[i]==user[j] && i==j) {
					strike++;
					check_overlap[i]=1;
				}
				else if(com[i]==user[j] && check_overlap[i]==0)
				
					ball++;
			}
			
		}
	}
	System.out.println();
	if(ball==0 && strike==0) {
		System.out.print("out");
	}
	else if(strike==4) {
		System.out.print("Ȩ��");
	}
		
	else {
		System.out.print(ball+"B"+strike+"S");
	}
	
	}
}
