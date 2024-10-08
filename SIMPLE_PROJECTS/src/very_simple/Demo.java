package very_simple;
import java.util.*;
import java.math.*;
public class Demo {
	static Scanner s ;
	public static void main(String[] args) {
     s = new Scanner(System.in);
     Salary sal = new Salary();
     sal.salary();
     
	}
	
	
	
	
	 
	
	 static int abs(int val) {return (int)Math.sqrt(val*val);}
	
	
     static void differ() {
     int n = 5; int arr[]= new int[n];
     System.out.println("Enter the Numbers: ");
     for(int i=0; i<n ; i++) 
    	 arr[i]=s.nextInt();
     while(n>1) {
     for(int i=0; i<n-1; i++) 
    	 arr[i]=abs(arr[i+1]-arr[i]);
    	 n--;}
     System.out.println(arr[0]);}

}
