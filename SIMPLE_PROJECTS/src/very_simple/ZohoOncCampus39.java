package very_simple;
public class ZohoOncCampus39 {
	public static void main(String[] args) {
		NumWeight();
   }
	
    static void isAlphabet1() {
    	String str=" ";
    	if(str.length()<26)
    		System.out.println("False");
    	for(int i=0; i<26; i++) {
    		char s = (char)(i+65);
    		char b = (char)(i+97);
    		if(str.charAt(i)==s || str.charAt(i)==b)
    			continue;
    		System.out.println("False");}
    	System.out.println("True");}
    
    
    static void isAlphabet2() {
    	     String str=" ";
    		  for(int j=0; j<26; j++) {
        		char s = (char)(j+65);
        		char b = (char)(j+97);
        		for(int i=0; i<str.length(); i++) {
        		   if(str.charAt(i)==s || str.charAt(i)==b)
        			  break;
        		   if(i==str.length()-1)   
        			 System.out.println("false");}}
    		System.out.println("True");}
    
      static void NumWeight() {
    	  int Num[]=new int[] {4, 2};
    	  int weight = 0;
    	  for(int i=0; i<Num.length; i++) {
    		  if(isSqrt(Num[i]))
    			  weight +=5;
    		  else if(mul4div6(Num[i]))
    			  weight+=4;
    		  else if(Num[i]%2==0)
    			  weight+=3;}
    	  System.out.println(weight);}
   
      static boolean isSqrt(int val) {
    	  double v = Math.sqrt(val);
    	  return v%1==0;}
      static boolean mul4div6(int val) {
    	  boolean val1 = (((float)val/4)%1)>0;
    	  System.out.println(val1);
    	  boolean val2 = ((float)val%6)%1>0;
    	  System.out.println(val2);
    	  return !val1 || !val2;}
      
      
      






}


    
    
    

