package multithered.cls;

public class CLS2 extends Thread {
	public void run() {
	      for(int i=0; i<100; i++) {
	    	  System.out.println("CLS2 method is running");
	    	  
	    	  try {Thread.sleep(2000);}
			  catch (InterruptedException e) {e.printStackTrace();}}
	}}


