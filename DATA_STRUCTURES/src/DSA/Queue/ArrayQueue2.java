package DSA.Queue;
public class ArrayQueue2 {
	 static final int  initialCapacity = 30;
	   int index=-1;
	   int[]arr = new int[initialCapacity];
	   
	   void inQueue(int val) {
		   if(index>initialCapacity-1) {
			   throw new IndexOutOfBoundsException();}
		   arr[++index]=val;}
	   int dequeue() {
		   if(index<0) {throw new IndexOutOfBoundsException();}
		   int val = arr[0];
		   for(int i=1; i<=index; i++) {
			   arr[i-1]= arr[i];}
		   index--;
		   return val;
	   }
}