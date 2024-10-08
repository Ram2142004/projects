package flames;
import java.util.*;

public class Flames extends Thread {
		   Application flames = new Application();
		   private ArrayList<String> nameList = new ArrayList<String>();
		   private ArrayList<String> relatList= new ArrayList<String>();
		   private char[] relationList  = new char[100];int index=0;	int i=0;
		   public void name(String name) {nameList.add(name);}
		   public void relat(String name) {relatList.add(name);}
		   private void relation( int k) {
		        for(String name: nameList) {
		  	      for(String relat: relatList) {
		  		     if(k==1) {relationList[i++]=flames.getRelation(relat, name, 1);}
		  		     if(k==0){ relationList[i++]=flames.getRelation(relat, name);}}}}
		   public void proceed(int k) {
		  	   relation(k);
		  	   for(String name: nameList) {
		     	   for(String relat: relatList) {
		     		   char c = relationList[index++];
		  				  print(name, 50);
		       			  toPrint(c); 
		       			  print(relat, 50); System.out.print("\n");;speed(1000);}}}
		     
		     private void toPrint(char c) {
		  	       switch(c) {
		  	        case 'f' :  print(" Friend ", 200); break;
		  	        case 'l' :  print(" Loves ",200); break;
		  	        case 'a' :  print(" affection ", 200); break;
		  	        case 'm' :  print("  marry ",200); break;
		  	        case 'e' :  print(" Enemy ",200); break;
		  	        case 's' :  print(" sibbling ",200); break;}}
		     private void print(String r, int speed) {
		  	   for(int i=0; i<r.length(); i++) {
		  		   System.out.print(r.charAt(i));
		  		   speed(speed);}}
		     
		     private void speed(int val) {
		   	   try {Thread.sleep(val);}
		         catch(Exception e) {}}}



