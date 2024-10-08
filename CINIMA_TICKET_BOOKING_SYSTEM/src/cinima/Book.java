package cinima;

import java.sql.*;
import java.util.*;

public class Book {
	
	 Scanner s = new Scanner(System.in);
     Statement statement;
     Statement statement2;
     Connection connection;
     Connection connection2;
     PreparedStatement ps; 
	 ResultSet rs;
	 ResultSet rs2;
	   
    Book(){
  	   try {
  	   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CINIMA","root","2004");
  	   connection2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/CINIMA","root","2004");
  	   statement =connection.createStatement();
  	   statement2 =connection2.createStatement();
  	   }catch(Exception e){e.printStackTrace();}}

    
   void  book() {
	   
   }
   
  void moviePrint(){
	  String movieList[]= new String[20];
	  int i=0;
	  try {
	   rs = statement.executeQuery("SELECT * FROM THEATRE");
	   while(rs.next()) {
		   String theatre=rs.getString(1);
		   rs2 = statement2.executeQuery("SELECT * FROM "+ theatre);
		   while(rs2.next()) {
			   if(i==0) {
		            movieList[i++]=rs2.getString(4);
		            continue;}
			   for(int k=0; k<i; k++) {
		          if(movieList[k].equals(rs2.getString(4)))
			            break;
		          if(k==i-1) 
			            movieList[i++]=rs2.getString(4);
			            }}}
			   for(int x=0; x<i; x++) {System.out.println((x+1) + ". "+ movieList[x]);}
			   System.out.print("Choice: ");
			   int choice=s.nextInt();
			   String movie = movieList[choice-1];
			   getTheatre(movie);
	  }catch(Exception e) {e.printStackTrace();}}
  
  void  getTheatre(String movie) {
	  try {
		  String theatreList[]=new String[20];
		  int i=0;
		  rs = statement.executeQuery("SELECT * FROM THEATRE");
		  while(rs.next()) {
			   String theatre=rs.getString(1);
			   rs2 = statement2.executeQuery("SELECT * FROM "+ theatre);
			   while(rs2.next()) {
				   if(rs2.getString(4).equals(movie))
					   if(i==0)
						   theatreList[i++]=rs.getString(1);
					   for(int x=0; x<i; x++) {
						   if(theatreList[x].equals(rs.getString(1)))
							   break;
						   if(x==i-1)
					        theatreList[i++]=rs.getString(1);}}}
				   for(int x=0; x<i; x++) {System.out.println((x+1) + ". "+ theatreList[x]);}
				   System.out.print("Choice: ");
				   int choice=s.nextInt();
				   bookplace(theatreList[choice], movie);
	  }catch(Exception e) {e.printStackTrace();}}
  
  void bookplace(String theatre, String movie) {
	  try {
		  rs = statement.executeQuery("SELECT * FROM "+theatre+"seat");
		  while(rs.next()) {
			  for(int i=2; i<22; i++) {System.out.print(rs.getString(i)+" ");}
			  System.out.println("\n");}
		  System.out.println("Enter the seatNo");
		  
	  }catch(Exception e ){e.printStackTrace();}
  }
  
  
  
  }
  
 


