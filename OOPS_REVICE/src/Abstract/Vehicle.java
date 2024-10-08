package Abstract;
public abstract class Vehicle {
   abstract void ride();
   void doing(Vehicle v)   {
	   v.ride();
   }
}
