package Scan;
import java.util.Scanner;

public class Scan {
	static Scanner scanner;
    public Scan(){scanner = new Scanner(System.in); }
    
    public static int INT(String s) {
    	System.out.println(s);
    	return scanner.nextInt();}
    public static float FLOAT(String s) {
    	System.out.println(s);
    	return scanner.nextFloat();}
    public static double DOUBLE(String s) {
    	System.out.println(s);
    	return scanner.nextDouble();}
    public static char CHAR(String s) {
    	System.out.println(s);
    	return scanner.next().charAt(0);}
    public static String STRING(String s) {
    	System.out.println(s);
    	return scanner.nextLine();}
    public static boolean BOOLEAN(String s) {
    	System.out.println(s);
    	return scanner.nextBoolean();}}
