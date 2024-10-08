package ludo;
import java.util.*;

public class Ludo extends Thread{
	static Scanner scanner = new Scanner(System.in);
	static Random rand = new Random();
	static String name;
	static int plrPos=0, pcPos=0, choice=0;
	static boolean plr=false, pc=false;
	
static void ludo() {
	System.out.println("Enter your name: ");
	name = scanner.nextLine();
	for(int i=name.length(); i<8; i++) {name+=" ";}

	while(true) {
		System.out.print("\nYour Turn...   ");
		char s = scanner.next().charAt(0);
		if(Character.isAlphabetic(s)) {
		choice = rand.nextInt(1, 7);
		System.out.println(choice);
		if(choice==6) { plr=true;}
		if(plr) {
		plrPos+=choice;
		if(plrPos==pcPos) {pcPos=0;}}
		print();
		if(plrPos>30) {break;}
	    try{Thread.sleep(1000);} catch(Exception e) {}
		System.out.print("\nMy Turn...   ");
		choice = rand.nextInt(1, 7);
		System.out.println(choice);
		if(choice==6) { pc=true;}
		if(pc) {
		pcPos+=choice;
		if(plrPos==pcPos) {plrPos=0;}}
		print();
		if(pcPos>30) {break;}}}
	System.out.println("Game End...\n\n");
	if(plrPos>30) { slowPrint(name , " Won");}
	else { slowPrint("You lost...", " ");}
	
}


static void print() {
	System.out.println("\t\t\t               1 3 5 7 9 1 3 5 7 9 1 3 5 7 9 Won");
	System.out.print("\t\t\t"+name+"--->>>");
	for(int i=-1; i<plrPos; i++) {System.out.print(" ");}
	System.out.println("*");
	System.out.print("\t\t\tComputer--->>>");
	for(int i=-1; i<pcPos; i++) {System.out.print(" ");}
	System.out.println("*");
	}
static void slowPrint(String str1, String str2) {
	String str = str1+str2;
	try {
	for(int i=0; i<str.length(); i++) {
		System.out.print(str.charAt(i));
		Thread.sleep(200);}}
	catch(Exception e) {}}
	


}

