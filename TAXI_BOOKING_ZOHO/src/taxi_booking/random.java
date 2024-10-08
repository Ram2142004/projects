package taxi_booking;
import java.util.Random;
public class random {
	 static Random r = new Random();
     public static int randInt(int val) {return  r.nextInt(val);}
     public static char randChar_ae() {return  (char) r.nextInt(97, 102);}
     public static char randChar() {return  (char) r.nextInt(97, 123);}
     public static float randFloat(int val) {return  r.nextFloat(val);}
     public static double randDouble(int val) {return  r.nextDouble(val);}
     public static String randString(int val) {
    	 String rand = "";
    	 for(int i=0; i<val; i++) {rand+=randChar();}
    	 return rand;}
     
}
