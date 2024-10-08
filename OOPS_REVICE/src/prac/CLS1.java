package prac;
public class CLS1  implements Runnable{
	public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("hello from cls 1");
			try {Thread.sleep(2000);}catch (InterruptedException e) {};  }}}
