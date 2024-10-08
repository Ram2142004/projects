package DSA.selectionSort;

import java.util.Arrays;

public class Demo {
	public static void main(String[] args) {
		int arr[]=new int[] {4, 2,3,44, 22,344,23 , 6, 22, 333,4,1};
		SelectionSort.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
