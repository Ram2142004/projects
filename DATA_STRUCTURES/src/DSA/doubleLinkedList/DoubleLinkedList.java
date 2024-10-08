package DSA.doubleLinkedList;
public class DoubleLinkedList {
	private Node head;
	private Node tail;
	public class Node{
		Node prev;
		int data;
		Node next;
		Node(int val){data=val; next=null; prev=null;}}
	DoubleLinkedList(){head=null;tail=null;}
	
	public void insertAtBegining(int val) {
		Node node = new Node(val);
		if(head==null) {
			head = node;
			tail = node;}
		else { node.next=head;
		       head.prev=node;
		       node.next=head;
		       head = node;}}
	public void display() {
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+ " ");
			temp=temp.next;}System.out.println();}
	public void displayReverce() {
		Node temp=tail;
		while(temp!=null) {
			System.out.print(temp.data+ " ");
			temp=temp.prev;}System.out.println();}
	public void insertAtPos(int val, int pos) {
		if(pos==0) {insertAtBegining(val);return;}
		Node node = new Node(val);
		Node fst = head;
		Node sec = head;
		for(int i=1; i<pos; i++) {
			fst = sec;
			sec = sec.next;
			if(sec==tail) {insertAtEnd(val); return;}}
		node.next=sec;
		node.prev=fst;
		sec.prev=node;
		fst.next=node;}
	
	public void insertAtEnd(int val) {
		Node node = new Node(val);
		Node temp=tail;
		temp.next=node;
		node.prev=temp;
		tail=node;}
	
	public void delAtPos(int pos) {
		if(pos==0) {delAtBegining();return;}
		Node temp= head;
		for(int i=1; i<pos; i++) {
			temp=temp.next;
			if(temp==tail) {delAtEnd();return;}}
		temp.prev.next=temp.next;
		temp.next.prev=temp.prev;}
	public void delAtBegining() {
		Node temp=head;
		temp.next.prev=null;
		head = temp.next;}
	public void delAtEnd() {
		Node temp = tail;
		tail.prev.next=null;
		tail= temp.prev;}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
