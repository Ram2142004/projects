package bracketCheck;
public class BreaketCheck {
	public static void main(String[] args) {
		
		System.out.println(BracketCheck("(()(()))"));
	}
	
	public static  boolean BracketCheck(String str) {
		   LinkedStack<Character> stack = new LinkedStack<Character>();
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
