package interfacees;
public class Demo {
	public static void main(String[] args) {
     Vehicle vc = new Car();
     Vehicle vb = new Bike();
     Car c = new Car();
     
     vc.ride();      // invokeing extended cls method
     vb.ride();       //invokeing extended cls method
     vb.selfRide();   //invokeing interface method with interface obj
     c.selfRide();   //invokeing interface method using extend cls obj
	}

}
