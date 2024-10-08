package object_cls;
public class Car  implements Cloneable {
//	data
        int carPrice;
        int yr;
        String carColor;
//  constructor
        Car(int cp, int y, String cc){
        	carPrice = cp;
        	yr =  y;
        	carColor = cc;}
// equal
        public boolean equals(Object obj ) {
        	if(this == obj) {
        		System.out.println("both are same place........");
        		return true;}
        	if(obj == null) {
        		System.out.println("obj is null........");
        		return false;}
        	if(this.getClass()!=obj.getClass()) {
        		System.out.println("class name not match...");
        	    return false;}
        	Car c = (Car)obj;
        	if(this.carColor==c.carColor&&this.carPrice==c.carPrice&&this.yr==c.yr) {
        		System.out.println("both are same contant ...different place");
        		return true;}
        	return false;
        }
//clone
        protected Object clone() throws CloneNotSupportedException {
        	return super.clone();}
//display
        void display() {
        	System.out.println("car price :" + carPrice);
        	System.out.println("car yr :" + yr);
        	System.out.println("car Color :" + carColor);
        }
}
