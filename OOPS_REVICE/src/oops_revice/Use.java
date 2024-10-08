package oops_revice;
public class Use {
      public  static void arrayPrintLimit(int[]arr, int l){for(int i=0; i<l; i++) {System.out.println(arr[i]);}}
      public  static void arrayPrintLimit(float[]arr, int l){for(int i=0; i<l; i++) {System.out.println(arr[i]);}}
      public  static void arrayPrintLimit(double[]arr, int l){for(int i=0; i<l; i++) {System.out.println(arr[i]);}}
      public  static void arrayPrintLimit(char[]arr, int l){for(int i=0; i<l; i++) {System.out.println(arr[i]);}}
      public  static void arrayPrintLimit(String[]arr, int l){for(int i=0; i<l; i++) {System.out.println(arr[i]);}}
      
      public  static void arrayPrint(int[]arr){for(int i:arr) {System.out.println(i);}}
      public  static void arrayPrint(float[]arr){for(float i:arr) {System.out.println(i);}}
      public  static void arrayPrint(double[]arr){for(double i:arr) {System.out.println(i);}}
      public  static void arrayPrint(char[]arr){for(char i:arr) {System.out.println(i);}}
      public  static void arrayPrint(String[]arr){for(String i:arr) {System.out.println(i);}}
      
      public static int digitCount(int x) {
    	  int digit =0;
    	  while(x>0) {
    		  x=x/10;
    		  digit++;}
    	  return digit;}
      
}
      
      
      
      
      

