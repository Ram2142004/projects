package oops_revice_clone;
public class Demo {
	public static void main(String[] args) throws CloneNotSupportedException {
   Student s = new Student("barath", 18, "electronics", 1);
   Student s1 = s;
   Student s2 = (Student) s.clone();
   s.name = "hari";
   s.dept.name = "maths";
   s.display();
   s1.display();
   s2.display();
   
	}

}
