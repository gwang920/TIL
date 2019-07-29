package stat;

public class Constructor {
	int i;  // 인스턴스 variable은 초기화 할 필요 없다 => constructor에서 초기화 된다
	
	public Constructor() {
		
	} //있고 없고 차이      선언해주자(dafault constructor)
	  
	
	public Constructor(int i) {
		this.i=i;
	}
	
}
