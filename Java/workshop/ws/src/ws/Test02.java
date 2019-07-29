package ws;

import java.util.Random;

public class Test02 {

	public static void main(String[] args) {
		
		int a[] = new int [7];
		for(int i=1;i<=6;i++) {
			a[i]=i;
		}
		for(int i=1;i<=6;i++) {
			for(int j=1;j<=6;j++) {
				if(a[i]+a[j]==6) {
					System.out.print(a[i]+" "+a[j]);
					System.out.println();
				}
			}
		}
		
	
	}

}
