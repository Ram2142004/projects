package flamess;
import java.util.Arrays;
import java.util.Scanner;

public class Flames {
	
	void flame() {
	Scanner s = new Scanner(System.in);
    System.out.println("Enter your name: ");
    String name1 = s.next();
    System.out.println("Enter yours name: ");
    String name2 = s.next();
    int count=count(name1, name2);
    System.out.println(count);
	}
	
	private int count(String n1, String n2) {
		int count=0;
		char name1[]=new char[n1.length()];
		char name2[]=new char[n2.length()];
		for(int i=0; i<n1.length();  i++) 
			name1[i]=n1.charAt(i);
		for(int i=0; i<n2.length();  i++) 
			name2[i]=n2.charAt(i);
		Loop:
		for(int i=0; i<name1.length; i++) {
			for(int j=0; j<name2.length; j++) {
				  if(name1[i]==name2[j]) {
					  name1[i]='0'; name2[j]='0'; continue Loop;}}}
		for(int i=0; i<name1.length; i++) {
			if(name1[i]!='0')
				count++;}
		for(int i=0; i<name2.length; i++) {
			if(name2[i]!='0')
				count++;}
		return count;}
	
}
