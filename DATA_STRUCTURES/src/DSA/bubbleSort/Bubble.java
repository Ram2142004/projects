package DSA.bubbleSort;
public class Bubble {
     public static void sort(int[] arr) {
    	 int count=0;
    	 for(int i=0; i<arr.length;i++) {
    		 boolean alreadySorted = true;
    		 for(int j=0; j<arr.length-i-1; j++) {
    			 count++;
    			 if(arr[j]>arr[j+1]) { 
    				 int temp=arr[j];
    				 arr[j]=arr[j+1];
    				 arr[j+1]=temp;
    				 alreadySorted=false;}}
    			 if(alreadySorted) {return;}}
    			 

}}
