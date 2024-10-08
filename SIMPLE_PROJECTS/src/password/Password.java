package password;
public class Password {
      public static boolean isStrong(String str) {
    	  boolean numeric = false;
    	  boolean lowerCase = false;
    	  boolean upperCase = false;
    	  boolean space = true;
    	  boolean slash = true;
    	  boolean length= str.length()>=6;
    	  for(int i=0; i<str.length(); i++) {
    		 if(Character.isDigit(str.charAt(i))){numeric=true;}
    	     if(Character.isLowerCase(str.charAt(i))) {lowerCase=true;}
    	     if(Character.isUpperCase(str.charAt(i))) {upperCase=true;}
    	     if(str.charAt(i)==' ') {space=false;}
    	     if(str.charAt(i)=='/') {slash=false;}}
    	  return numeric&&lowerCase&&upperCase&&space&&slash&&length;
}}
