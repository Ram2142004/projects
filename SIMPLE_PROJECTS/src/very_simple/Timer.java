package very_simple;
public class Timer extends Thread {
	public static void main(String[] args) {
		
		
		for(int hr=0; hr<24;hr++) {
			for(int min=0; min<60; min++) {
				for(int sec=0; sec<60; sec++) {
					System.out.println(hr+":"+min+":"+sec);
					
					
					
					try{Thread.sleep(1000);}
					catch(Exception e) {}
				}}}
	
	}}


