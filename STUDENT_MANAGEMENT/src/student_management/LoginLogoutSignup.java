package student_management;
import java.sql.*;
import java.util.*;

public class LoginLogoutSignup {
	Connection connection;
	Statement statement;
	PreparedStatement ps;
	ResultSet Srs;
	ResultSet Trs;
	Scanner s;
	LoginLogoutSignup(){
		try {
	       connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/STUDENT_MANAGEMENT","root","2004");
		   statement =connection.createStatement();
		   s = new Scanner(System.in);}
		catch(Exception e) {e.printStackTrace();}}
	
	void studentSignup() {
		System.out.print("Enter your rollNo: ");
		String roll = s.nextLine();
		System.out.print("Enter password: ");
		String pass = s.nextLine();
		System.out.print("Enter your name: ");
		String name = s.nextLine();
		System.out.print("Enter mobile No:");
		String mob = s.nextLine();
		System.out.print("Enter your Email: ");
		String gmail = s.nextLine();
		String str;
		try {
		   str = "INSERT INTO STUDENT VALUES(?,?,?,?,?)";
		   ps = connection.prepareStatement(str);
		   ps.setString(1, roll);
		   ps.setString(2, pass);
		   ps.setString(3, name);
		   ps.setString(4, mob);
		   ps.setString(5, gmail);
		   ps.executeUpdate();
		   System.out.println("Now signin....");}
		catch(Exception e) {e.printStackTrace();}}
	
	void TeacherSignup() {
		System.out.print("Enter your username: ");
		String user = s.nextLine();
		System.out.print("Enter password: ");
		String pass = s.nextLine();
		try {
		   String str = "INSERT INTO TEACHER VALUES(?,?)";
		   ps = connection.prepareStatement(str);
		   ps.setString(1, user);
		   ps.setString(2, pass);
		   ps.executeUpdate();
		   System.out.println("Now signin....\n");}
		catch(Exception e) {e.printStackTrace();}}
	
	String studentSignin() {
		String password = "";
		System.out.print("Enter your rollNo: ");
		String roll = s.nextLine();
		System.out.print("Enter Password: ");
		String pass = s.nextLine();
		try {
			Srs = statement.executeQuery("SELECT * FROM STUDENT");
			while(Srs.next()) {
		    if(pass.equals(Srs.getString(2))&&roll.equals(Srs.getString(1))) { System.out.println("\nWelcome "+Srs.getString(3));return roll;}}}
		catch(Exception e) {e.printStackTrace();}
		return "0";}
	
	String TeacherSignin() {
		String password = "";
		System.out.print("Enter your UserName: ");
		String name = s.nextLine();
		System.out.print("Enter Password: ");
		String pass = s.nextLine();
		try {
			Srs = statement.executeQuery("SELECT * FROM TEACHER");
			while(Srs.next()) {
		    if(pass.equals(Srs.getString(2))&&name.equals(Srs.getString(1))) { System.out.println("\nwelcome "+Srs.getString(1));return name;}}}
		catch(Exception e) {e.printStackTrace();}
		return "0";}
	
	
}
