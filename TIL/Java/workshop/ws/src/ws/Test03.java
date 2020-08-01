package ws;

import java.util.Random;

public class Test03 {

	public static void main(String[] args) {
		int a[]=new int[11];
		int temp=0;
		Random r=new Random();
		
		for(int i=0;i<10;i++) {
			a[i]=r.nextInt(89)+10;
					}
		
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(a[i]<a[j]) {
					
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		for(int i=0;i<10;i++) {
			System.out.print(" "+a[i]);
		}
		System.out.println();
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(a[i]>a[j]) {
					
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
			for(int i=0;i<10;i++) {
			System.out.print(" "+a[i]);
		}
	}

}
