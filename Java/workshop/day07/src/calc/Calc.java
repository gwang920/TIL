package calc;

import java.util.Arrays;

public class Calc {
	private int [] data;
	public Calc() {
		
	}
	public Calc(int[] data) {
		this.data = data;
	} // 초기화
//	public Calc(int ... data) {   ... == 배열
//		this.data = data;
//	}
//	
	//1. sum
	
	public int sum(int a[]) {
		int sum=0;
		for(int data :a) {
			sum+=data;
		}
		
		return sum;
	}
	public double avg(int a[]) {
		int avg=0;
		int sum=0;
		for(int data : a) {
			sum+=data;
		}
		avg=sum/(a.length);
		
		return avg;
	}
	//2. Sort Asc 오름차순
	public int [] asort(int a[]) {
		int b[]=new int[a.length];
		Arrays.sort(a);
		for(int i=0;i<a.length;i++) {
			b[i]=a[i];
		}
		return b;
	}
	//3. Sort Desc
//	public int [] dsort(int a[]) {
//		int b[]=new int[a.length];
//		Arrays.sort(a);
//		for(int i=0;i<a.length;i++) {
//			int c=a.length;
//			b[i]=a[c];
//			c--;
//		}
//		return b;
//		
//		 오류..?
//	}
	
	public int [] dsort(int a[]) {
	
		int temp=0;

		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				if(a[i]>a[j]) {
					temp=a[j];
					a[j]=a[i];
					a[i]=temp;
					
				}
			}
		}
		return a;
		
		
	}
}
