package inheritence;
public class Dynamic {
     public static void main(String[]args) {
    	 Employee e[] = new Employee[10];
         e[0] = new Employee("barath", 20000) ;
         e[1] = new Employee("barath", 40000) ;
             e[1].raiseSalary(10);
         e[2] = new Manager("barath", 100000, 20000);
             e[2].raiseSalary(20);
         e[3] = new Manager("barath", 140000, 40000);
   //for print
         for(Employee i : e) {
        	 i.display();
        	 System.out.println("--------------------");
         }
}}
