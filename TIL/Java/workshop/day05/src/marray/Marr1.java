package marray;

import java.util.Arrays;
import java.util.Random;

public class Marr1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int a[]=new int[5];
			
			int ma[][] = new int[5][5];
			
			System.out.println(ma.length);
			System.out.println(ma[0].length);
			
			Random r = new Random();
			
			
			
			for(int i=0;i<ma.length;i++) {
				for(int j=0;j<ma[i].length;j++) {
					ma[i][j]=r.nextInt(10)+1;
					
				}
			}
			
			System.out.println(Arrays.toString(ma));
			
			for(int i=0;i<ma.length;i++) {
				for(int j=0;j<ma[i].length;j++) {
					System.out.print(ma[i][j]+" ");
				}
				System.out.println();
			}
			
			//Enhanced for Statement
			for(int temp[]:ma) {
				for(int data:temp) {
					System.out.print(data+" ");
				}
					System.out.println();
			}
	}
}
