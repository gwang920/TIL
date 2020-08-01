package ws3;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Game {
	
	
	public static void main(String[] args) {
		
		int map[][]=new int[8][8];
		int a_money=1000,b_money=1000;
		Random r=new Random();
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++) {
				if(i>0 && j>0 && i<7 && j<7) {
					continue;
				}
				else map[i][j]=r.nextInt(100)+1;

			}
		
		}
		map[0][0]=0;
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++) {
				if(i>0 && j>0 && i<7 && j<7) {
					System.out.print("    ");
				}
				else
				System.out.printf("%3d ",map[i][j]);
				
			}
			System.out.println();
		}
		int p1_y=0,p1_x=0;
		int p2_y=0,p2_x=0;
		int flag=1;
		while(a_money>0 && b_money>0) {
			int input=0;
			int move=0;
			
			if(flag==1) {   //player1
				System.out.print("주사위를 던지세요(1입력 : PLAYER1)");
				Scanner inp=new Scanner(System.in);
				input=inp.nextInt();
				if(input==1) {
					move=r.nextInt(6)+1;
					System.out.printf("주사위 숫자=%d ",move);
				}
				if(p1_y==0) {
					p1_x+=move;
					if(p1_x>=7) {
						
						p1_y=p1_x-7;
						p1_x=7;
					}
					a_money-=map[p1_y][p1_x];
				}
				else if(p1_x==7) {
					p1_y+=move;
					if(p1_y>=7) {
						p1_x-=p1_y-7;
						p1_y=7;
					}
					a_money-=map[p1_y][p1_x];
				}
				else if(p1_y==7) {
					p1_x-=move;
					if(p1_x<=0) {
							p1_y+=p1_x;
							p1_x=0;	
						
					}
					a_money-=map[p1_y][p1_x];
				}
				else if(p1_x==0) {
					p1_y-=move;
					if(p1_y<=0) {
						
							p1_x+=-1*p1_y;
							p1_y=0;	
						
					}
					a_money-=map[p1_y][p1_x];
				}

					System.out.printf("남은금액 PLAYER1=%d PLAYER2=%d",a_money,b_money);
					System.out.println();
					flag=0;
			}
			
			if(a_money<0) {
				System.out.println("PLAYER 2 승리");
				break;
			}
			
			
			if(flag==0) {    //player2
				System.out.print("주사위를 던지세요(1입력 : PLAYER2)");
				Scanner inp=new Scanner(System.in);
				input=inp.nextInt();
				if(input==1) {
					move=r.nextInt(6)+1;
					System.out.printf("주사위 숫자=%d",move);
				}
				if(p2_y==0) {
					p2_x+=move;
					if(p2_x>=7) {
						
						p2_y=p2_x-7;
						p2_x=7;
					}
					b_money-=map[p2_y][p2_x];
				}
				else if(p2_x==7) {
					p2_y+=move;
					if(p2_y>=7) {
						p2_x-=p2_y-7;
						p2_y=7;
					}
					b_money-=map[p2_y][p2_x];
				}
				else if(p2_y==7) {
					p2_x-=move;
					if(p2_x<=0) {
							p2_y+=p2_x;
							p2_x=0;	
						
					}
					b_money-=map[p2_y][p2_x];
				}
				else if(p2_x==0) {
					p2_y-=move;
					if(p2_y<=0) {
						
							p2_x+=-1*p2_y;
							p2_y=0;	
						
					}
					b_money-=map[p2_y][p2_x];
				}

					System.out.printf("남은금액 PLAYER1=%d PLAYER2=%d",a_money,b_money);
					System.out.println();
					flag=1;
			}
			if(b_money<0) {
				System.out.println("PLAYER 1 승리");
				break;
			}
			
		}
		
	}

}
