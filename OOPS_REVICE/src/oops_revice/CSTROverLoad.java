package oops_revice;

public class CSTROverLoad {
     String name;
     int age;
     CSTROverLoad(String n, int a){
    	 name = n;
    	 age = a;}
     CSTROverLoad(CSTROverLoad csol){
    	 name = csol.name;
    	 age = csol.age;}
     void disply(){
    	 System.out.println(name);
    	 System.out.println(age);
     }
     
}
