package inner_cls;
public class Demo {
	public static void main(String[] args) {
//if inner is non static
    Nested n = new Nested();
    n.print();
    //Nested.inner inner =   n.new inner();
   // inner.print(); // class create using object
//if inner is static
	Nested.inner staticInner  = new Nested.inner();
	staticInner.print();
	
	
	

}}
