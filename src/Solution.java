import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int numPlays;

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue<int[]> queue = new LinkedList();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        numPlays = 0;

        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            System.out.println("CURR COORDS: " + s[0] + " - " + s[1]);


            // The furthest point in four directions
            for (int[] dir : dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];

                // move Furthest straight-line distance
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && (maze[x][y] == 0 || maze[x][y] == 2)) {
                    if (maze[x][y] == 2) {
                        System.out.println("Number of wall hits on correct path: " + numPlays);
                        return true;
                    }
                    x += dir[0];
                    y += dir[1];
                }
                x -= dir[0];
                y -= dir[1];

                // Furthest (x,y)
                if (!visited[x][y]) {
                    System.out.println(x + " - " + y);
                    queue.add(new int[]{x, y});
                    numPlays++;
                    visited[x][y] = true;
                }
            }
        }
        return false;
    }
}