package annonomus;
public class Demo {
	public static void main(String[] args) {
     Annonomus a1 = new Annonomus();
     Annonomus a2 = new Annonomus() {   // annonomus class
    	 void ride() {
    		 System.out.println("i am riding a bike");}};
     Annonomus a3 = new Annonomus();
     
     a1.ride();
     a2.ride();
     a3.ride();
    
     
    
	

}}
