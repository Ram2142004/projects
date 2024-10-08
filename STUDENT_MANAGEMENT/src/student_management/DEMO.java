package student_management;
import java.util.*;
public class DEMO {

	public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
    LoginLogoutSignup lls = new  LoginLogoutSignup();
    STUDENT student = new STUDENT();
    TEACHER teacher = new TEACHER();
    try {
    while(true) {
    System.out.println("\n1.Student...\n2.Teacher....\n0.Exit...");
    System.out.print("Choice? ");
    int choice = s.nextInt();
    if(choice==0) {System.out.println("Thank You....");System.exit(0);}
    String roll="0";
    if(choice==1) {
    	System.out.println("\t1.signin\n\t2.signup");
    	System.out.print("\tChoice? ");
    	int ch = s.nextInt();
    	if(ch==1) {
    	    roll = lls.studentSignin();
    	    if(roll=="0") {System.out.println("invalid RollNo or password...");}
    	    if(roll!="0")
    	    	student.StudentInfo(roll);}
    	    	     
    	if(ch==2)
    		lls.studentSignup();}
    if(choice==2) {
    	String str="0";
    	System.out.println("\t1.signin\n\t2.signup");
    	System.out.print("\tChoice? " );
    	int ch = s.nextInt();
    	if(ch==1) {
    		str = lls.TeacherSignin();
    	    if(str=="0") {System.out.println("Invalid username or password.....");}
    	    if(str!="0")
    	    	teacher.attendence(str);}
    	if(ch==2)
    		lls.TeacherSignup();}
	   
    } }catch(Exception e) {System.err.println("Erorr Occured...");}
}}
