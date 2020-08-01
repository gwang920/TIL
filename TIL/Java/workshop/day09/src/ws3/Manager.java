package ws3;

public class Manager extends Employee {
	
	private double incentive;

	public Manager(String id,String name,double salary,String dept,double incentive) {
	
	this.id=id;
	this.name=name;
	this.salary=salary;
	this.dept=dept;
	
	this.incentive=incentive;
	
	
	}

	@Override
	public String toString() {
		return "Manager [incentive=" + incentive + ", id=" + id + ", name=" + name + ", salary=" + salary + ", dept="
				+ dept + "]";
	}

	@Override
	public double salaryM() {
		double money=0;
		money=super.salaryM()+incentive;
		return money;
	}
	
	
	
	
	
}
