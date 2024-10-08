package DSA.Queue;

public class Demo {
	public static void main(String[] args) {
		ArrayQueue2 q = new ArrayQueue2();
		q.inQueue(10);
		q.inQueue(70);
		q.inQueue(40);
		q.inQueue(30);
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
}}
