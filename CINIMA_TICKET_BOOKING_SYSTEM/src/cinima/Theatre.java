package cinima;
import java.sql.*;
import java.util.*;
public class Theatre {
		Scanner  s;
		Connection connection;
		Statement statement;;
	    PreparedStatement ps;
	    ResultSet rs;

		Theatre(){
			try {
		    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CINIMA","root","2004");
	 	    statement =connection.createStatement();
			s = new Scanner(System.in);
		   }catch(Exception e) {e.printStackTrace();}}
	   
		void go(String name) {
			System.out.println("1.Add Show\n2.change Password\nChoice?");
			int choice = s.nextInt();
			if(choice==1)
				addShow(name);
			if(choice==2)
			    changePassword(name);
			
	    	
	    }
	    
	    void addShow(String Name) {
	    	System.out.print("Enter the date(dd//mm/yyyy): ");
	    	String date = s.next();
	    	System.out.println("Enter the Movie name: ");
	    	String name = s.next();
	    	System.out.println("Enter movie StartTime: ");
	    	String sTime = s.next();
	    	System.out.println("Enter movie End Time: ");
	    	String eTime = s.next();
	    	System.out.println("Enter highest ticket Price: ");
	    	int price1  = s.nextInt();
	    	System.out.println("Enter avilable tickets: ");
	    	int avl1 = s.nextInt();
	    	System.out.println("Enter the Mid ticket Price: ");
	    	int price2 = s.nextInt();
	    	System.out.println("Enter avilable tickets: ");
	    	int avl2 = s.nextInt();
	    	System.out.println("Enter the lowest ticket Price: ");
	    	int price3 = s.nextInt();
	    	System.out.println("Enter avilable tickets: ");
	    	int avl3 = s.nextInt();
	    	System.out.println("Enter totalSeats: ");
	    	int seats = s.nextInt();
	    	
	    	try {
	    	String str = "INSERT INTO "+Name+" VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	    	ps = connection.prepareStatement(str);
	    	ps.setString(1, date);
	    	ps.setString(2, sTime);
	    	ps.setString(3, eTime);
	    	ps.setString(4, name);
	    	ps.setInt(5, price1);
	    	ps.setInt(6, avl1);
	    	ps.setInt(7, price2);
	    	ps.setInt(8, avl2);
	    	ps.setInt(9, price3);
	    	ps.setInt(10, avl3);
	    	ps.setInt(11, seats);
	    	ps.executeUpdate();
	    	 
	    	}catch(Exception e) {e.printStackTrace();}}
	

	    void changePassword(String name) {
	    	  System.out.println("iir");

	    	  for(int i=0; i<3; i++) {
	    	  System.out.println("Enter your old password: ");
	    	  String pass = s.next();
	    	  if(verify(name, pass)) {
	    		  System.out.println("Enter the New Password: ");
	    		  String pass1 = s.next();
	    		  System.out.println("ReEnter password: ");
	    		  String pass2 = s.next();
	    		  if(pass1.equals(pass2)) {
	    			  try {
	    				  String str = "UPDATE THEATRE SET T_PASSWORD = ? WHERE T_NAME = ?";
	    				  ps = connection.prepareStatement(str);
	    				  ps.setString(1, pass1);
	    				  ps.setString(2, name);
	    				  ps.executeUpdate();
	    			  }catch(Exception e) {e.printStackTrace();}}
	    		  else {
	    			  System.out.println("password Mismatch..."); 
	    			  continue;}}
	    	  else {
	    		  System.out.println("Wrong Password..");
	    		  continue;}}}
	      
	      
	      
	      boolean verify(String name , String pass) {
	    	  try {
	    	  rs = statement.executeQuery("SELECT * FROM THEATRE");
	    	  while(rs.next()) {
	    		  if(rs.getString(1).equals(name)&&rs.getString(2).equals(pass))
	    			  return true;}
	    	  }catch(Exception e) {e.printStackTrace();}
	    	  return false;}
	      
	      void test(String name, int seats) {
	    	  try {
	      String str2 = "CREATE TABLE " +  name + "seat (col Int primary Key, r1 CHAR(2), r2 CHAR(2), r3 CHAR(2), r4 CHAR(2), r5 CHAR(2), r6 CHAR(2), r7 CHAR(2), r8 CHAR(2), r9 CHAR(2), r10 CHAR(2), r11 CHAR(2), r12 CHAR(2), r13 CHAR(2), r14 CHAR(2), r15 CHAR(2), r16 CHAR(2), r17 CHAR(2), r18 CHAR(2), r19 CHAR(2), r20 CHAR(2));";
 		  ps = connection.prepareStatement(str2);
 		  ps.executeUpdate();
 		  for(int i=20; i<=seats; i+=20) {
 		  String str3 = "INSERT INTO "+name+"seat Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
 		  ps = connection.prepareStatement(str3);
 		  ps.setInt(1, i/20);
 		  for(int x =1; x<21;i++) {
 		  String st =Integer.toString(((i/20)*10)+x);
 		  ps.setString(x+1, st);}
 		  ps.executeUpdate();}
 		  }catch(Exception e) {e.printStackTrace();}
 		  }
	      
}
	      
	      






