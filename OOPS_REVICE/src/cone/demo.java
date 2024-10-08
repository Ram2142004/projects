package cone;
public class demo {
	public static void main(String[] args) throws CloneNotSupportedException {
     Student s = new Student("barath", 18, 2, "elect", "jp");
     Student s1 = (Student) s.clone();
     Student s2  = s;
     s.name = "hari";
     s.dept.DeptName="maths";
     s.display();
     s1.display();
     s2.display();
	}

}
