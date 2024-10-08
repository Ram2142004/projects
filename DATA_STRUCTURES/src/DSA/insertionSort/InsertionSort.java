package DSA.insertionSort;
public class InsertionSort {
   public static void sort(int []arr) {
	   for(int i=1; i<arr.length; i++) {
		   for(int j=i; j>0; j--) {
			   if(arr[j-1]>arr[j]) {
				   int temp=arr[j-1];
				   arr[j-1]=arr[j];
				   arr[j]=temp;}
			   else { break;}}}
   }}
// desending arr worst case 5,4,3,2,1   o(n2)
// asending arr best case  1,2,3,4,5    o(n)