package ws;

public class Grade {
//	4������ ������ �Է� �޴´�.����, ����, ����, ����
//	�Է� ��: 89 92 89 100
//
//	�Է� ���� ������ �̿��Ͽ� ������ ��� �Ͻÿ�
//	1. ���� ��� �Ͻÿ�
//	2. ����� ��� �Ͻÿ�
//	3. ����� 90�� �̻��̸� A, 80�� �̻��̸� B, 70�� �̻��̸� C, 60�� �̻��̸� D, ���ϸ� F
//	4. �ְ����� ������ ��� �Ͻÿ�
//	5. �������� ������ ��� �Ͻÿ�
//	6. �������� ���� 
//	7. �������� ����
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
//		return avg;   // �� ���� ���� ��? int + char ?
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
		case 0: maxSubject="����";
				break;
		case 1: maxSubject="����";
				break;
		case 2: maxSubject="����";
				break;
		case 3: maxSubject="����";
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
		case 0: minSubject="����";
				break;
		case 1: minSubject="����";
				break;
		case 2: minSubject="����";
				break;
		case 3: minSubject="����";
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
