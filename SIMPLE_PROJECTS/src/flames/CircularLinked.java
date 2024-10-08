package flames;

public class CircularLinked {
	     Node last;
	    public  class Node{
	    	 char data;
	    	 Node next;
	    	 public  Node(char val){data=val; next=null;}}
	     public CircularLinked(){last=null;}
	     
	     public void insertAtBigin(char val) {
	    	 Node node = new Node(val);
	    	 if(last==null) {
	    		 last = node;
	    		 node.next=node;}
	    	 else {
	    		 node.next = last.next;
	    		 last.next=node;}}
	    	 
	     public void insertAtEnd(char val) {
	    	 Node node = new Node(val);
	    	 if(last==null) {
	    		 last = node;
	    		 node.next=node;}
	    	 else {
	    		 node.next = last.next;
	    		 last.next=node;
	    		 last=node;}}
	     public void display() {
	    	 if(last == null) {return;}
	    	 Node temp=last.next;
	    	 do {System.out.print(temp.data+" ");
	    		 temp = temp.next;}while(temp!=last.next);
	    	 System.out.println();}
	     public void delAtBigin() {
	    	 if(last==null) {return;}
	    	 if(last.next==last) {last=null;}
	    	 else {last.next=last.next.next;}}
	     public void delAtEnd() {
	    	 if(last==null) {return;}
	    	 if(last.next==last) {last=null;}
	    	 else {Node temp=last.next;
	    	 while(temp.next!=last) {
	    		 temp=temp.next;}
	    	 temp.next=last.next;
	    	 last = temp;}}
	     public void delValue(char val) {
	    	 if(last.data==val) {delAtEnd(); return ;}
	    	 if(last.next.data==val) {delAtBigin(); return;}
	    	 Node prev = null;
	    	 Node temp = last.next;
	    	 while(temp.data!=val) {
	    		 if(temp.next==last) {return;}
	    		 prev = temp;
	    		 temp=temp.next;}
	    	 prev.next=temp.next;}
	     public void reset() {last=null;}
	     public char jumpDel(int val) {
	    	 Node temp = last;
	    	 while(last.next!=last) {
	    		 for(int i=0; i<val; i++) {
	    			 temp=temp.next;}
	    		 delValue(temp.data);}
	    	 return (char)last.data;}
	     public void insertchar(String s) {
	    	 for(int i=0; i<s.length(); i++) {
	    		 insertAtEnd(s.charAt(i));}}
	}

