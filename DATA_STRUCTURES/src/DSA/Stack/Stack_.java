package DSA.Stack;
public class Stack_<T> {
	static final int MAX_VALUE = 30;
    T[]arr = (T[])new Object[MAX_VALUE];
    int top;
    Stack_() {top=-1;}
    
    void push(T val) {
  	  if(top==MAX_VALUE-1) { System.out.println("Stack full"); return;}
  	  arr[++top]=val;}
    T pop() {
  	  if(top<0) {throw new IndexOutOfBoundsException("Empty");}
  	  return arr[top--]; }
    void peak() {System.out.println(arr[top]);}
    boolean isempty() {return top==-1;}
}
