package object_cls;
public class Primitive {
	public static void main(String[]args) {
       String s1 = "barath";
       String s2 = "barath";
       String s3 = new String("barath");
       String s4 = new String("barath");
       System.out.println(s1==s2);
       System.out.println(s1.equals(s2));
       System.out.println(s3==s4);
       System.out.println(s3.equals(s4));
}}
