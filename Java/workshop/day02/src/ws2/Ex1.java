//package ws2;
//
//import java.util.Random;
//import java.util.Scanner;
//
//
//public class Ex1 {
//
//	public static void main(String[] args) {
//		
//		
//		char[][] map=new char[9][9];
//		
//		Scanner sc=new Scanner(System.in);
//		
//		
//		randomMap()
//		
//		printMap(map);
//		
//		
//		
//	}
//	
//	public static void printMap(char[][] map) {
//		
//		System.out.println();
//		for(int i=0;i<9;i++) {
//			for(int j=0;j<9;j++) {
//				System.out.println(map[j][i]+" ");
//			}
//			System.out.println();
//		}
//	}
//	
//	public static void randomMap() {
//		String []input= {"A","B","C","D","E"};
//		
//		String map[][]=new String[9][9];
//		Random r=new Random();
//		for(int i=0;i<map.length;i++) {
//			for(int j=0;j<map.length;j++) {
//				map[i][j]=input[r.nextInt(5)];
//			}
//		}
//		
//	
//	}
//
//}   오류코드
package ws2;

import java.util.Random;
import java.util.Scanner;


public class Ex1 {

	public static void main(String[] args) {
		
		
		char[][] map=new char[9][9];
		
		Scanner sc=new Scanner(System.in);
		
		randomMap(map);
		printMap(map);
		
		
		
		while(true) {
			
			System.out.println("바꿀 좌표를 입력 y,x");
			int select_y=sc.nextInt();
			int select_x=sc.nextInt();
			
			
			System.out.println("이웃 좌표(교환)를 입력 y,x");
			int change_y=sc.nextInt();
			int change_x=sc.nextInt();
			
			
			if(Math.abs(select_x-change_x)+Math.abs(select_y-change_y)!=1) {
				System.out.println("오류  : 인접 좌표를 입력하세요");
				continue;
			}
			
			
			char temp=map[select_y-1][select_x-1];
			
			map[select_y-1][select_x-1]=map[change_y-1][change_x-1];
			map[change_y-1][change_x-1]=temp;
					
					
			System.out.println();
			printMap(map);
			
		}
		
	}
	
	public static void printMap(char[][] map) {
		
		System.out.println();
		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				System.out.printf(map[j][i]+" ");
			}
			System.out.println();
		}
	}
	
	public static void randomMap(char[][] map) {
		char []input= {'A','B','C','D','E'};
	
		Random r=new Random();
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map.length;j++) {
				map[i][j]=input[r.nextInt(5)];
			}
		}
	}
}