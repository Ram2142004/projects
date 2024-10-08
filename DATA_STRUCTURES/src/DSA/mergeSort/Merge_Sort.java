package DSA.mergeSort;
import java.util.Arrays;

public class Merge_Sort {
	public static void main(String[] args) {
//		int [] arr = new int[4];
//		arr[0] = 10;
//		arr[1] = 50;
//		arr[2] = 90;
//		arr[3] = 70;
//		System.out.println("st");
//	    mergeSortEffi(arr,0,arr.length);
//	    System.out.println("End");
//		for(int i:arr) {System.out.println(i);}}
		System.out.println("Enter your name: ");
//		Scanner s = new Scanner();
	}
	
	public static int[]mergeSort(int[]arr){
		if(arr.length==1) {return arr;}
		int mid = arr.length/2;
		int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
		int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
		return merge(left, right);}
    
	public static int[] merge(int[]left, int[] right) {
    	 int[] joined = new int[left.length+right.length];
    	 int i=0, j=0, k=0;
    	 while(i<left.length&& j<right.length) {
    		 if(left[i]<right[j]) {
    			 joined[k++]=left[i++];}
    		 else { joined[k++]=right[j++];}}
    	 while(i<left.length) {joined[k++]=left[i++];}
    	 while(j<right.length) {joined[k++]=right[j++];}
    	 return joined;}
	

	public static void mergeSortEffi(int[]arr, int st, int end){
		if(end-st==1) {return;}
		int mid = (st+end)/2;
		mergeSortEffi(arr, st, mid);
		mergeSortEffi(arr, mid, arr.length);
		System.out.println(Arrays.toString(arr));
		mergeEffi(arr, st, mid, end);}
    
	public static void mergeEffi(int[]arr, int st, int mid, int end) {
    	 int[] joined = new int[end-st];
    	 int i=st, j=mid, k=0;
    	 while(i<mid&& j<end) {
    		 if(arr[i]<arr[j]) {
    			 joined[k++]=arr[i++];}
    		 else { joined[k++]=arr[j++];}}
    	 while(i<mid) {joined[k++]=arr[i++];}
    	 while(j<end) {joined[k++]=arr[j++];}
    	 
    	 for(k=0; k<joined.length; i++) {
    		 arr[st+k]=joined[k];
    	 }
	
    	 return;}}














    
