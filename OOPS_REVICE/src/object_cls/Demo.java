package object_cls;
public class Demo {
	public static void main(String[] args) throws CloneNotSupportedException {
    Car c1 = new Car(100000, 2021, "RED");
    Car c2 = new Car(100000, 2021, "RED");
    Car c3 = (Car) c1.clone();
    Car c4 = c1;
    c1.carPrice = 120000;
    System.out.println(c1==c2);
    System.out.println(c2.equals(c1));
    System.out.println(c3.equals(c1));
    System.out.println(c4.equals(c1));
    
	}

}
