package cinima;
import java.sql.DriverManager;
import java.util.*;
import java.sql.*;
public class Signinup {
			   Scanner s = new Scanner(System.in);
			   Theatre theatre = new Theatre();
			   Connection connection;
		       Statement statement;
		       PreparedStatement ps; 
			   ResultSet rs;
			   
			   
		      Signinup(){
		    	   try {
		    	   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CINIMA","root","2004");
		    	   statement =connection.createStatement();
		    	   }catch(Exception e){e.printStackTrace();}}
		 
		      
		    
		      void TheatreSignup() {
		    	  System.out.print("Enter the Theatre Name: ");
		    	  String name = s.next();
		    	  String pass1="";
		    	  while(true) {
		    	  System.out.print("Enter password: ");
		    	  pass1 = s.next();
		    	  System.out.print("ReEnter password: ");
		    	  String pass2 = s.next();
		    	  if(!(pass1.equals(pass2))){
		    			  System.out.println("Password Mismatch....");
		    			  continue;}
		    	  else break;}
		    	  System.out.print("Enter the capacity: ");
		    	  int cap = s.nextInt();
		    	  System.out.print("Enter the Location: ");
		    	  String location = s.next();
		    	  System.out.print("Enter Contact No: ");
		    	  String phn = s.next();
		    	 
		    	//   inserting into database
		    	  try {
  	    	      ps = connection.prepareStatement("INSERT INTO THEATRE VALUES(?,?,?,?,?)");
   	    	      ps.setString(1, name);
		    	  ps.setString(2, pass1);
		    	  ps.setInt(3, cap);
		    	  ps.setString(4, location);
		    	  ps.setString(5, phn);
 		    	  ps.executeUpdate();
		    	  String str = "CREATE TABLE " +  name + " (S_DATE VARCHAR(30),S_STIME VARCHAR(30),S_ETIME VARCHAR(30),S_NAME VARCHAR(100),S_TPRICE1 INT,S_PAV1 INT,S_TPRICE2 INT,S_PAV2 INT,S_TPRICE3 INT,S_PAV3 INT,S_SEATSREMAIN INT)";
		      	  ps = connection.prepareStatement(str);
		 		  ps.executeUpdate();		 		 
		 		  }catch(Exception e ) {e.printStackTrace();}}
		      
		      
		      void theatreSignin() {
		    	  System.out.print("Enter your Theatre Name: ");
		    	  String name = s.next();
		    	  System.out.print("Enter password: ");
		    	  String pass = s.next();
		    	  theatre.go(name);}
		      
		      
}