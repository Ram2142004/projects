package oops_revice;
public class ObjReturn {
    int h;
    int w;
    int l;
    ObjReturn(int H, int W, int L){h=H; w=W; l=L;}
    ObjReturn Double(ObjReturn or) {
    	ObjReturn temp = new ObjReturn(h*2, w*2, l*2); 
        return temp;}
    void display() {
    	System.out.println(h);
    	System.out.println(w);
    	System.out.println(l);
    }
    
    
}
