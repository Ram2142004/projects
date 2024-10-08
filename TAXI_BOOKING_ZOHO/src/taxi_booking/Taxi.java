package taxi_booking;
import java.util.ArrayList;

public class Taxi extends Booking {
	 protected char location='a';     
	 protected int freetime=1;     
	 protected int earnings=0;
	 protected ArrayList<Integer>bookingId = new ArrayList<Integer>();
	 protected ArrayList<String>customerId = new ArrayList<String>();
	 protected ArrayList<Character>from = new ArrayList<Character>();
	 protected ArrayList<Character>to = new ArrayList<Character>();
	 protected ArrayList<Integer>pickupTime = new ArrayList<Integer>();
	 protected ArrayList<Integer>dropTime = new ArrayList<Integer>();
	 protected ArrayList<Integer>earn = new ArrayList<Integer>();
	 protected void display(int x) {
	   System.out.println();
	   System.out.println();
	   System.out.println("Taxi-"+(x+1)+"     Total Earnings: $"+ earnings  +"     Total trips: "+to.size());
	   for(int i=0; i<to.size(); i++) {
		   System.out.println("  TRIP "+ (i+1)+" :");
		   System.out.print("       Customer name: " + customerId.get(i)+"   ");
		   System.out.print("booking id: " + bookingId.get(i)+"    ");
		   System.out.print("From: "+from.get(i)+"   ");
		   System.out.print("To: "+to.get(i)+"  ");
		   System.out.print("PickupTime: "+pickupTime.get(i)+"  ");
		   System.out.print("Drop Time: "+dropTime.get(i)+"  ");
		   System.out.print("Earned :$"+earn.get(i)+"  ");
		   System.out.println();}}
	 protected void C_display() {
		   System.out.print("\tLocation: "+location);
		   System.out.print("\t  Avilable after "+freetime+"'o clk....");
		   System.out.println("\tEarned: $"+earnings);}
	
	 
	 
	 
}