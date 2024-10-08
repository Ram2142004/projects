package taxi_booking;
import java.util.Scanner;
import java.sql.*;
public class DataBase  {
    Connection connection;
    Statement statment;
	PreparedStatement ps;
    ResultSet rs1;
	ResultSet rs2;
	Scanner scanner;
	
	DataBase(){
		try {
    scanner = new Scanner(System.in);
    connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/taxi_info","root","2004");
	statment=connection.createStatement();
	rs1 = statment.executeQuery("Select * from TAXI");
	rs2 = statment.executeQuery("Select * from USERS");
	}
	catch(Exception e) {e.printStackTrace();}	}
	
	public  void insert(int taxi_no,String name, char p, char d, int pickup, int droped,int earn) {
		   String pick ="";
	  	   String drop="";
		   pick+=p;
		   drop+=d;
        String s = "INSERT INTO TAXI VALUES(?,?,?,?,?,?,?,?)";
    try {
    	rs1 = statment.executeQuery("Select * from TAXI");
        ps = connection.prepareStatement(s);
        ps.setInt(1, counts(rs1));
        ps.setString(2, name);
        ps.setString(3, pick);
        ps.setString(4, drop);
        ps.setInt(5, pickup);
        ps.setInt(6, droped);
        ps.setInt(7, earn);
        ps.setInt(8, taxi_no);
        ps.executeUpdate();}
	catch(Exception e) {}}
        
    public  void print() {
    	 try {
    		 rs1 = statment.executeQuery("Select * from TAXI");
        while(rs1.next()) {
        	System.out.println(
        		  " Customer id: "+
        	     rs1.getString(1)+"\t"+
        		  " Customer Name: "+
        	     rs1.getString(2)+"\t"+
        		  " Pickup: "+
        	     rs1.getString(3)+"\t"+
        		  " Drop: "+
        	     rs1.getString(4)+"\t"+
        		  " Pickup Time: "+
        	     rs1.getString(5)+"\t"+
        		  " Drop Time: "+
        	     rs1.getString(6)+"\t"+
        		  " Earned: $"+
        	     rs1.getString(7));}}
	   catch(Exception e) {e.printStackTrace();} }
    
    
    private  int counts(ResultSet rs) {
    	try {
         int i=1;
         while(rs.next()) {i++;}
         return i;}
    	catch(Exception e) {System.out.println("Error on count");}return 0;}
    
    
    public boolean adminVerify() {
    	boolean isAdmin=false;
    	System.out.println("Enter Password: ");
    	String str = scanner.nextLine();
    	if(str.equals(getPassword())) {
    		isAdmin=true;
    		print("Admin Verification Successfully");}
    	return isAdmin;}
    
    public boolean adminVerify(String str) {
    	boolean isAdmin=false;
    	if(str.equals(getPassword())) {isAdmin=true;}
    	return isAdmin;}
    
    public void changePassword() {
    	System.out.println("Enter your oldPassword :  ");
    	String oldPassword = scanner.nextLine();
    	boolean access = adminVerify(oldPassword);
    	if(access) {
    	System.out.println("Admin Verifid....");
    	System.out.println("Enter your new Password: ");
    	String pass1 = scanner.nextLine();
    	System.out.println("Re Enter the  Password: ");
    	String pass2 = scanner.nextLine();
    	if(pass1.equals(pass2)) { passwordUpdate(pass1);}
    	else {System.out.println("Password Mismatch...");return;}
    	print("Password Updated Successfully");}}
    
    private String getPassword() {
    	String pass = "k";
    	try {rs2 = statment.executeQuery("Select * from Users");
    	while(rs2.next()) {pass = rs2.getString(2);}}
        catch(Exception e) {}
    	return pass;}
    private  void passwordUpdate(String str){
    	try {
    	rs2 = statment.executeQuery("Select * from Users");
        String s = "INSERT INTO USERS VALUES(?,?)";
        ps = connection.prepareStatement(s);
        ps.setInt(1, counts(rs2));
        ps.setString(2, str);
        ps.executeUpdate();}
    	catch(Exception e) {e.printStackTrace();}}
    
    public  void print(String str) {
    	for(int i=0; i<str.length(); i++) {
    		System.out.print(str.charAt(i));}
    		try{Thread.sleep(200);} catch(Exception e) {}
        for(int j=0; j<7; j++) {
    	    System.out.print(".");
    	    try{Thread.sleep(300);} catch(Exception e) {}}System.out.println();}
    public  void delete(int index) {
    	try {
    	String s = "DELETE FROM taxi WHERE C_ID = ?";
    	ps=connection.prepareStatement(s);
    	ps.setInt(1, index);
    	ps.executeUpdate();
    	print("Deleted Sucessfully...");}
    	catch(Exception e) {}}
    
    public void clearData() {
    	try {
    		String s = "DELETE FROM taxi";
        	ps=connection.prepareStatement(s);
        	ps.executeUpdate();
    	}
       catch(Exception e) {e.printStackTrace();}}
    	
    	
    	
    }
    
    
    
    
    
    
