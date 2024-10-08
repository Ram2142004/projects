package DSA.linkedList;
import java.util.Iterator;

public class LinkedList <T> implements Iterable{
	private Node head;
	public class Node{
		T data;
		Node next;
        Node(T val){data=val; next=null;}}
	LinkedList(){head = null;}
// Insert at beginning
	public void insertAtBiginning(T val) {
		Node newNode = new Node(val);
		if(head == null) {head = newNode;}
		else {
			newNode.next = head;
			head = newNode;}}
// display
	public void display() {
		Node temp = head;
		while(temp!=null) {
			System.out.print(temp.data+ " ");
			temp = temp.next;}System.out.println();}
//insert At position
    public void insertAtPos(int pos, T val) {
    if(pos==0) {insertAtBiginning(val); return;}
	Node newNode = new Node(val);
	Node temp = head;
	for(int i=1; i<=pos-1; i++) {
		temp =  temp.next;}
	newNode.next = temp.next;
	temp.next = newNode;}
// delete at position
	public void delAtPos(int pos) {
		if(pos==0) {head=head.next; return;}
		Node temp = head;
		Node prev = null;
		for(int i=1; i<=pos; i++) {
		prev = temp;
		temp = temp.next;}
	    prev.next=temp.next;}
//get
	public T get(int pos) {
		Node temp = head;
		for(int i=1; i<=pos; i++) {
			temp=temp.next;}
		return temp.data;}
// update
	public void update(int pos, T val) {
		Node temp=head;
		for(int i=1; i<=pos; i++) {
			temp=temp.next;}
		temp.data=val;}
// delete at end
	public void delAtEnd() {
		Node temp=head;
		Node prev=null;
		while(temp.next!=null) {
			prev = temp;
			temp= temp.next;}
		prev.next = null;}
// insert at end
	public void insertAtEnd(T val) {
	    Node temp = head;
		while(temp.next!=null) {
			temp= temp.next;}
		Node newNode = new Node(val);
		temp.next=newNode;}
//search
	public int search(T val) {
        Node temp=head;
        int index=0;
        while(temp.data!=val) {
                  if(temp.next==null) {return -1;}
        	      temp=temp.next;}
        return index;}
//contains
	public boolean contains(T val) {
		Node temp = head;
		while(temp.next!=null) { 
			if(temp.data==val) {
				return true;}
			temp=temp.next;}
		return false;}
// length
	public int length() {
		Node temp = head;
		int length=1;
		while(temp.next!=null) {
			length++;
			temp=temp.next;}
		return length;}
//Iterate
	public Iterator<T> iterator(){
		return new Iterator<T>() {
		  Node temp=head;
	      public boolean hasNext() {
	    	  return temp!=null;}
	      public T next() {
	    	  T val = temp.data;
	    	  temp=temp.next;
	    	  return val;}};}
	 public void reverse() {
		 Node current = head;
		 Node prev = null;
		 Node next = null;
         while(current !=null) {
        	 next=current.next;
        	 current.next=prev;
        	 prev=current;
        	 current = next;}
         head=prev;
}
}