package oops_revice_clone;
public class Department implements Cloneable {
   String name ;
   int id;
   protected Object clone() throws CloneNotSupportedException {
	   return super.clone();
   }
}
