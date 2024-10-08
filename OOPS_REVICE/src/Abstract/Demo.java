package Abstract;
public class Demo {
	public static void main(String[] args) {
		Vehicle c = new Car();
		Vehicle b = new Bike();
		c.doing(c);
		b.doing(b);
	}

}
