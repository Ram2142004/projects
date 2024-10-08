package DSA.array;
import java.util.Scanner;
public class Demo {
	public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Array list = new Array();
	int pos, val;
    int Length = list.getPeek();
    System.out.println("----------List Menu----------");
	System.out.println("1. Insert At End  ");
	System.out.println("2. Display list ");
	System.out.println("3. Insert at specified Position ");
	System.out.println("4. Delete from Specified Position ");
	System.out.println("5. Exit ");
	System.out.println("----------------------------------");
	System.out.println();
	while(true) {
	System.out.println("Enter the choice....");
	int choice = scanner.nextInt();
	switch(choice) {
	case 1: System.out.println("Enter the data :  ");
	        val= scanner.nextInt();
	        list.add(val);
	        break;
	case 2: list.display();
	        break;
	case 3: System.out.println("Enter the position(Starts at 0 upto "+(Length)+")");
	        pos = scanner.nextInt();
	        if(pos<0 || pos>Length) {
	        	System.out.println("Invalid pos...");
	        	continue;}
	        System.out.println("Enter the data :  ");
	        val= scanner.nextInt();
	        list.insertAtPos(pos, val);
	        break;
	case 4: list.display();
		    System.out.println("Enter the position(starts at 0 upto "+ (Length)+")");
            pos = scanner.nextInt();
            if(pos<0 || pos>Length)
	        	{System.out.println("Invalid pos...");
                continue;}
            list.deleteAtPos(pos);
            break;
	case 5: System.exit(0);
   default: System.out.println("invalid choice....");
            continue;
	
	}}

}}	    	