package DB;
import java.util.*;
public class Practise {
	public static void main(String[] args) {
		RatMaze r = new RatMaze();
		r.findAllPaths(createMaze(6));
	}
    static int[][] createMaze(int size){
    	int maze[][] = new int[size][size];
    	Random r = new Random();
    	for(int i=0; i<size; i++) 
    		for(int j=0; j<size; j++) 
    			maze[i][j]=Math.min(r.nextInt(0,2),r.nextInt(0,2));
    	print(maze);
    	return maze;
    }
    
    static void print(int arr[][]) {
    	for(int i=0; i<arr.length; i++) { 
    		for(int j=0; j<arr[0].length; j++) 
    			System.out.print(arr[i][j]+"  ");
    		System.out.println();}
    }
    }