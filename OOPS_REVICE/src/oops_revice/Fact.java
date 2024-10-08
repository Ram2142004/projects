package oops_revice;
public class Fact {
	  int oddCount(int low, int High) {
		  if(low<0) {low = low+(2*low);}
		  if(High<0) {High = High+(2*High);}
		  if(High<low) {
			  low = low+High;
			  High = low - High;
			  low = low - High;}
		  if(low%2==0) {low = low+1;}
		  if(High%2==0) {High = High-1;}
		  int count = (High-low)/2+1;
		  System.out.print("Odd count is: ");
		  return count; }
	
	
}
