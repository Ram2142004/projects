package very_simple;
import java.util.*;
public class Salary {
    private long salary;
    private Scanner s = new Scanner(System.in);
    
    public void salary() {
    	getSalary();
    	salaryPrint();}
    
    private void getSalary(){
    	System.out.println("1.Yearly\n2.monthly\n3.weekly\n4.day\n");
    	while(true) {
    	System.out.print("Choice: ");
    	int c= s.nextInt();
    	if(c!=1&&c!=2&&c!=3&&c!=4)
    		continue;
    	System.out.println("Enter your salary: ");
    	long sal = s.nextLong();
    	if(c==1)
    		salary = sal;
    	if(c==2)
    		salary = 12*sal;
    	if(c==3)
    		salary= 52*sal;
    	if(c==4)
    		salary= 365*sal;
    	if(salary!=0)
    		break;
    	}}
    
    		
    
    private  void salaryPrint() {
    	long yr, month, week, day, hr;
    	float min, sec;
    	long exDay ,exHr;
    	float exMin, exSec;
    	yr = salary;
    	month = salary/12;
    	week = salary/52;
    	day = salary/365;
    	hr = day/24;
    	min = hr/60;
    	sec = min/60;
    	exDay = week/5;
    	exHr = exDay/8;
    	exMin = exHr/60;      
    	exSec = exMin/60;
    	System.out.println("Rs."+yr + " Per year");
    	System.out.println(wordsPrint(yr));
    	System.out.println("Rs."+month + " Per month");
    	System.out.println(wordsPrint(month));
    	System.out.println("Rs."+week + " Per week");
    	System.out.println(wordsPrint(week));
    	System.out.println("Rs."+day + " Per day");
    	System.out.println(wordsPrint(day));
    	System.out.println("Rs."+hr + " Per hr for 24hrs");
    	System.out.println(wordsPrint(hr));
    	System.out.println("Rs."+min + " Per Minute");
    	System.out.println(wordsPrint((int)min)+paisePrint(min));
    	System.out.println("Rs."+sec + " Per sec");
    	System.out.println(wordsPrint((int)sec)+paisePrint(sec));
    	System.out.println("Rs."+exDay + "per day");
    	System.out.println(wordsPrint(exDay));
    	System.out.println("Rs."+exHr + " Per hr for 8hrs");
    	System.out.println(wordsPrint((int)exHr));
    	System.out.println("Rs."+exMin + " Per Minute");
    	System.out.println(wordsPrint((int)exMin)+paisePrint(exMin));
    	System.out.println("Rs."+exSec + " Per Second");
    	System.out.println(wordsPrint((int)exSec)+paisePrint(exSec));
    	}
    
       private String wordsPrint(long val) {
    	   String sal = "";
    	   if(val/1000>=10000000) {
    		   long hc = val/10000000000L;
    		   sal+=hundred(hc)+" Thousand  ";
    		   val%=10000000000L;}
    	   if(val/100>=10000000) {
    		   long hc = val/1000000000;
    		   sal+=hundred(hc)+" hundred  ";
    		   val%=1000000000;}
    	   if(val>=10000000) {
    		   long c = val/10000000;
    		   sal+=hundred(c);
    		   val %=10000000;}
    	   if(sal!="")
    		   sal+=" crore ";
    	   if(val>=100000) {
    		   long l = val/100000;
    		   sal+=hundred(l)+" lakh ";
    		   val %=100000;}
    	   if(val>=1000) {
    		   long t = val/1000;
    		   sal+=hundred(t)+" Thousend ";
    		   val %=1000;}
    	   if(val>=100) {
    		   long h = val/100;
    		   sal+=hundred(h)+" hundred ";
    		   val %=100;}
    	   sal+=hundred(val);
    	   if(!(sal.equals("")))
    	       sal+=" Rupees ";
    	   return sal;}
       
       private String hundred(long val) {
    	   String sal ="";
    	   if(val>=10) {
    		   switch((int)val/10) {
    		        case 9: sal+=" ninty "; break;
    		        case 8: sal+=" Eighty "; break;
    		        case 7: sal+=" seventy "; break;
    		        case 6: sal+=" sixty "; break;
    		        case 5: sal+=" fivty "; break;
    		        case 4: sal+=" fourty "; break;
    		        case 3: sal+=" therty "; break;
    		        case 2: sal+=" twenty "; break;
    		        case 1: 
    		        	if(val%10==9) sal+=" Nineteen ";
    		        	if(val%10==8) sal+=" Eighteen ";
    		        	if(val%10==7) sal+=" seventeen ";
    		        	if(val%10==6) sal+=" sixteen ";
    		        	if(val%10==5) sal+=" fivteen ";
    		        	if(val%10==4) sal+=" fourteen ";
    		        	if(val%10==3) sal+=" therteen ";
    		        	if(val%10==2) sal+=" twele ";
    		        	if(val%10==1) sal+=" leven ";
    		        	if(val%10==0) sal+=" ten ";
    		        	return sal;} 
    		   val%=10;}
           if(val>0) {
        	   switch((int)val) {
        		   case 9: sal+=" nine "; break;
        		   case 8: sal+=" Eight "; break;
        		   case 7: sal+=" seven "; break;
        		   case 6: sal+=" six  "; break;
        		   case 5: sal+=" five "; break;
        		   case 4: sal+=" four "; break;
        		   case 3: sal+=" three "; break;
        		   case 2: sal+=" two "; break;
        		   case 1: sal+=" one ";}}
    	   return sal;}
       
       private String paisePrint(float val) {
    	   val%=1; val*=100;
    	   if(!(hundred((int)val).equals("")))
    		   return hundred((int)val)+" Paise";
    	   return " ";}
    
}
