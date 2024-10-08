package student_management;

import java.sql.*;
import java.util.Scanner;

public class STUDENT {
	 Connection connection;
	    Statement statement;
	    PreparedStatement ps;
	    ResultSet stInfo;
	    ResultSet attend;
	    Scanner s;
	  STUDENT(){
		   try {
	          connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENT_MANAGEMENT","root","2004");
		      statement =connection.createStatement();
		      s = new Scanner(System.in);}
		   catch(Exception e) {e.printStackTrace();}}

	  void StudentInfo(String roll) {
		  System.out.print("1.Profile\n2.Everyday Attendence \n3.overall Attendence\n4.Attendence Percentage\n5.Notificatons\n6.change password\n0.signout");
		  while(true) {
			  System.out.print("\nChoice? ");
			  int choice = s.nextInt();
		  if(choice==1)
			  profile(roll);
		  if(choice==2)
			  EveryDayattendence(roll);
		  if(choice==3)
			  attendence(roll);
		  if(choice==4)
			  Atpercentage(roll);
		  if(choice==5)
			  Notifications();
		  if(choice==6)
			  changepassword(roll);
		  if(choice==0)
			  return;}}
	  
		
	  void profile(String str) {
		  try {
			  stInfo = statement.executeQuery("select * FROM STUDENT");
			  while(stInfo.next()){
				  if(stInfo.getString(1).equals(str)) {
					   System.out.println();
			           System.out.println(
			        		"Name : "+
			                 stInfo.getString(3)+ 
			                "\nRoll No: "+
			                 stInfo.getString(1)+
			                 "\nMobile: "+
			                 stInfo.getString(4)+
			                  "\nGmail: "+
			                 stInfo.getString(5));
			           System.out.println();
		  }}}
		  catch(Exception e) {e.printStackTrace();}}
	  
	  void EveryDayattendence(String str) {
		  try {
			  int rollNo =Character.getNumericValue(str.charAt(6))*10;
	    	  rollNo+=Character.getNumericValue(str.charAt(7));
	          int i=rollNo;
			  String s = "SELECT * FROM ATTEND"+i;
			  attend = statement.executeQuery(s);
			  if(!attend.next()) {System.out.println("\tNo data found...");return;}
			  attend = statement.executeQuery(s);
			  System.out.println("\n");
			  System.out.println("DATE\t\tHour1\tHour2\tHour3\tHour4\tHour5\n");
			     while(attend.next()) {
			     System.out.println(
	        	     attend.getString(1)+"\t"+
	        	     attend.getString(2)+"\t"+
	        	     attend.getString(3)+"\t"+
	        	     attend.getString(4)+"\t"+
	        	     attend.getString(5)+"\t"+
	        	     attend.getString(6));}}
			  catch(Exception e) {e.printStackTrace();}}
	  
	  void attendence(String str) {
		  try {
		  int rollNo =Character.getNumericValue(str.charAt(6))*10;
    	  rollNo+=Character.getNumericValue(str.charAt(7));
          int i=rollNo;
		  String s = "SELECT * FROM ATTEND"+i;
		  attend = statement.executeQuery(s);
		  if(!attend.next()) {System.out.println("\tNo data found...");return;}
		  attend = statement.executeQuery(s);
		  String p = "PRESENT";
		  System.out.println("\tDATE\t\tResult");
		  while(attend.next()) {
			  String result =" ";
				  if(attend.getString(2).equals(p)&&attend.getString(3).equals(p)&&attend.getString(4).equals(p)&&attend.getString(5).equals(p)&&attend.getString(6).equals(p))
					  result ="Full day";
				  else if(attend.getString(2).equals(p)&&attend.getString(3).equals(p)&&attend.getString(4).equals(p)||attend.getString(5).equals(p)&&attend.getString(6).equals(p))
					  result = "\tHalf day";
				  else
					  result = "\tabsent";
				  System.out.println(attend.getString(1)+"\t"+result);}
		  }catch(Exception e) {e.printStackTrace();}}
		  
	  void Atpercentage(String str) {
		  try {
			  int rollNo =Character.getNumericValue(str.charAt(6))*10;
	    	  rollNo+=Character.getNumericValue(str.charAt(7));
	          int i=rollNo;
			  String s = "SELECT * FROM ATTEND"+i;
			  attend = statement.executeQuery(s);
			  if(!attend.next()) {System.out.println("\tNo data found...");return;}
			  attend = statement.executeQuery(s);
			  String p = "PRESENT";
			  float attends=0;
			  float totaldays=0;
			  while(attend.next()) {
				      totaldays++;
					  if(attend.getString(2).equals(p)&&attend.getString(3).equals(p)&&attend.getString(4).equals(p)&&attend.getString(5).equals(p)&&attend.getString(6).equals(p))
					  attends++;
				      else if(attend.getString(2).equals(p)&&attend.getString(3).equals(p)&&attend.getString(4).equals(p)||attend.getString(5).equals(p)&&attend.getString(6).equals(p))
					  attends+=0.5;}
			  int per = (int)((attends/totaldays)*1000);
			  float percentage = per/10;
			  
			  System.out.println("Percentage--->>>"+percentage);
			  System.out.print("Remarks: ");
			  if(percentage>95) {System.out.println("Excellent");}
			  else if(percentage>80) {System.out.println("Good");}
			  else if(percentage>75) {System.out.println("poor");}
			  else {System.out.println("Not Eligible for exam");}
	         }catch(Exception e) {}}
	  
	  void Notifications() {
		  try {
		  ResultSet notify = statement.executeQuery("SELECT * FROM NOTIFI"); 
		  if(!notify.next()) {
			  System.out.println("  ---->>>>No notifications...");return;}
		  notify = statement.executeQuery("SELECT * FROM NOTIFI");
		  System.out.println("\nNotifications");
		  while(notify.next()) {
			  System.out.println("   ---->>>> "+notify.getString(2)+"     -"+notify.getString(3));}
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
		    		 ps = connection.prepareStatement("UPDATE STUDENT SET PASSWORD = ? WHERE ROLL_NO = ?");
		    		 ps.setString(1, pass1);
		    		 ps.setString(2, name);
		    		 ps.executeUpdate();
		    		 System.out.println("Updated successfully...");
		    		 break;}}
		    	 }catch(Exception e) {e.printStackTrace();}}
		     


		      boolean verify(String name) {
		    	  System.out.println("Enter your old password");
		    	  String pass = s.next();
		   		try {
		   			stInfo = statement.executeQuery("SELECT * FROM STUDENT");
		   			while(stInfo.next()) {
		   		    if(pass.equals(stInfo.getString(2))&&name.equals(stInfo.getString(1))) {return true; }}
		   		}catch(Exception e) {e.printStackTrace();}
		   	    return false;}

		  
	  }
	  
