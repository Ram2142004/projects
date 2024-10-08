package student_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

class TEACHER{
    Connection connection;
    Statement statement;
    Connection connection2;
    Statement statement2;
    PreparedStatement ps;
    ResultSet stInfo;
    ResultSet attend;
    ResultSet traverce;
    ResultSet notify;
    Scanner s;
  TEACHER(){
	   try {
          connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENT_MANAGEMENT","root","2004");
	      statement =connection.createStatement();
	      connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENT_MANAGEMENT","root","2004");
	      statement2 =connection2.createStatement();
	      s = new Scanner(System.in);}
	   catch(Exception e) {e.printStackTrace();}}

     void attendence(String name) {
    	 System.out.println("1.Take attendence\n2.Mark Absents\n3.clr attendence\n4.give attendence\n5.Notify students\n6.Delete notifications\n"
    	 		+ "7.change password\n0.signout");
    	 while(true) {
         System.out.print("\nChoice? ");
    	 int choice = s.nextInt();
    	 if(choice==1) 
    		 takeAttendence();
    	 if(choice==2) 
    		 markAbsents();
    	 if(choice==3)
    		 clearAttendence();
    	 if(choice==4)
    		 giveAttendence();
    	 if(choice==5)
    		 Notify(name);
    	 if(choice==6)
    		 deleteNotify(name);
    	 if(choice==7)
    		 changepassword(name);
    	 if(choice==0)
    		 return;}}
     
     void takeAttendence() {
    	 System.out.println("Enter date: ");
    	 String date = s.next();
    	 System.out.println("Enter hour: ");
    	 String hr = s.next();
    	 System.out.println("1.present\n0.absent");
    	 try {
    	 
    	 traverce = statement2.executeQuery("select * from student");
    	 while(traverce.next()) {
    		 
    		 int rollNo =Character.getNumericValue(traverce.getString(1).charAt(6))*10;
    		 rollNo+=Character.getNumericValue(traverce.getString(1).charAt(7));
    		 int i=rollNo;
    		 boolean  value = true;
    			 String result = "";
     	         System.out.print(traverce.getString(3)+ "  RollNo " +i+" :");
     		     int r = s.nextInt();
     		     if(r==1) { result="PRESENT";}
    		     else {result="ABSENT";}
    			
//check whether new or already there
     		     String query="SELECT * FROM ATTEND"+i;
    			 attend = statement.executeQuery(query);
    			 while(attend.next()) {
    				 if(attend.getString(1).equals(date))
    					 value = false;}
//create if needs
    			 if(value) {
    			 ps=connection.prepareStatement("insert into attend"+i+ " values(?,'NE','NE','NE','NE','NE')");
      			 ps.setString(1, date);
   			     ps.executeUpdate();}
//update absent or present
    				String q = "UPDATE ATTEND"+i+" SET HR"+hr+" = ? WHERE _DATE = ?";
    			    ps=connection.prepareStatement(q);
    			    ps.setString(1, result);
    			    ps.setString(2, date);
    			    ps.executeUpdate();}}
    			
    		 catch(Exception e) {e.printStackTrace();}}
     
     public void markAbsents(){
    	 System.out.println("Enter date: ");
    	 String date = s.next();
    	 System.out.println("Enter hour: ");
    	 String hr = s.next();
    	 System.out.print("Enter absents: ");
    	 boolean   value=true;
    	 int roll;
    	 try {
//check new one or already there
	        attend = statement.executeQuery("select * from ATTEND1");
	        while(attend.next()) {
		    if(attend.getString(1).equals(date))
			      value = false;}
//to create if needs
	        if(value) {
	             traverce = statement2.executeQuery("select * from student");
	    	     while(traverce.next()) {
	    	     int rollNo =Character.getNumericValue(traverce.getString(1).charAt(6))*10;
	        	 rollNo+=Character.getNumericValue(traverce.getString(1).charAt(7));
	        	 int i=rollNo;
	        	 ps=connection.prepareStatement("insert into attend"+i+ " values(?,'NE','NE','NE','NE','NE')");
      			 ps.setString(1, date);
   			     ps.executeUpdate();}}
//update absents	        
	            traverce = statement2.executeQuery("select * from student");
	    	    while(traverce.next()) {
	        	roll = s.nextInt();
	        	if(roll<0) {break;}
	        	String q = "UPDATE ATTEND"+roll+" SET HR"+hr+" = ? WHERE _DATE = ?";
 			    ps=connection.prepareStatement(q);
 			    ps.setString(1,  "ABSENT");
 			    ps.setString(2, date);
 			    ps.executeUpdate();}
//others present	    	    
	    	    traverce = statement2.executeQuery("select * from student");
	       	    while(traverce.next()) {
	        	int localhr = Integer.parseInt(hr); localhr++;
	        	int rollNo =Character.getNumericValue(traverce.getString(1).charAt(6))*10;
	    		rollNo+=Character.getNumericValue(traverce.getString(1).charAt(7));
	    		int i=rollNo;
	        	attend = statement.executeQuery("select * from ATTEND"+i);
	        	while(attend.next()){
	        	if(attend.getString(localhr).equals("NE")&&attend.getString(1).equals(date)) {
	        		String q = "UPDATE ATTEND"+i+" SET HR"+hr+" = ? WHERE _DATE = ?";
	 			    ps=connection.prepareStatement(q);
	 			    ps.setString(1,  "PRESENT");
	 			    ps.setString(2, date);
	 			    ps.executeUpdate();}}}
	        	}
	         	 catch(Exception e) {e.printStackTrace();}}
    		
    	 
     
