package DB;
import java.util.*;       //192.168.140.191
public class RatMaze {
		
		    private static final int[][] DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}}; // right, down, left, up

		    public  void findAllPaths(int[][] maze) {
		        List<List<int[]>> paths = new ArrayList<>();
		        boolean[][] visited = new boolean[maze.length][maze[0].length];
		        List<int[]> path = new ArrayList<>();
		        findAllPathsRecursive(maze, visited, 0, 0, path, paths);
		        System.out.println("total paths: "+paths.size());
		        for (List<int[]> pathe : paths) {
		            for (int[] coord : pathe) {
		                System.out.print("(" + coord[0] + "," + coord[1] + ") ");
		            }
		            System.out.println();
		    }  System.out.println("total paths: "+paths.size()); }

		     void findAllPathsRecursive(int[][] maze, boolean[][] visited, int row, int col, List<int[]> path, List<List<int[]>> paths) {
		        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length || maze[row][col] == 1 || visited[row][col]) {
		            return; // out of bounds or current cell is not a valid path
		        }

		        path.add(new int[]{row, col});
		        visited[row][col] = true;

		        if (row == maze.length - 1 && col == maze[0].length - 1) {
		            paths.add(new ArrayList<>(path)); // found a path to the end, add it to the paths list
		        } else {
		            for (int[] dir : DIRS) {
		                findAllPathsRecursive(maze, visited, row + dir[0], col + dir[1], path, paths);
		            }
		        }

		        visited[row][col] = false; // backtracking
		        path.remove(path.size() - 1);
		    }
}
		    

