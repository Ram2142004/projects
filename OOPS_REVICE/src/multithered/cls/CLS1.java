package multithered.cls;
public class CLS1 extends Thread{
	
	public void run(){
      for(int i=0; i<100; i++) {
    	  System.out.println("CLS1 method is running");
    	  
    	  try {Thread.sleep(3000);}
		  catch (InterruptedException e) {e.printStackTrace();}}
}}
