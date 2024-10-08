package DSA.Stack;
public class Application {
   LinkedStack<Character> stack = new LinkedStack();
   public  boolean BracketCheck(String str) {
	   for(int i=0; i<str.length(); i++) {
		   if(str.charAt(i)=='{'||str.charAt(i)=='['||str.charAt(i)=='(') {
			   stack.push(str.charAt(i));}
		   if(str.charAt(i)=='}') {
			   if(stack.isEmpty()) {return false;}
			   if(stack.pop()=='{') {}
			   else {return false;}}
			   
			if(str.charAt(i)==']') {
				if(stack.isEmpty()) {return false;}
			   if(stack.pop()=='[') {}
			   else {return false;}}

			if(str.charAt(i)==')') {
				   if(stack.isEmpty()) {return false;}
				   if(stack.pop()=='(') {}
				   else {return false;}}}
	   return stack.isEmpty();
	   }
   }

	


