package taxi_booking;
import java.util.ArrayList;
import java.util.Scanner;

    public class Booking {
     	private Scanner s =  new Scanner(System.in);
	    private int bookingId=0;
	    private String customerName;
	    private char pickup;
	    private char drop;
	    private int time;
	    private int dropTime;
	    private int earn=100;
	    private int totalEarn=0;
	    ArrayList<Taxi>taxi = new ArrayList<Taxi>();
	 public Booking(){}
	 public Booking(int val) {
		for(int i=0; i<val; i++) {
		taxi.add(new Taxi());
		taxi.get(i).location='a';}}
	 public int Book() {
		System.out.println("Enter your Name: ");
		customerName = s.next();
//		customerName = random.randString(random.randInt(7));
		System.out.println("Enter your location: ");
		pickup = s.next().charAt(0);
//		pickup = random.randChar_ae();
		int p=pickup;
		if(97>p ||  p>106) {System.out.println("Invalid location.."); return 0;}
		System.out.println("Enter your Destination: ");
		drop = s.next().charAt(0);
//		drop = random.randChar_ae();
		if(pickup==drop) {System.out.println("you  are already there..."); return 0;}
		int d=drop;
		if(97>d ||  d>106) {System.out.println("Invalid location.."); return 0;}
		System.out.println("Enter time: ");
		time = s.nextInt();
//		time = random.randInt(10);
		if(getTaxi(pickup, drop, time)==-1) {System.out.println("Sry no taxi avilable\n\n");return 0;}
		bookingId++;
	    int index =  getTaxi(pickup, drop, time);
		System.out.println("Taxi No "+(index+1)+" is allocated");
		taxi.get(index).bookingId.add(bookingId);
		taxi.get(index).customerId.add(customerName);
		taxi.get(index).from.add(pickup);
		taxi.get(index).to.add(drop);
		taxi.get(index).location=drop;
		char dd=drop;
		char dp=pickup;
		if(pickup>drop) { char s=pickup;pickup=drop;drop=s;}
		taxi.get(index).pickupTime.add(time);
		dropTime = time+(drop-pickup);
		taxi.get(index).dropTime.add(dropTime);
		earn = earn+((((drop-pickup)*15)-5)*10);
		taxi.get(index).earn.add(earn);
		taxi.get(index).freetime=dropTime;
		taxi.get(index).earnings=taxi.get(index).earnings+earn;
		DataBase db = new DataBase();
		db.insert(index,customerName, dp, dd, time, dropTime, earn);
		earn=100;
		System.out.println();
		System.out.println(); return 0;}
	 private int getTaxi(char pic, char drop, int time) {
		if(isTaxi(pic, drop, time)!=-1) {return isTaxi(pic, drop, time);}
		int p=pic;
		for(int i=1; i<11; i++) {
			pic = (char) (p+i);
			if(pic<107)
			   if(isTaxi(pic, drop, time)!=-1) {return isTaxi(pic, drop, time);}
			pic = (char) (p-i);
			if(pic>96)
			if(isTaxi(pic, drop, time)!=-1) {return isTaxi(pic, drop, time);}}
		return -1;}
	 private int isTaxi(char pic, char drop, int time) {
		int freeTaxiCount=0;
		int freeTaxiIndex=0;
		for(int i=0; i<taxi.size(); i++) {
			if(taxi.get(i).location==pic&&taxi.get(i).freetime<=time) { freeTaxiCount++;freeTaxiIndex=i;}}
		if(freeTaxiCount>1) {
			int earn=Integer.MAX_VALUE;
		    int taxiIndex=0;
			for(int i=0; i<taxi.size(); i++) {
				if(taxi.get(i).location==pic&&taxi.get(i).freetime<=time) {
				if(taxi.get(i).earnings<earn) {earn=taxi.get(i).earnings; taxiIndex=i;}}}
			return taxiIndex;} 
		if(freeTaxiCount==1) { return freeTaxiIndex;}
	    if(freeTaxiCount==0) {
	    	return -1;}return 0;}
	 public void display() {
	    for(Taxi t: taxi) {
	    	 totalEarn+=t.earnings;}
	    System.out.println("ZOHO TRAVELS         Total Earnings: $"+ totalEarn);
		 
		for(int i=0; i<taxi.size();i++) {
			taxi.get(i).display(i);}}
	 public void customerTaxiInfo() {
		 for(int i=0; i<taxi.size(); i++) {
			 System.out.print("\t\tTaxi-"+(i+1)+"--->>>    ");
			 taxi.get(i).C_display();}}
	 public void trackTaxi() {
		 System.out.print("\n\t\t\tEnter taxi Number: ");
		 int taxiNo = s.nextInt();
		 taxiNo--;
		 System.out.println("\n\t\t\t1.track location\n\t\t\t2.available Time\n\t\t\t3.location\n\t\t\t4.Earnings\n\t\t\t5.All details\n\t\t\t6.Change Taxi..\n\t\t\t0.To main menu...");
		 while(true) {
		 System.out.print("\t\t\tChoice? ");
		 int choice = s.nextInt();
		 switch(choice) {
		 case 1: System.out.println("\t\t\t\t--->>>Taxi at "+track(taxiNo,0)); break;
	     case 2: System.out.println("\t\t\t\t--->>>Avilable after "+taxi.get(taxiNo).freetime);break;
		 case 3: System.out.println("\t\t\t\t--->>>Location :"+taxi.get(taxiNo).location);break;
		 case 4: System.out.println("\t\t\t\t--->>>Earned : $"+taxi.get(taxiNo).earnings);break;
		 case 5: System.out.println("\t\t\t\t--->>>Avilable after "+taxi.get(taxiNo).freetime);
		         System.out.println("\t\t\t\t--->>>Location :"+taxi.get(taxiNo).location);
		         System.out.println("\t\t\t\t--->>>Earned   :$"+taxi.get(taxiNo).earnings);break;
		 case 6: trackTaxi(); return;
		 case 7: while(true) {
			 char returned = track(taxiNo,0);
			 if(returned=='_') {break;}
			 System.out.println("\t\t\t\t--->>>Taxi at "+returned);};
		 case 0: return;}}}
private char track(int taxiNo, int skip) { 
		 int timee =3;
		 if(skip!=0) { timee = skip;}
		 else {
		 System.out.print("\t\t\t\tEnter the time: ");
		 timee = s.nextInt();}
		 if(timee <0) { return '_';}
		 Taxi temp = taxi.get(taxiNo);
		 ArrayList drop = temp.dropTime;
	     ArrayList pick = temp.pickupTime;
	     if(timee<(int)pick.get(0)) {return 'a';}
		 if(temp.to.size()==0) {return 'a';}
		 if(timee>=temp.freetime) {return temp.location;}
	     int index=-1; int dropTime=0,pickTime=0;
		 for(int i=temp.to.size()-1;i>=0;i--) {
			 dropTime = (int) drop.get(i);
			 pickTime = (int) pick.get(i);
			 if(dropTime>=timee&&pickTime<=timee) {index=i; break;}}
		 if(index!=-1) { 
			 int st = temp.from.get(index);
			 int to = temp.to.get(index);
			 int difference = timee-pickTime;
			 if(st<to) {return (char)(st+difference);}
			 if(st>to) {return (char)(st-difference);}}
		 int next=1;
		 for(int i=0; i<temp.from.size(); i++) {
			 if((int)drop.get(i)<timee&&(int)pick.get(next)>timee) {return temp.to.get(i);}}
		 return '-';}
public void map() {
		 System.out.println("\t\t1.past Map...\n\t\t2.final location map...\n\t\t0.main menu....\n");
		 while(true) {
		 System.out.print("\t\tChoice?");
		 int choicee = s.nextInt();
		 if(choicee==1) {pastMap();continue;}
		 if(choicee==2) {
		 System.out.println("\t\t\t\tStops--->>>\tA\tB\tC\tD\tE\tF\tG\tH\n");
		 for(int j=0; j<taxi.size(); j++) {mapPrint(j);}}
		 if(choicee==6) {while(true) {int k= pastMap(); if(k<0) {break;}}}
		 if(choicee==0) {return;}}}
private void mapPrint(int i) {
		 int start = 'a';
		 int end = taxi.get(i).location;
		 int length = end-start;
		 System.out.print("\t\t\t\tTaxi "+(i+1)+"--->>>\t");
		 for(int k=0; k<length;  k++) {System.out.print("\t");}
		 System.out.println(i+1);}
public int pastMap() {
		   System.out.print("\n\t\t\tEnter the time: ");
		   int time  = s.nextInt();
		   if(time==0) {return 0;}
		   if(time<0) {return time;}
	       System.out.println("\n\t\t\t\tStops--->>>\tA\tB\tC\tD\tE\tF\tG\tH\n");
           for(int j=0; j<taxi.size(); j++) {pastMapPrint(j, time);}return 0;}
private void pastMapPrint(int i, int time) {
		 int start = 'a';int end = 'a'; int k=0;
		 if(taxi.get(i).to.size()!=0) {
		 end = track(i, time);}
		 int length = end-start;
		 System.out.print("\t\t\t\tTaxi "+(i+1)+"--->>>\t");
		 for(k=0; k<length;  k++) {System.out.print("\t");}
		 System.out.println(i+1);}

         
}