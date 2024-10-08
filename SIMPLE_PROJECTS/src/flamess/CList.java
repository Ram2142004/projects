package flamess;

public class CList {
	Node head;
    class Node{
    	Node(char val){
    		data=val; next = null;}
    	char data;
    	Node next;}
    
    void push() {
    	String flame = "Fl";
    	for(int i=0; i<flame.length(); i++) {
    		if(i==0) {
    		Node newNode = new Node(flame.charAt(i));
    		head=newNode;}
    		else {
    			Node newNode= new Node(flame.charAt(i));
    			Node temp=head;
    			for(int j=0; j<i; i++)
    			   temp = temp.next;
    			temp=newNode;
    			newNode.next=head;}}}
    void print() {
    	Node temp = head;
    	for(int i=0; i<2; i++) {
    		System.out.println(temp.data);
    		temp=temp.next;
    	}
    }
    
}
