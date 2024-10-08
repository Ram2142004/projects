package DB;
public class ToCheck {
	public static void main(String[] args) {
	ToCheck c = new ToCheck();
	//System.out.println(c.Length(new int[] {2, 4, 3, 5, 4, 6}));
	//c.BiggestThenPre(new int[] {2, 4, 6, 3, -1, 5, 4, 6});
    c.printPattern(4);
	
		
	
	
	}
	
	void BiggestThenPre(int arr[]) {
		int big = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) 
			if(arr[i]>big) {
				System.out.print(arr[i]+" ");
				big = arr[i];}}
	void printPattern(int num) {
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				if(i==0||j==0||j==num-1||i==num-1)
					System.out.print(num);
				else if(i==j||i+j==num-1)
					System.out.print(num-1);
				else
					System.out.print(num-2);
			}System.out.println();}}
	
	
	int Length(int arr[]) {
		int i=0;
		int temp=0;
		try {
			while(true) 
				temp = arr[i++];}
		catch(Exception e) {
			return i-1;}}
	
	
	
	

}
