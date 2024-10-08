package flames;

public class Application {
		     private String name;
		     private String Dname1;
		     private String Dname2;
		     CircularLinked list = new CircularLinked();
		     
	 public char getRelation(String n1, String n2 ){
		      String  name = n1+n2;
		      final int length = count(name);
		      list.insertchar("flames");
		      final char relation = list.jumpDel(length);
		      list.reset();
		      return relation;}
	  
	 public char getRelation(String n1, String n2, int i){
	         Dname1=n1; Dname2=n2;
	         int length=0;
	         while(DifCount()!=length) {
	         length = DifCount();}
	         list.insertchar("flames");
	         final char relation = list.jumpDel(length);
	         list.reset();
	         return relation;}
	     
	 private int count(String name) {
		     byte a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0,i=0,j=0,k=0,l=0,m=0;
		     byte n=0,o=0,p=0,q=0,r=0,s=0,t=0,u=0,v=0,w=0,x=0,y=0,z=0;
			 for(int num=0; num<name.length(); num++) {
				   char ch = name.charAt(num);
				   if(ch=='a'){a++;}if(ch=='b'){b++;}if(ch=='c'){c++;}if(ch=='d'){d++;}
				   if(ch=='e'){e++;}if(ch=='f'){f++;}if(ch=='g'){g++;}if(ch=='h'){h++;}
				   if(ch=='i'){i++;}if(ch=='j'){j++;}if(ch=='k'){k++;}if(ch=='l'){l++;}
				   if(ch=='m'){m++;}if(ch=='n'){n++;}if(ch=='o'){o++;}if(ch=='p'){p++;}
				   if(ch=='q'){q++;}if(ch=='r'){r++;}if(ch=='s'){s++;}if(ch=='t'){t++;}
				   if(ch=='u'){u++;}if(ch=='v'){v++;}if(ch=='w'){w++;}if(ch=='x'){x++;}
				   if(ch=='y'){y++;}if(ch=='z'){z++;}}
				   
				   if(a>=2) {a=0;} if(b>=2) {b=0;} if(c>=2) {c=0;} if(d>=2) {d=0;}
				   if(e>=2) {e=0;} if(f>=2) {f=0;} if(g>=2) {g=0;} if(h>=2) {h=0;}
				   if(i>=2) {i=0;} if(j>=2) {j=0;} if(k>=2) {k=0;} if(l>=2) {l=0;} 
				   if(m>=2) {m=0;} if(n>=2) {n=0;} if(o>=2) {o=0;} if(p>=2) {p=0;} 
				   if(q>=2) {q=0;} if(r>=2) {r=0;} if(s>=2) {s=0;} if(t>=2) {t=0;} 
				   if(u>=2) {u=0;} if(v==2) {v=0;} if(w>=2) {w=0;} if(x>=2) {x=0;} 
				   if(y>=2) {y=2;} if(z>=2) {z=0;} 
			  return a+b+c+d+e+f+g+h+i+j+k+l+m+n+o+p+q+r+s+t+u+v+w+x+y+z;}
	 
	  private int DifCount()	{	 
				Loop:
				   for(int i=0; i<Dname1.length(); i++) {
					for(int j=0; j<Dname2.length(); j++) {
						if(Dname1.charAt(i)==Dname2.charAt(j)) {
							charRemove(i,j);break Loop;}}} 
				name = Dname1+Dname2;
				return name.length();}
			
	  private void charRemove(int i, int j){
			   Dname1 = Dname1.substring(0,i)+Dname1.substring(i+1);
			   Dname2 = Dname2.substring(0,j)+Dname2.substring(j+1);}}



