package ws;

public class Grade {
//	4과목의 점수를 입력 받는다.국어, 영어, 수학, 과학
//	입력 예: 89 92 89 100
//
//	입력 받은 점수를 이용하여 다음을 출력 하시오
//	1. 합을 출력 하시오
//	2. 평균을 출력 하시오
//	3. 평균이 90점 이상이면 A, 80점 이상이면 B, 70점 이상이면 C, 60점 이상이면 D, 이하면 F
//	4. 최고점의 과목을 출력 하시오
//	5. 최하점의 과목을 출력 하시오
//	6. 오름차순 정렬 
//	7. 내림차순 정렬
	public int sum(int a[]) {
		int sum=0;
		for(int i=0;i<a.length;i++) {
			sum+=a[i];
		}
		return sum;
	}
	
//	public static double avg(int a[]) {
//		int avg=0, sum=0,grade=0;
//
//		for(int i=0;i<a.length;i++) {
//			sum+=a[i];
//		}
//		avg=sum/a.length;
//		switch((int)avg/10) {
//		case 9: grade='A';
//		case 8: grade='B';
//		case 7: grade='C';
//		case 6: grade='D';
//		default : grade='F';
//		}
//		return avg;   // 두 개의 리턴 값? int + char ?
//	}
	public double avg(int a[]) {
		int avg=0, sum=0,grade=0;

		for(int i=0;i<a.length;i++) {
			sum+=a[i];
		}
		avg=sum/a.length;
		switch((int)avg/10) {
		case 9: grade='A';
		case 8: grade='B';
		case 7: grade='C';
		case 6: grade='D';
		default : grade='F';
		}
		return avg; 
	}
	
	public char grade(int a[]) {
		int avg=0, sum=0;
				char grade=0;

		for(int i=0;i<a.length;i++) {
			sum+=a[i];
		}
		avg=sum/a.length;
		switch((int)avg/10) {
		case 9: grade='A';
		case 8: grade='B';
		case 7: grade='C';
		case 6: grade='D';
		default : grade='F';
		}
		return grade;
		
	}
	public String Max(int a[]) {
		int max=0;
		int maxindex=0;
		String maxSubject;
		for(int i=0;i<a.length;i++) {
			if(max<a[i]) {
				maxindex=i;
			}
		}
		switch(maxindex) {
		case 0: maxSubject="국어";
				break;
		case 1: maxSubject="영어";
				break;
		case 2: maxSubject="수학";
				break;
		case 3: maxSubject="과학";
				break;
		default : maxSubject="null";
		}
		return maxSubject;
		
	}
	public String Min(int a[]) {
		int min=100;
		int minindex=0;
		String minSubject;
		for(int i=0;i<a.length;i++) {
			if(min<a[i]) {
				minindex=i;
			}
		}
		switch(minindex) {
		case 0: minSubject="국어";
				break;
		case 1: minSubject="영어";
				break;
		case 2: minSubject="수학";
				break;
		case 3: minSubject="과학";
				break;
		default : minSubject="null";
		}
		return minSubject;
		
	}
	public int[] asc(int a[]) {
		
		int temp=0;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				if(a[i]<a[j]) {
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		return a;
		
	}
	public int[] dsc(int a[]) {
		
		int temp=0;
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a.length;j++) {
				if(a[i]>a[j]) {
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
		return a;
	}
}
