package number_thinking;
import java.util.*;

public class Num_Guess {
	void game() {
		  Random rand = new  Random();
		  Scanner s = new Scanner(System.in);
		  while(true) {
	      System.out.println("Enter your name....");
	      String name= s.next();
		  int No = rand.nextInt(0, 11);
		  System.out.println("Can u guess the number(0 to 10) ...i am thinking ");
		  int choice = 21;int i;
		  for(i=1; i<=4; i++) {
		  System.out.println("Your guess..");
		  choice = s.nextInt();
		  if(choice == No) {System.out.print("Congrats "); print(name); System.out.println(" You won..\n");break;}
		  if(choice<No) {System.out.println("guess high");}
		  if(choice>No) {System.out.println("guess low");}
		  System.out.println(5-i + " attemts remaining...");}
		  if(i<5)
			  continue;
		  System.out.println("You Lost...");System.out.println("Answer: "+No+"\n");}}
	  
	  public void print(String name) {
	 	 for(int i=0; i<name.length(); i++) {
	 		  System.out.print(name.charAt(i));
	 	     try { Thread.sleep(250);}
	 	     catch(Exception e) {}}}

	
}
