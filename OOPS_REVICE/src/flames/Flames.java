package flames;
public class Flames {
	String name1= "barath";
	String name2= "hari"; 
	String match = "";
	int length;
	String f = "flamesflamesflamesflamesflamesflamesflamesflamesflamesflamesflamesflamesflamesflamesflamesflamesflamesflamesflamesflames";
// to find matching char
	void  delete() {
		for(int i=0; i<name1.length(); i++) {
			for(int j=0; j<name2.length(); j++) {
				if(name1.charAt(i)== name2.charAt(j))
					match = match+name1.charAt(i);}}
		for(int i=0; i<match.length(); i++) {d(match.charAt(i));}
		length = name1.length()+name2.length();}
//for delete all char in names
	void d(char c) {
		for(int i=0; i<name1.length(); i++) {
			if(name1.charAt(i)==c) {
				name1 =  name1.substring(0,i)+name1.substring(i+1);}}
		for(int j=0; j<name2.length();j++) {
			if(name2.charAt(j)==c) {
				name2 =  name2.substring(0,j)+name2.substring(j+1);}}}
//for display
	void display(){
		System.out.println("name1 is "+ name1);
		System.out.println("name2 is "+ name2);
		System.out.println("match is "+ match);}
// for delete a char in flames
	void delete(int i) {f = f.substring(0,i-1)+ f.substring(i);}
	void delete(char c) {
		for(int i=0; i<f.length(); i++) {
			if(f.charAt(i)==c) {
				f=  f.substring(0,i)+f.substring(i+1);}}}
   void find() {
	   int index =0;
	   for(int i=0; i<=length*6; i++) {
		   if(i<=length*3) {
		   if(i!=0 && i%length==0) {
			   delete(f.charAt((i-1)-index));
		       index++;
		       System.out.println(f);}}
		   
	      if(i>length*3) {
	    	  
	      }
	   
	   }}}
