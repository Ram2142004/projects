package DB;
import java.util.*;
import java.sql.*;
public class CopyQuery {
	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) {
		copy();
		System.out.println("Suecess");
	}
	
	static void copy() {
		Connection c1;
		Connection c2;
		Statement s1;
	    ResultSet rs;
		Statement s2;
		PreparedStatement ps;

		System.out.print("Enter the 1st database: ");
		String DB1 = s.next();
		System.out.print("Enter the table name: ");
		String t = s.next();
		System.out.print("Enter the 2nd Database: ");
		String DB2 = s.next();
		
		
		try {
		c1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DB1+"","root","2004");
		s1 = c1.createStatement();
		c2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DB2+"","root","2004");
		s2 = c2.createStatement();
		rs = s1.executeQuery("Select * from "+t);
		ps = c2.prepareStatement("CREATE TABLE "+t+" ( ID INT primary KEY, NAME VARCHAR(30),JOB VARCHAR(50),SALARY INT);");
		ps.executeUpdate();
		while(rs.next()) {
		ps = c2.prepareStatement("INSERT INTO "+t+" VALUES(?,?,?,?)");
		ps.setInt(1, rs.getInt(1));
		ps.setString(2, rs.getString(2));
		ps.setString(3, rs.getString(3));
		ps.setInt(4, rs.getInt(4));
		ps.executeUpdate();}
	}catch(Exception e) {e.printStackTrace();}
	}}