package DB;
import java.sql.*;
import java.util.*;
public class InsertQuery {
	public static void main(String[] args) {
		InsertQuery insertQuery = new InsertQuery();
//		for(int i=0; i<30; i++) {
//		String date = insertQuery.date();
//		System.out.println(date);}
		insertQuery.insertDate();
	}
		
	void insert() {
		try {
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB","root","2004");
		Statement  statement =  connection.createStatement();
		Scanner s = new Scanner(System.in);
		String sql = "INSERT INTO INFO VALUES(?,?,?,?)";
		ResultSet rs = statement.executeQuery("Select * from Info");
		int i=1;
		while(rs.next()) { i++;}
		for(;i<=50; i++) {
		PreparedStatement ps = connection.prepareStatement(sql);
		ps.setInt(1, i);
		System.out.print("Enter your name: ");
		ps.setString(2, s.next());
		System.out.print("Enter your job Role: ");
		ps.setString(3, s.next());
		System.out.print("Enter your salary: ");
		ps.setInt(4, s.nextInt());
		ps.executeUpdate();}
		ResultSet rs2 = statement.executeQuery("Select * from Info");
		while(rs2.next()) {
			System.out.println(
					rs2.getInt(1)+"\n"+
			        rs2.getString(2)+"\n"+
				    rs2.getString(3)+"\n"+
			        rs2.getInt(4)+"\n\n");
		} System.out.println("Successfull");
	   }catch(Exception e) {e.printStackTrace();}}
		

   void insertDate() {
	   try {
		PreparedStatement ps;
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DB","root","2004");
		Statement  statement =  connection.createStatement();
//		ps = connection.prepareStatement("ALTER TABLE INFO ADD DATE DATE");
//		ps.executeUpdate();
		ResultSet rs = statement.executeQuery("SELECT * FROM INFO");
		int i=1;
		while(rs.next()) {
		ps = connection.prepareStatement("UPDATE INFO SET DATE = ? where ID = ?");
		ps.setString(1, date());
		ps.setInt(2, i++);
		ps.executeUpdate();}
	   }catch(Exception e) {e.printStackTrace();}}
   
   String date() {
	   String date="";
	   int temp=0;
	   Random random=  new Random();
	   date+= random.nextInt(1980, 2023);
	   date+="-";
	   temp = random.nextInt(1,13);
	   if(temp<10) date+=0;
	   date+=temp+"-";
	   temp= random.nextInt(1, 32);
	   if(temp<10) date+=0;
	   date+=temp;
	   return date;}
	   
}