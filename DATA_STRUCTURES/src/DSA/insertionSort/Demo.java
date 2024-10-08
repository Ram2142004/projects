package DSA.insertionSort;

import java.util.Arrays;

public class Demo {
	public static void main(String[] args) {
     int[] arr = new int[] { 3,2 ,34,22, 44,33, -1};
     System.out.println(Arrays.toString(arr));
     InsertionSort.sort(arr);
     System.out.println(Arrays.toString(arr));
	}

}