     void clearAttendence() {
    	 for(int i=1; i<=50; i++) {
    		 String str = "DELETE FROM ATTEND"+i;
    		 try {
    		 ps=connection.prepareStatement(str);
    		 ps.executeUpdate();}
    		 catch(Exception e) {e.printStackTrace();}}}
    	 
     
     
    void giveAttendence() {
    	try {
    	 traverce = statement2.executeQuery("select * from student");
    	 System.out.println("Enter the date: ");
    	 String date = s.next();
    	 while(traverce.next()) {
    		 int rollNo =Character.getNumericValue(traverce.getString(1).charAt(6))*10;
    	     rollNo+=Character.getNumericValue(traverce.getString(1).charAt(7));
    		 int i=rollNo;
    		String str = "INSERT INTO ATTEND"+i+" values(?,?,?,?,?,?)";
    	    ps = connection.prepareStatement(str);
    	    ps.setString(1, date);
    	    ps.setString(2, "PRESENT");
    	    ps.setString(3, "PRESENT");
    	    ps.setString(4, "PRESENT");
    	    ps.setString(5, "PRESENT");
    	    ps.setString(6, "PRESENT");
    	    ps.executeUpdate();}}
    	catch(Exception e) {e.printStackTrace();}}
    
    
    
    
    void Notify(String name) {
    	try {
    	 System.out.println("Enter Message:  ");
    	 String msg = s.nextLine();
    	 msg = s.nextLine();
    	 attend = statement.executeQuery("SELECT * FROM NOTIFI");
    	 int count =1;
    	 while(attend.next())
    		 count++;
   		 ps = connection.prepareStatement("INSERT INTO NOTIFI  VALUES (?,?,?)");
   		 ps.setInt(1, count);
   		 ps.setString(2, msg );
   		 ps.setString(3, name);
   		 ps.executeUpdate();
    	}catch(Exception e) {e.printStackTrace();}}
    
    void deleteNotify(String name){
    	try {
    	attend = statement.executeQuery("SELECT * FROM NOTIFI");
    	while(attend.next()) {
    		System.out.println(
    				attend.getInt(1)
    				+"\t"+
    				attend.getString(2)+
    				"\t"+
    				attend.getString(3));}
    	System.out.println("Enter the index to delete: ");
    	int index = s.nextInt();
    	ps=connection.prepareStatement("DELETE FROM NOTIFI WHERE _NO = ?");
    	ps.setInt(1, index);
    	ps.executeUpdate();
    	}catch(Exception e) {e.printStackTrace();}}
    

     void changepassword(String name) {
    	 try {
    	 boolean access = verify(name);
    	 if(!access) 
    		 System.out.println("Wrong Password..");
    	 if(access) {
    		 while(true) {
    		 System.out.print("Enter your new Password: ");
    		 String pass1 = s.next();
    		 System.out.print("Re Enter the password: ");
    		 String pass2 = s.next();
    		 if(!(pass1.equals(pass2))) {
    			 System.out.println("Password mismatch: "); continue;}
    		 ps = connection.prepareStatement("UPDATE TEACHER SET PASSWORD = ? WHERE USERNAME = ?");
    		 ps.setString(1, pass1);
    		 ps.setString(2, name);
    		 ps.executeUpdate();
    		 System.out.println("Updated successfully...");
    		 break;}}
    	 }catch(Exception e) {e.printStackTrace();}
     }


      boolean verify(String name) {
    	  System.out.println("Enter your old password");
    	  String pass = s.next();
   		try {
   			stInfo = statement.executeQuery("SELECT * FROM TEACHER");
   			while(stInfo.next()) {
   		    if(pass.equals(stInfo.getString(2))&&name.equals(stInfo.getString(1))) {return true; }}
   		}catch(Exception e) {e.printStackTrace();}
   	    return false;}
     
     
}
     
     
     
     
     
     

