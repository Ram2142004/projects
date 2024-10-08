package inheritence;
public class Demo {
	public static void main(String[] args) {
    Employee e = new Employee("gokul", 40000);
    Manager m = new Manager("Bararh", 90000, 20000);
    e.display();
    e.raiseSalary(20);
    e.display();
    m.display();
    m.raiseSalary(20);
    m.display();		
		
		
		
	}

}
