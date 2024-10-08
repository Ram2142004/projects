package DSA.Queue;
public class LinkedQueue {
	Node front , rear;
   class Node{
	   Node next;
	   int data;
	   Node(int val){next = null; data= val;}}
   LinkedQueue(){   front=null; rear = null;}
   
   void inqueue(int val) {
	   Node node = new Node(val);
	   if(front ==null) {
		   front = node;
		   rear=node;}
	   rear.next=node;
	   rear=node;}
   int dequeue() {
	   if(front == null) {throw new IndexOutOfBoundsException();}
	   int val=front.data;
	   front = front.next;
	   if(front==null) {rear=null;}
	   return val;}
   boolean isEmpty() { return front==null;}
   }

