package ws2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Game {

	public static void main(String[] args) {
		
		int select_x,select_y;
		int change_x,change_y;
		String temp;

		String []input= {"A","B","C","D","E"};
		
		String map[][]=new String[9][9];
		Random r=new Random();
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++) {
				map[i][j]=input[r.nextInt(5)];
			}
		}
		int cnt=0;
		int flag=1;
		while(flag==1) {
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map.length;j++) {
					if(j==8) continue;
					if(map[i][j]==map[i][j+1]) {
						
						cnt++;
						
					}
					else {
						if(cnt>=2) {
							flag=1;
							for(int k=j-cnt;k<=j;k++) {
								map[i][k]=input[r.nextInt(5)];
							}
							cnt=0;
						}
						else if(cnt<2) {
							flag=0;
						}
					}
				}
			}
			
		}

		
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
		
		System.out.println("좌표를 선택하세요(y,x)");
		Scanner inp = new Scanner(System.in);
		select_y=inp.nextInt();
		select_x=inp.nextInt();
				
		System.out.println("바꾸고 싶은 좌표를 선택하세요(y,x) 단, 선택한 좌표와 인접한 좌표만 가능");
		Scanner chg = new Scanner(System.in);
		change_y=chg.nextInt();
		change_x=chg.nextInt();
		
		temp=map[select_y][select_x];
		map[select_y][select_x]=map[change_y][change_x];
		map[change_y][change_x]=temp;
		
		
		
		System.out.printf("%d %d\n",select_y,select_x);
		System.out.printf("%d %d",change_y,change_x);
		System.out.println();
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}