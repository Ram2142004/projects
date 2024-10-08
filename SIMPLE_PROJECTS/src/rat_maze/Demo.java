package rat_maze;
import java.util.*;
public class Demo {
	public static void main(String[] args) {
     RatMaze maze = new RatMaze();
     Scanner s = new Scanner(System.in);
     
     
     while(true) {
     System.out.println("Enter the Number 1: ");
     int no1 = s.nextInt();
     System.out.println("Enter the Number 2: ");
     int no2 = s.nextInt();
     System.out.println("1.add\n2.sub\n3.mul\n4.div\n0.change No");
     while(true) {
    	 System.out.println("Choice: ");
         int choice = s.nextInt();
    	 if(choice==1) {System.out.println("Ans: "+ (no1+no2));}
    	 if(choice==2) {System.out.println("Ans: "+ (no1-no2));}
    	 if(choice==3) {System.out.println("Ans: "+ (no1*no2));}
    	 if(choice==4) {System.out.println("Ans: "+ (no1/no2));}
    	 if(choice==5) break;
    	 }
	}}}
