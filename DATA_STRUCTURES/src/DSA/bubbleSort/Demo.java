package DSA.bubbleSort;
import java.util.Arrays;
public class Demo {
	public static void main(String[] args) {
    int[]arr= new int[] {2, 5, 7,-3,3, 44, 32,66, 8};
    Bubble.sort(arr);
    System.out.println(Arrays.toString(arr));
        int[]array= new int[] {1,3,4,5,6,7,9,33,44};
        Bubble.sort(array);
        System.out.println(Arrays.toString(array));

	}

}
// space 0(n)
// o(n2)