package oops_revice;
import java.util.Scanner;
public class Prime {
	public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Use u = new Use();
    System.out.println("Enter the range: ");
    int count=0;
    int range = s.nextInt();
    long total =0;
    
    for(int number=2; number<=range; number++) { 
    	boolean value = true;
        for(int i=2; i<=9; i++) {
    	if(i!=number)
    		if(number%i==0)
    			value=false;}
    if(value == true) {
    	int numberd = u.digitCount(number);
    	int ranged = u.digitCount(range);
    	while(numberd<ranged-1) {
    		System.out.print("0");
    		numberd++;}
    	System.out.print(number+",");
    	total = total+number;
        count++;
        if(count%15==0)System.out.println();}}
    System.out.println();
    System.out.println("total no of PrimeNumbers: "+ count);
    System.out.println("total of primeNumbers "+ total);
    
    
	

}}
