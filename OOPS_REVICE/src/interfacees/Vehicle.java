package interfacees;
public interface Vehicle {
	int RIDEKMS = 50;
    void ride();
   default  void selfRide() {
    	System.out.println("i am a vehicle");
    	//RIDEKMS++;    // interface variables are static and final so cannot  change
    }
}
