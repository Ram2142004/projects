package oops_revice_clone;
public class Student implements Cloneable {
	String name;
	int age;
	Department dept = new Department();
	//constructor
	  Student(String n, int a, String d, int i){name=n; age=a; dept.name = d; dept.id = i;}
	void display() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(dept.name);
		System.out.println(dept.id);}
	protected Object clone() throws CloneNotSupportedException {
		Student temp = (Student) super.clone();
		temp.dept = (Department)dept.clone();
		return temp;
	}
		

}
