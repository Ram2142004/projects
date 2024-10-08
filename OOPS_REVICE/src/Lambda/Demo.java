package Lambda;
public class Demo {
	public static void main(String[] args) {
      SAM s = new SAM() {         // overrid
    	  public void ride() {System.out.println(" i am riding..........");}};
      
      // lambda expression
     SAM s1 =()->System.out.println("hello from sam interface");
     
     s.ride();
     s1.ride();
}}
