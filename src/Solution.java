import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int minPlays;
    private static int[] UP = {-1, 0};
    private static int[] DOWN = {1,0};
    private static int[] LEFT = {0,-1};
    private static int[] RIGHT = {0,1};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = new int[][]{UP, DOWN, LEFT, RIGHT};
        Queue<MazeSphere> queue = new LinkedList();
        queue.offer(new MazeSphere(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;
        minPlays = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {

            MazeSphere sphere = queue.poll();
            //System.out.println("CURR COORDS: " + sphere.x + " - " + sphere.y);


            // The furthest point in four directions
            for (int[] dir : dirs) {
                //System.out.println(sphere.x + " - " + sphere.y);
                int x = sphere.x + dir[0];
                int y = sphere.y + dir[1];
                //System.out.println(x + " - " + y);

                // move Furthest straight-line distance
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && (maze[x][y] == 0 || maze[x][y] == 2)) {
                    if (maze[x][y] == 2) {
                        sphere.numPlays++;
                        if (sphere.numPlays < minPlays)
                            minPlays = sphere.numPlays;
                        // System.out.println("Number of wall hits on correct path: " + minPlays);
                        return true;
                    }
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];
                //tou cofiante
                // Furthest (x,y)
                if (!visited[x][y]) {
                    //System.out.println(x + " - " + y);
                    sphere.numPlays++;
                    // System.out.println("NUM PLAYS: " + sphere.numPlays);
                    queue.add(new MazeSphere(x, y, sphere.numPlays));
                    visited[x][y] = true;
                }
                System.out.println("NUM PLAYS: " + sphere.numPlays);
            }
        }
        return false;
    }

    public int getMinPlays() {
        return minPlays;
    }
}