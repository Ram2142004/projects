package cone;
public class department implements Cloneable {
    String DeptName;
    String hod;
    protected Object clone() throws CloneNotSupportedException {
    	return super.clone();}
}
