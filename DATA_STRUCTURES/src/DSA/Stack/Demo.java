package DSA.Stack;
import DSA.Stack.LinkedStack.Node;

public class Demo {
	public static void main(String[] args) {
     Stack_ stack = new Stack_();
     LinkedStack linkedStack = new LinkedStack();
     Application app = new Application();
     
     
   String code = "package DSA.Stack;\r\n"
   		+ "public class LinkedStack <T>{\r\n"
   		+ "  Node top;\r\n"
   		+ "  class Node{\r\n"
   		+ "	 T data;\r\n"
   		+ "	 Node next;\r\n"
   		+ "	 Node(T val){data=val; next=null;}}\r\n"
   		+ "  LinkedStack(){top=null};\r\n"
   		+ "  \r\n"
   		+ "  void push(T val) {\r\n"
   		+ "	  Node node = new Node(val);\r\n"
   		+ "		  node.next= top;\r\n"
   		+ "		  top=node;}\r\n"
   		+ "    T pop() {\r\n"
   		+ "    	if(top==null) { throw new IndexOutOfBoundsException(\"Stack is mty\");}\r\n"
   		+ "    	T data= top.data;\r\n"
   		+ "    	top=top.next;\r\n"
   		+ "    	return data;}\r\n"
   		+ "    boolean isEmpty() {\r\n"
   		+ "       return top==null;}\r\n"
   		+ "    void peak() {\r\n"
   		+ "    	System.out.println(top.data);}\r\n"
   		+ "    void display() {\r\n"
   		+ "    	if(top==null) {return;}\r\n"
   		+ "    	Node temp = top;\r\n"
   		+ "    	while(temp!=null) {\r\n"
   		+ "    		System.out.print(temp.data+ \" \");\r\n"
   		+ "    		temp=temp.next;}\r\n"
   		+ "    	System.out.println();\r\n"
   		+ "    }\r\n"
   		+ "}\r\n"
   		+ "";     
   System.out.println(app.BracketCheck(code));
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}}
