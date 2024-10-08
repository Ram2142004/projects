package oops_revice;
public class Static_Method {
       private static int  BOX_COUNT;
       static {setBOX_COUNT(0);}
       Static_Method(){setBOX_COUNT(getBOX_COUNT() + 1);}
//display
       void displayObjzCount() {System.out.println("Obj count: "+ getBOX_COUNT());}
//get set
	public static int getBOX_COUNT() {return BOX_COUNT;}
	public static void setBOX_COUNT(int bOX_COUNT) {BOX_COUNT = bOX_COUNT;}
       
       
       
} 
