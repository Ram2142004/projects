package DSA.lenearSearch;

import oops_revice.Use;

public class LinearSearch {
	public static int find(int[]arr, int target) {
   	 for(int i=0; i<arr.length; i++) {
   		 if(arr[i]==target) { return i;}}
   	 return -1;}
	
	public static boolean contains(int[]arr, int target) {
		for(int i=0; i<arr.length; i++) {
	   		 if(arr[i]==target) {return true;}}
		return false;}
	
	public static int find(String str, char target) {
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)==target) {
				return i;}}
			return -1;}
	public static boolean contains(String str, char target) {
		for(int i=0; i<str.length(); i++) {
	   		 if(str.charAt(i)==target) {return true;}}
		return false;}
	public static int[] find(int[][]arr, int target) {
	   	 for(int i=0; i<arr.length; i++) {
	   		 for(int j=0; j<arr[i].length; j++) {
	   		 if(arr[i][j]==target) { return new int	[] {i, j};}}}
	   	 return new int [] {-1, -1};}
		
	public static boolean contains(int[][]arr, int target) {
	   	 for(int i=0; i<arr.length; i++) {
	   		 for(int j=0; j<arr[i].length; j++) {
	   		 if(arr[i][j]==target) { return true;}}}
	   	 return false;}
	public static int max(int []arr) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>max) {
				max = arr[i];}}
		return max;}
	public static int min(int []arr) {
		int max = Integer.MAX_VALUE;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]<max) {
				max = arr[i];}}
		return max;}
	public static int countOfChar(String str, char c) {
	    int count=0;
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)==c) {
				count++;}}
		return count;}
	public static int countofDigit(int[]arr, int digit) {
		int count=0;
		for(int i=0; i<arr.length; i++) {
			if(Use.digitCount(arr[i])==digit) {
				count++;}}
		return count;}
		
	}
	
	
   	 

