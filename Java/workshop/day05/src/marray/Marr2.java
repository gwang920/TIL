package marray;

import java.util.Random;

public class Marr2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int ma[][]= {
//				
//				{2,3,4,5},
//				{8,3,4,5,3,5,6},
//				{3,3,4,5},
//				{1,3,4,5,2,4}
//				
//		};
		
		// int ma[][]=new int [3][4];
		int ma[][]=new int[3][];
			ma[0] = new int[5];
			ma[1] = new int[2];
			ma[2] = new int[3];
			
			
			
			Random r = new Random();
			
			for(int i=0;i<ma.length;i++) {
				for(int j=0;j<ma[i].length;j++) {
					ma[i][j]=r.nextInt(10)+1;
					
				}
			}
			
			for(int temp[]:ma) {
				for(int data:temp) {
					System.out.printf("%d\t",data);
				}
					System.out.println();
			}
			
	}

}
