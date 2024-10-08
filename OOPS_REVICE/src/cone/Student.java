package cone;
public class Student implements Cloneable {
   String name ;
   int age;
   int yr;
   department dept=new department();
   Student(String n, int a, int y, String d, String h){name=n; age =a; yr=y; dept.DeptName=d; dept.hod=h;}
   Student(Student s){
	   name = s.name;
	   age = s.age;
	   yr = s.yr;
	   dept.DeptName = s.dept.DeptName;
	   dept.hod = s.dept.hod;
   }
   void display() {
	   System.out.println();
	   System.out.println("------------------------------------");
	   System.out.println(name);
	   System.out.println(age);
	   System.out.println(yr);
	   System.out.println(dept.DeptName);
	   System.out.println(dept.hod);
	   System.out.println("-------------------------------------");
	   System.out.println();
   }
   protected Object clone() throws CloneNotSupportedException {
	   Student temp = (Student) super.clone();
	   temp.dept = (department) dept.clone();
	   return temp;
   }
   
}
