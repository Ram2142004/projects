package inheritence;
public class Employee {
     protected String name;
     protected int salary;        
 // constructor
     Employee(String n, int s){name =n; salary=s;}
 // get set
	public int getSalary() {return salary;}
	public void setSalary(int salary) {this.salary = salary;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
// Methods
	void raiseSalary(double rs) { salary+= salary/100*rs;}
// display
	void display() {
		System.out.println("name :" + getName());
		System.out.println("salary :" + getSalary());}
	

	
     
     
	
	
	
}
