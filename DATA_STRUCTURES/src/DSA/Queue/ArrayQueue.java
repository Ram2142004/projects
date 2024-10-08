package DSA.Queue;
public class ArrayQueue {
   static final int  initialCapacity = 30;
   int frnt=-1, rear=-1;
   int[]arr = new int[initialCapacity];
   
   void inqueue(int val) {
	   if(rear==initialCapacity-1)
		   throw new IndexOutOfBoundsException();
	   if(frnt==-1) 
		   frnt++;
	   arr[++rear]=val;}
   int dequeue() {
	   if(frnt == -1||frnt>rear) {throw new IndexOutOfBoundsException();}
	   return arr[frnt++];
   }
   
}
