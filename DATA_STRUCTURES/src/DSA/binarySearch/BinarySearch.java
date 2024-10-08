package DSA.binarySearch;
public class BinarySearch {
   public static int search(int[]arr, int target) {
	   int start=0;
	   int end = arr.length-1;
	   int mid;
	   while(start<end) {
		   mid = (start+end)/2;
		   if(arr[mid]<target) {start=mid+1;}
		   else if(arr[mid]>target) {end = mid-1;}
		   if(arr[mid]==target) {return mid;}}
	   return -1;
   }
}
