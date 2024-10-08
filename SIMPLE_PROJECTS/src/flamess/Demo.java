package flamess;
import java.util.*;
public class Demo {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
	// get local time change from GMT
		System.out.println("Enter hr change: ");
		int hrChange = s.nextInt();
		System.out.println("Enter min change: ");
		int minChange = s.nextInt();
	// get GMT Time
		long mSecends = System.currentTimeMillis();      // returns total milli secs GMT
		long secends = mSecends/1000;                    // total sec in GMT
		System.out.println("total secends: "+ secends);     
		System.out.println("current sec :"+ (secends%60));
		long minute = secends/60;                        // total minute in GMT
		System.out.println("total Minute: "+ minute);
		System.out.println("Current minute: "+ (minute%60));
		long hour = minute/60;                           // total hrs in GMT
		System.out.println("total hrs: "+ hour);
		System.out.println("Current hrs : "+(hour%24));
	//local time by GMT
		long localhr24 = ((hour)+(hrChange))%24;
		long localmin = (minute+minChange)%60;
		System.out.println("24 hr format: "+ localhr24+":"+localmin+":"+(secends%60));
		long localhr12 = ((hour)+(hrChange))%12;
		System.out.println("24 hr format: "+ localhr12+":"+localmin+":"+(secends%60));
	// that fn returns the total milli secends... it counts since that GMT started
		
		
		
}}
