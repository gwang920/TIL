package company;
			//Employee 클래스를 상속
public class Manager extends Employee{
	
	private double incentive;
	
	
	//default constructor;
	public Manager() {
	} 
	//constructor overloading
	public Manager(String id, String name, double salary, String dept, double incentive) {
    
		
		//super(id, name, salary, dept); employee의 컨스트럭터를 이용 + incentive
        //	if id가 private 이면 this.id=id;   접근 x why ? private 때문에
		
		this.id=id; //protected면 하위클래스에서 자유롭게 접근가능
		this.name=name;
		this.salary=salary;
		this.dept=dept;
		this.incentive = incentive;
	}

	@Override
	public String toString() {
		return "Manager [id=" + id + ", name=" + name + ", salary=" + salary + ", dept=" + dept + ", incentive="
				+ incentive + "]";
	}
	
	@Override //함수의 재정의
	public double salaryM() {
		double money = 0;
		money = super.salaryM() + this.incentive;
		return money;
	}
	
	

	
	
	// 통상 private를 쓰지만 팀플에서 protected 쓰기도한다
	
	
	
	
	// 재정의
	// override 상위 값을 재정의 하겠다
	
}
