package prac;
public class CLS2 implements Runnable{
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("hello from cls 2..........");
			try {Thread.sleep(3000);} catch (InterruptedException e) {}}}
}
