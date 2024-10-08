package DSA.Stack;
public class LinkedStack <T>{
  Node top;
  class Node{
	 T data;
	 Node next;
	 Node(T val){data=val; next=null;}}
  LinkedStack(){top=null;}
  
  void push(T val) {
	  Node node = new Node(val);
		  node.next= top;
		  top=node;}
    T pop() {
    	if(top==null) { throw new IndexOutOfBoundsException("Stack is mty");}
    	T data= top.data;
    	top=top.next;
    	return data;}
    boolean isEmpty() {
       return top==null;}
    void peak() {
    	System.out.println(top.data);}
    void display() {
    	if(top==null) {return;}
    	Node temp = top;
    	while(temp!=null) {
    		System.out.print(temp.data+ " ");
    		temp=temp.next;}
    	System.out.println();
    }
}
