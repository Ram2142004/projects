package oops_revice;
public class MIN_VALUE {
	  Use u = new Use();  
      int minValue(int ...a) {
    	  int min_value = Integer.MAX_VALUE;
    	  for(int i:a) {
    	  if(i<min_value)
    		  min_value = i;}
    	  System.out.println("hello from int");
    	  return min_value;}
      
          double minValue(double ...a) {
        	  double min_value = Double.MAX_VALUE;
        	  for(double i:a) {
        	  if(i<min_value)
        		  min_value = i;}
        	  System.out.println("hello from double");
        	  return min_value;
}}
