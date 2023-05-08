import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private int minPlays;
    private static final int[] UP = {-1, 0};
    private static final int[] DOWN = {1, 0};
    private static final int[] LEFT = {0, -1};
    private static final int[] RIGHT = {0, 1};

    public Solution() {
    }

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs = new int[][]{UP, DOWN, LEFT, RIGHT};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        int numPlays = 0;
        boolean flag = false;


        while (!queue.isEmpty()) {
            int level_size = queue.size();
            while (level_size-- != 0) {
                int[] s = queue.poll();
                for (int[] dir : dirs) {
                    int x = s[0] + dir[0];
                    int y = s[1] + dir[1];
                    while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && (maze[x][y] != 1)) {
                        if (x == destination[0] && y == destination[1]) {
                            flag = true;
                            break;
                        }
                        x += dir[0];
                        y += dir[1];
                    }
                    if(x < 0 || y < 0 || x >= maze.length || y >= maze[0].length)continue;
                    x -= dir[0];
                    y -= dir[1];
                    if (!visited[x][y]) {
                        queue.add(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            numPlays++;
            if (flag) break;
        }
        minPlays = numPlays;
        return flag;
    }

    public int getNumPlays() {
        return minPlays;
    }
}