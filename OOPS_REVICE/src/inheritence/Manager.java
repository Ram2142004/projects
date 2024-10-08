package inheritence;
public class Manager extends Employee {
   protected int bonus;
//  constructor
   Manager(String n, int s, int b){super(n, s); bonus =b;}
//get set
   void setBonus(int b) {bonus =b;}
   int getBonus() {return bonus;}
   public int getSalary() { return super.salary+getBonus();}
//  display
   void display() {
	   super.display();
	   }
int getsalary(){
	return super.salary+bonus;
}
	
	
}
