package rat_maze;
public class RatMaze {
       int maze[][]= new int[][] {
    	   {1,0,0,0},
    	   {1,1,0,0},
    	   {0,1,1,1},
    	   {0,0,0,1}};
       int sol[][]= new int[4][4];
       int row=0; int col=-1;
       
       void find() {
    	   while(row<=3 || col <=3) {print(sol);
    	       if(row==3 && col==3)
    	    	   break;
    		   if(isgo(row, col+1)) {
    			   sol[row][++col]=1;
    			   maze[row][++col]=2;
    			   continue;}
    		   if(isgo(row+1, col)) {
    			   sol[++row][col]=1;
    			   maze[++row][col]=2;
    			   continue;}
    		   if(isgo(row, col-1)) {
    			   sol[row][--col]=1;
    			   maze[row][--col]=2;
    			   continue;}
    		   if(isgo(row-1, col)) {
    			   sol[--row][col]=1;
    			   maze[--row][col]=2;
    			   continue;}}}
       
       boolean isgo(int row, int col) {
    	   if(-1<row && row<4 && -1<col && col<4)
    		   if(maze[row][col]==1)
    		     return true;
    	   if(maze[row][col]==2)
  		     return true;
    	   return false;}
	 void print(int arr[][]) {
		 for(int i=0; i<4; i++) {
			 for(int j=0; j<4; j++) 
				 System.out.print(arr[i][j]+" ");
			 System.out.println();
			 }System.out.println("\n\n");
	 }
       
}
