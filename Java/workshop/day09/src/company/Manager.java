package company;
			//Employee Ŭ������ ���
public class Manager extends Employee{
	
	private double incentive;
	
	
	//default constructor;
	public Manager() {
	} 
	//constructor overloading
	public Manager(String id, String name, double salary, String dept, double incentive) {
    
		
		//super(id, name, salary, dept); employee�� ����Ʈ���͸� �̿� + incentive
        //	if id�� private �̸� this.id=id;   ���� x why ? private ������
		
		this.id=id; //protected�� ����Ŭ�������� �����Ӱ� ���ٰ���
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
	
	@Override //�Լ��� ������
	public double salaryM() {
		double money = 0;
		money = super.salaryM() + this.incentive;
		return money;
	}
	
	

	
	
	// ��� private�� ������ ���ÿ��� protected ���⵵�Ѵ�
	
	
	
	
	// ������
	// override ���� ���� ������ �ϰڴ�
	
}
