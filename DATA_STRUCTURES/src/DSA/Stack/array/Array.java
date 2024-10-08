package DSA.Stack.array;
public class Array {
	private static final int initialCapacity = 2;
	private int[]arr;
	private int size;
	private int capacity;
	
	Array(){
		size =0;
		arr = new int[initialCapacity];
		capacity = initialCapacity;}
	
	public void add(int val) {
		if(size == capacity) {
			expandArray();}
		arr[size++]=val;
		System.out.println("Succes......");}
	
	public void display() {
		for(int i=0; i<size; i++) {
			System.out.print(arr[i]+" ");}System.out.println();}
	public void insertAtPos(int pos, int val) {
		if(size == capacity-1) {
			expandArray();}
		for(int i=size-1; i>=pos; i++) {
			arr[i+1] = arr[i];}
		    arr[pos] = val;
		    System.out.println("Succes......");}
	public void deleteAtPos(int pos) {
		for(int i=pos+1; i<size; i++) {
			arr[i-1]=arr[i];}
		     size--;
		     System.out.println("Succes......");
		if(capacity>initialCapacity && capacity > size*3)
		    shrinkArray();}
	public void getData() {
		System.out.println("Size : "+ size);
		System.out.println("Capacity : "+ capacity);
		System.out.println("ArrayLength :"+arr.length);}
     public int getPeek() {
    	 return capacity-1;}
     private void expandArray() {
    	 System.out.println("expanding...");
    	 capacity *=2;
    	 arr = java.util.Arrays.copyOf(arr, capacity); }
     private void shrinkArray() {
    	 System.out.println("Shrinking...");
    	 capacity/=2;
    	 arr = java.util.Arrays.copyOf(arr, capacity);}
     
}

	